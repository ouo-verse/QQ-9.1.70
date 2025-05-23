package com.tencent.mobileqq.wink.editor;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmaps", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkEditorFragment$initRecommendViewModel$3 extends Lambda implements Function1<List<? extends byte[]>, Unit> {
    final /* synthetic */ ArrayList<byte[]> $musicInfoBytes;
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorFragment$initRecommendViewModel$3(ArrayList<byte[]> arrayList, WinkEditorFragment winkEditorFragment) {
        super(1);
        this.$musicInfoBytes = arrayList;
        this.this$0 = winkEditorFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkEditorFragment this$0, List bitmaps, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qQCircleSmartMatchMusic$MusicInfoRsp == null) {
            str2 = this$0.tongKuanMusicMid;
            w53.b.g("WinkEditorFragment", "[observe] requestDetail fail mid:" + str2);
            ArrayList arrayList = new ArrayList();
            MusicSourceViewModel xk5 = this$0.xk();
            Intrinsics.checkNotNullExpressionValue(bitmaps, "bitmaps");
            MusicSourceViewModel.q3(xk5, bitmaps, arrayList, false, 4, null);
            return;
        }
        List<WinkEditorMusicInfo> j16 = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get()), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350");
        str3 = this$0.tongKuanMusicMid;
        w53.b.a("WinkEditorFragment", "[observe] mid:" + str3);
        MusicSourceViewModel xk6 = this$0.xk();
        Intrinsics.checkNotNullExpressionValue(bitmaps, "bitmaps");
        MusicSourceViewModel.q3(xk6, bitmaps, j16, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends byte[]> list) {
        invoke2((List<byte[]>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<byte[]> bitmaps) {
        WinkDataServiceHandler a16;
        String str;
        boolean Rm;
        String str2;
        String str3;
        w53.b.f("WinkEditorFragment", "[initRecommendViewModel] extractBitmapsLiveData onChanged");
        if (this.$musicInfoBytes == null) {
            str = this.this$0.tongKuanMusicMid;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.this$0.tongKuanMusicMid;
                if (!Intrinsics.areEqual("fakeMid_template_bgm", str2)) {
                    ArrayList arrayList = new ArrayList();
                    str3 = this.this$0.tongKuanMusicMid;
                    arrayList.add(str3);
                    final WinkEditorFragment winkEditorFragment = this.this$0;
                    WinkEditorMusicHelper.D(arrayList, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.ch
                        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str4, Object obj) {
                            WinkEditorFragment$initRecommendViewModel$3.b(WinkEditorFragment.this, bitmaps, baseRequest, z16, j3, str4, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
                        }
                    });
                }
            }
            MusicSourceViewModel xk5 = this.this$0.xk();
            Intrinsics.checkNotNullExpressionValue(bitmaps, "bitmaps");
            ArrayList arrayList2 = new ArrayList();
            Rm = this.this$0.Rm();
            xk5.p3(bitmaps, arrayList2, !Rm);
        }
        WinkDataServiceHandler a17 = com.tencent.mobileqq.wink.edit.manager.e.a();
        if (a17 != null) {
            a17.p3(new ArrayList(bitmaps), 2);
        }
        if ((this.this$0.Tk().getIsAutoTemplate() && !this.this$0.Tk().k3()) || this.this$0.Tk().getIsQCircleAutoTemplate() || this.this$0.Tk().getIsFromTemplateLib() || this.this$0.Tk().b2() || (a16 = com.tencent.mobileqq.wink.edit.manager.e.a()) == null) {
            return;
        }
        a16.o3(this.this$0.Tk().R2(), new ArrayList(bitmaps), 2);
    }
}
