package com.qzone.reborn.groupalbum.reship.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.base.k;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipSelectInitBean;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR#\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/part/GroupAlbumReshipSelectBarPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "coverUrl", "", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "v", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "albumBarLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvAlbumName", "Lcom/tencent/mobileqq/widget/RoundedImageView;", "f", "Lcom/tencent/mobileqq/widget/RoundedImageView;", "ivAlbumCover", "Lni/e;", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "G9", "()Lni/e;", "vm", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumReshipSelectBarPart extends k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View albumBarLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvAlbumName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundedImageView ivAlbumCover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public GroupAlbumReshipSelectBarPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ni.e>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipSelectBarPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ni.e invoke() {
                return (ni.e) GroupAlbumReshipSelectBarPart.this.getViewModel(ni.e.class);
            }
        });
        this.vm = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(String coverUrl) {
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        Option url = Option.obtain().setUrl(coverUrl);
        RoundedImageView roundedImageView = this.ivAlbumCover;
        if (roundedImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivAlbumCover");
            roundedImageView = null;
        }
        a16.h(url.setTargetView(roundedImageView).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
    }

    private final ni.e G9() {
        return (ni.e) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0) {
            RFWLog.d("GroupUploadSelectAlbumBarPart", RFWLog.USR, "onActivityResult, cancelled ");
        } else if (requestCode == 6667) {
            CommonAlbumInfo commonAlbumInfo = data != null ? (CommonAlbumInfo) data.getParcelableExtra("SELECTED_ALBUM_INFO") : null;
            if (commonAlbumInfo == null) {
                return;
            }
            G9().b2(commonAlbumInfo);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f81994fo) {
            EventCollector.getInstance().onViewClicked(v3);
            oi.c m3 = ho.i.m();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            String groupId = G9().getGroupId();
            CommonAlbumInfo value = G9().S1().getValue();
            m3.q(activity, 6667, new GroupAlbumReshipSelectInitBean(groupId, value != null ? value.getAlbumId() : null, G9().U1(), G9().getHasMore(), G9().getAttachInfo()));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View inflate = ((ViewStub) rootView.findViewById(R.id.f69353ii)).inflate();
            View findViewById = inflate.findViewById(R.id.f81994fo);
            findViewById.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "stubView.findViewById<Vi\u2026ectBarPart)\n            }");
            this.albumBarLayout = findViewById;
            View findViewById2 = inflate.findViewById(R.id.f1059567e);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "stubView.findViewById(R.id.tv_album_name)");
            this.tvAlbumName = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.xzv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "stubView.findViewById(R.id.iv_album_cover)");
            this.ivAlbumCover = (RoundedImageView) findViewById3;
        }
        LiveData<CommonAlbumInfo> S1 = G9().S1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumInfo, Unit> function1 = new Function1<CommonAlbumInfo, Unit>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipSelectBarPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonAlbumInfo commonAlbumInfo) {
                invoke2(commonAlbumInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonAlbumInfo commonAlbumInfo) {
                TextView textView;
                String a16;
                String str;
                textView = GroupAlbumReshipSelectBarPart.this.tvAlbumName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvAlbumName");
                    textView = null;
                }
                if (commonAlbumInfo == null || (a16 = commonAlbumInfo.getName()) == null) {
                    a16 = l.a(R.string.f2195466p);
                }
                textView.setText(a16);
                GroupAlbumReshipSelectBarPart groupAlbumReshipSelectBarPart = GroupAlbumReshipSelectBarPart.this;
                if (commonAlbumInfo == null || (str = k9.a.d(commonAlbumInfo, 0, 1, null)) == null) {
                    str = "";
                }
                groupAlbumReshipSelectBarPart.F9(str);
            }
        };
        S1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.reship.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumReshipSelectBarPart.H9(Function1.this, obj);
            }
        });
    }
}
