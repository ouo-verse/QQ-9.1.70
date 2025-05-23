package com.tencent.mobileqq.wink.editor.smartclip.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.builder.light.model.Event;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.render.extension.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import n73.AutoClipResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b?\u0010@J,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002JI\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J&\u0010\u0019\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016J>\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010R$\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010-\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020/038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00101R\u001f\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u000109038\u0006\u00a2\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u00107\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/WinkEditSmartClipViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/videocut/model/MediaClip;", "originClips", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "stuckPointInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "musicInfoWrapper", "Z1", "musicInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "success", "Lkotlin/Function0;", "failed", "Q1", "", "getLogTag", "mediaClips", "", ShortVideoConstants.PARAM_KEY_IS_TEMPLATE_MODE, "shouldTriggerSmartClip", "W1", "triggerSmartClip", "N1", "i", "Ljava/lang/String;", "O1", "()Ljava/lang/String;", "S1", "(Ljava/lang/String;)V", "currentBgmMid", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getDraftBgmMid", "T1", "draftBgmMid", BdhLogUtil.LogTag.Tag_Conn, "Z", "getNeedIgnoreDraftBgmApply", "()Z", "U1", "(Z)V", "needIgnoreDraftBgmApply", "Landroidx/lifecycle/MutableLiveData;", "Ln73/a;", "D", "Landroidx/lifecycle/MutableLiveData;", "_smartClipResultLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "smartClipResultLiveData", "Lcom/tencent/tavcut/core/render/builder/light/model/Event;", UserInfo.SEX_FEMALE, "_smartClipTemplateLiveData", "G", "getSmartClipTemplateLiveData", "smartClipTemplateLiveData", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditSmartClipViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean needIgnoreDraftBgmApply;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<AutoClipResult> _smartClipResultLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<AutoClipResult> smartClipResultLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Event> _smartClipTemplateLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Event> smartClipTemplateLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentBgmMid;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String draftBgmMid;

    public WinkEditSmartClipViewModel() {
        MutableLiveData<AutoClipResult> mutableLiveData = new MutableLiveData<>();
        this._smartClipResultLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.wink.editor.smartclip.model.AutoClipResult>");
        this.smartClipResultLiveData = mutableLiveData;
        MutableLiveData<Event> mutableLiveData2 = new MutableLiveData<>();
        this._smartClipTemplateLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.tavcut.core.render.builder.light.model.Event?>");
        this.smartClipTemplateLiveData = mutableLiveData2;
    }

    private final void Q1(final MusicInfoWrapper musicInfo, final Function1<? super QQCircleSmartMatchMusic$MusicStuckPointInfo, Unit> success, final Function0<Unit> failed) {
        String str;
        ArrayList arrayListOf;
        final long currentTimeMillis = System.currentTimeMillis();
        String[] strArr = new String[1];
        WinkEditorMusicInfo musicInfo2 = musicInfo.getMusicInfo();
        if (musicInfo2 == null || (str = musicInfo2.p()) == null) {
            str = "";
        }
        strArr[0] = str;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(strArr);
        WinkEditorMusicHelper.G(arrayListOf, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.smartclip.viewmodel.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                WinkEditSmartClipViewModel.R1(WinkEditSmartClipViewModel.this, musicInfo, failed, success, currentTimeMillis, baseRequest, z16, j3, str2, (QQCircleSmartMatchMusic$MusicStuckPointInfoRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r3 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void R1(WinkEditSmartClipViewModel this$0, MusicInfoWrapper musicInfo, Function0 function0, Function1 function1, long j3, BaseRequest baseRequest, boolean z16, long j16, String str, QQCircleSmartMatchMusic$MusicStuckPointInfoRsp qQCircleSmartMatchMusic$MusicStuckPointInfoRsp) {
        String str2;
        Object orNull;
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(musicInfo, "$musicInfo");
        String str3 = null;
        if (z16 && qQCircleSmartMatchMusic$MusicStuckPointInfoRsp != null) {
            List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list = qQCircleSmartMatchMusic$MusicStuckPointInfoRsp.stuckPointInfo.get();
            if (list == null) {
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            WinkEditorMusicInfo musicInfo2 = musicInfo.getMusicInfo();
            if (musicInfo2 != null) {
                str2 = musicInfo2.p();
            } else {
                str2 = null;
            }
            QLog.d("WinkSmartClipViewModel", 4, "Request stuck point info success: mid = " + str2 + " " + list.size());
            a.f321532a.i(list);
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo = (QQCircleSmartMatchMusic$MusicStuckPointInfo) orNull;
            if (qQCircleSmartMatchMusic$MusicStuckPointInfo != null) {
                if (function1 != null) {
                    function1.invoke(qQCircleSmartMatchMusic$MusicStuckPointInfo);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            }
            if (function0 != null) {
                function0.invoke();
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            if (function0 != null) {
                function0.invoke();
            }
            QLog.e("WinkSmartClipViewModel", 4, "Request stuck point info error: code = " + j16 + ", msg = " + str);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            if (companion2.d().u("QCIRCLE")) {
                WinkPublishQualityReportData.Builder traceId = new WinkPublishQualityReportData.Builder().eventId("E_MUSIC_STUCK_POINT").traceId(companion2.d().getTraceId());
                WinkEditorMusicInfo musicInfo3 = musicInfo.getMusicInfo();
                if (musicInfo3 != null) {
                    str3 = musicInfo3.p();
                }
                WinkPublishQualityReportData reportData = traceId.ext1(str3).ext2(String.valueOf(System.currentTimeMillis() - j3)).retCode(String.valueOf(j16)).getReportData();
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion2.d().k().b());
                }
            }
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public static /* synthetic */ void X1(WinkEditSmartClipViewModel winkEditSmartClipViewModel, List list, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        winkEditSmartClipViewModel.W1(list, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MediaClip> Z1(List<? extends MediaClip> originClips, QQCircleSmartMatchMusic$MusicStuckPointInfo stuckPointInfo, MusicInfoWrapper musicInfoWrapper) {
        boolean isBlank;
        AutoClipResult c16 = com.tencent.mobileqq.wink.editor.smartclip.c.c(e.m(originClips), musicInfoWrapper.f(stuckPointInfo), a.f321532a.b());
        if (!c16.getIsSuccess()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(c16.getTipString());
            if (!isBlank) {
                QQToast.makeText(BaseApplication.getContext(), c16.getTipString(), 0).show();
            }
        }
        this._smartClipResultLiveData.setValue(c16);
        return c16.c();
    }

    public final void N1(@NotNull final MusicInfoWrapper musicInfo, @NotNull final List<? extends MediaClip> mediaClips, final boolean triggerSmartClip, boolean isTemplateMode, @Nullable final Function0<Unit> failed) {
        String p16;
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo = null;
        if (this.needIgnoreDraftBgmApply) {
            String str2 = this.draftBgmMid;
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str3 = this.draftBgmMid;
                WinkEditorMusicInfo musicInfo2 = musicInfo.getMusicInfo();
                if (musicInfo2 != null) {
                    str = musicInfo2.p();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str3, str)) {
                    return;
                }
            }
        }
        this.needIgnoreDraftBgmApply = false;
        WinkEditorMusicInfo musicInfo3 = musicInfo.getMusicInfo();
        if (musicInfo3 != null && (p16 = musicInfo3.p()) != null) {
            qQCircleSmartMatchMusic$MusicStuckPointInfo = a.f321532a.d(p16);
        }
        if (qQCircleSmartMatchMusic$MusicStuckPointInfo != null) {
            if (triggerSmartClip) {
                a.isUserOpCloseSmartClip = false;
                Z1(mediaClips, qQCircleSmartMatchMusic$MusicStuckPointInfo, musicInfo);
                return;
            }
            return;
        }
        if (musicInfo.getMusicInfo() != null && !com.tencent.mobileqq.wink.editor.smartclip.a.a(musicInfo)) {
            Q1(musicInfo, new Function1<QQCircleSmartMatchMusic$MusicStuckPointInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.viewmodel.WinkEditSmartClipViewModel$doOnMusicChange$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo2) {
                    invoke2(qQCircleSmartMatchMusic$MusicStuckPointInfo2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQCircleSmartMatchMusic$MusicStuckPointInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (triggerSmartClip) {
                        a.isUserOpCloseSmartClip = false;
                        this.Z1(mediaClips, it, musicInfo);
                    }
                }
            }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.viewmodel.WinkEditSmartClipViewModel$doOnMusicChange$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0<Unit> function0 = failed;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        }
    }

    @Nullable
    /* renamed from: O1, reason: from getter */
    public final String getCurrentBgmMid() {
        return this.currentBgmMid;
    }

    @NotNull
    public final LiveData<AutoClipResult> P1() {
        return this.smartClipResultLiveData;
    }

    public final void S1(@Nullable String str) {
        this.currentBgmMid = str;
    }

    public final void T1(@Nullable String str) {
        this.draftBgmMid = str;
    }

    public final void U1(boolean z16) {
        this.needIgnoreDraftBgmApply = z16;
    }

    public final void W1(@NotNull List<? extends MediaClip> mediaClips, boolean isTemplateMode, boolean shouldTriggerSmartClip) {
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        if (!a.isUserOpCloseSmartClip && shouldTriggerSmartClip) {
            mediaClips = e.m(mediaClips);
        }
        this._smartClipResultLiveData.setValue(new AutoClipResult(true, "", mediaClips));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkSmartClipViewModel";
    }
}
