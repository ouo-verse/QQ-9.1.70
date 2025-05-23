package com.qzone.reborn.albumx.common.section.selectalbum;

import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.l;
import com.qzone.reborn.widget.QZoneSwipeMenuLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import l9.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH$J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J*\u0010\u0016\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014R\u0016\u0010\u0019\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u001b\u0010+\u001a\u00020\t8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/albumx/common/section/selectalbum/CommonSelectAlbumItemContentSection;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/h;", "", "y", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "D", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/common/viewmodel/l;", UserInfo.SEX_FEMALE, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "H", "e", "Landroid/view/View;", "rootLayout", "Lcom/qzone/reborn/widget/QZoneSwipeMenuLayout;", "f", "Lcom/qzone/reborn/widget/QZoneSwipeMenuLayout;", "swipeLayout", "Lcom/tencent/mobileqq/widget/RoundedImageView;", tl.h.F, "Lcom/tencent/mobileqq/widget/RoundedImageView;", "ivCover", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tvName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tvCount", "Lkotlin/Lazy;", "G", "()Lcom/qzone/reborn/albumx/common/viewmodel/l;", "vm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonSelectAlbumItemContentSection extends l<com.qzone.reborn.albumx.common.bean.h> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View rootLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneSwipeMenuLayout swipeLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RoundedImageView ivCover;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvCount;

    public CommonSelectAlbumItemContentSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.albumx.common.viewmodel.l>() { // from class: com.qzone.reborn.albumx.common.section.selectalbum.CommonSelectAlbumItemContentSection$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.albumx.common.viewmodel.l invoke() {
                return CommonSelectAlbumItemContentSection.this.F();
            }
        });
        this.vm = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A(CommonSelectAlbumItemContentSection this$0, i iVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        iVar.G5((com.qzone.reborn.albumx.common.bean.h) mData);
    }

    private final void C(com.qzone.reborn.albumx.common.bean.h item) {
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        RoundedImageView roundedImageView = null;
        Option url = Option.obtain().setUrl(k9.a.d(item.getAlbumInfo(), 0, 1, null));
        RoundedImageView roundedImageView2 = this.ivCover;
        if (roundedImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
        } else {
            roundedImageView = roundedImageView2;
        }
        a16.h(url.setTargetView(roundedImageView).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
    }

    private final void D(com.qzone.reborn.albumx.common.bean.h item) {
        TextView textView = this.tvName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvName");
            textView = null;
        }
        textView.setText(item.getAlbumInfo().getName());
    }

    private final void x(com.qzone.reborn.albumx.common.bean.h item) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%d\u5f20", Arrays.copyOf(new Object[]{Long.valueOf(item.getAlbumInfo().getUploadNumber())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        TextView textView = this.tvCount;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvCount");
            textView = null;
        }
        textView.setText(format);
    }

    private final void y() {
        View view = this.rootLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.common.section.selectalbum.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonSelectAlbumItemContentSection.z(CommonSelectAlbumItemContentSection.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(final CommonSelectAlbumItemContentSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(i.class).originView(view).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.common.section.selectalbum.b
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                CommonSelectAlbumItemContentSection.A(CommonSelectAlbumItemContentSection.this, (i) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: com.qzone.reborn.albumx.common.section.selectalbum.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                CommonSelectAlbumItemContentSection.B(str);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract com.qzone.reborn.albumx.common.viewmodel.l F();

    protected final com.qzone.reborn.albumx.common.viewmodel.l G() {
        return (com.qzone.reborn.albumx.common.viewmodel.l) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162970nm0};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.albumx.common.bean.h data, int position, List<Object> payload) {
        if (data == null) {
            return;
        }
        y();
        C(data);
        D(data);
        x(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.m7p);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_root)");
            this.rootLayout = findViewById;
            View findViewById2 = containerView.findViewById(R.id.ng_);
            QZoneSwipeMenuLayout qZoneSwipeMenuLayout = (QZoneSwipeMenuLayout) findViewById2;
            if (!G().Q1()) {
                qZoneSwipeMenuLayout.setSwipeEnable(false);
            }
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<QZoneSwipeM\u2026          }\n            }");
            this.swipeLayout = qZoneSwipeMenuLayout;
            View findViewById3 = containerView.findViewById(R.id.kuq);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_cover)");
            this.ivCover = (RoundedImageView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.njc);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_name)");
            this.tvName = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.nij);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_count)");
            this.tvCount = (TextView) findViewById5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String str) {
    }
}
