package com.qzone.reborn.albumx.common.part;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0004J\b\u0010\u0013\u001a\u00020\u000bH\u0004J\b\u0010\u0014\u001a\u00020\u000bH$J\b\u0010\u0015\u001a\u00020\u000bH$J\b\u0010\u0016\u001a\u00020\u000bH$J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J \u0010 \u001a\u00020\u00052\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH$J \u0010!\u001a\u00020\u00052\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH$J \u0010\"\u001a\u00020\u00052\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH$J \u0010#\u001a\u00020\u00052\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0014J \u0010$\u001a\u00020\u00052\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0014R\"\u0010,\u001a\u00020%8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00106\u001a\u00020-8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b1\u0010/\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u00020-8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b7\u0010/\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\"\u0010>\u001a\u00020-8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b;\u0010/\u001a\u0004\b<\u00103\"\u0004\b=\u00105R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010F\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010AR$\u0010J\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010/\u001a\u0004\bH\u00103\"\u0004\bI\u00105R$\u0010N\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010/\u001a\u0004\bL\u00103\"\u0004\bM\u00105R\"\u0010V\u001a\u00020O8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010X\u00a8\u0006^"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/i;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "X9", "aa", "Z9", "Y9", "ba", "", "isOperateMode", "T9", "Landroid/view/animation/Animation;", "M9", "N9", "onInitView", "ca", "da", "V9", "U9", "W9", "", "selectCount", "na", "v", NodeProps.ON_CLICK, "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "Q9", "P9", "S9", "R9", "O9", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "d", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "L9", "()Lcom/qzone/reborn/albumx/common/viewmodel/e;", "ma", "(Lcom/qzone/reborn/albumx/common/viewmodel/e;)V", "operateViewModel", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "llOperateLayout", "f", "I9", "()Landroid/widget/LinearLayout;", LocaleUtils.L_JAPANESE, "(Landroid/widget/LinearLayout;)V", "llDownload", tl.h.F, "H9", "ia", "llDelete", "i", "K9", "la", "llReship", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "ivDownload", BdhLogUtil.LogTag.Tag_Conn, "ivDelete", "D", "ivReship", "E", "G9", "setLlChangeAlbum", "llChangeAlbum", UserInfo.SEX_FEMALE, "J9", "setLlMore", "llMore", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "G", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "F9", "()Lcom/qzone/reborn/albumx/common/viewmodel/b;", "ha", "(Lcom/qzone/reborn/albumx/common/viewmodel/b;)V", "albumViewModel", "H", "Landroid/view/animation/Animation;", "slideInBottom", "I", "slideOutBottom", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class i extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView ivDelete;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView ivReship;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout llChangeAlbum;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout llMore;

    /* renamed from: G, reason: from kotlin metadata */
    protected com.qzone.reborn.albumx.common.viewmodel.b albumViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private Animation slideInBottom;

    /* renamed from: I, reason: from kotlin metadata */
    private Animation slideOutBottom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected com.qzone.reborn.albumx.common.viewmodel.e operateViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llOperateLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected LinearLayout llDownload;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected LinearLayout llDelete;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected LinearLayout llReship;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView ivDownload;

    private final Animation M9() {
        if (this.slideInBottom == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155030h6);
            loadAnimation.setAnimationListener(new a());
            this.slideInBottom = loadAnimation;
        }
        return this.slideInBottom;
    }

    private final Animation N9() {
        if (this.slideOutBottom == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155032h8);
            loadAnimation.setAnimationListener(new b());
            this.slideOutBottom = loadAnimation;
        }
        return this.slideOutBottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(i this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.T9(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(i this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.na(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.qzone.reborn.albumx.common.viewmodel.b F9() {
        com.qzone.reborn.albumx.common.viewmodel.b bVar = this.albumViewModel;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G9, reason: from getter */
    public final LinearLayout getLlChangeAlbum() {
        return this.llChangeAlbum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout H9() {
        LinearLayout linearLayout = this.llDelete;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llDelete");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout I9() {
        LinearLayout linearLayout = this.llDownload;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llDownload");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J9, reason: from getter */
    public final LinearLayout getLlMore() {
        return this.llMore;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout K9() {
        LinearLayout linearLayout = this.llReship;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llReship");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.qzone.reborn.albumx.common.viewmodel.e L9() {
        com.qzone.reborn.albumx.common.viewmodel.e eVar = this.operateViewModel;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
    }

    protected abstract void P9(ArrayList<CommonStMedia> mediaList);

    protected abstract void Q9(ArrayList<CommonStMedia> mediaList);

    protected void R9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
    }

    protected abstract void S9(ArrayList<CommonStMedia> mediaList);

    protected abstract boolean U9();

    protected abstract boolean V9();

    protected abstract boolean W9();

    protected final boolean ca() {
        return true;
    }

    protected final boolean da() {
        return true;
    }

    protected final void ha(com.qzone.reborn.albumx.common.viewmodel.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.albumViewModel = bVar;
    }

    protected final void ia(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.llDelete = linearLayout;
    }

    protected final void ja(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.llDownload = linearLayout;
    }

    protected final void la(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.llReship = linearLayout;
    }

    protected final void ma(com.qzone.reborn.albumx.common.viewmodel.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.operateViewModel = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f162756mg4) {
            Q9(L9().W1());
        } else if (valueOf != null && valueOf.intValue() == R.id.f162754mg2) {
            P9(L9().W1());
        } else if (valueOf != null && valueOf.intValue() == R.id.mgf) {
            S9(L9().W1());
        } else if (valueOf != null && valueOf.intValue() == R.id.mga) {
            R9(L9().W1());
        } else if (valueOf != null && valueOf.intValue() == R.id.meh) {
            O9(L9().W1());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mgc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ll_operate_layout)");
        this.llOperateLayout = (LinearLayout) findViewById;
        Z9(rootView);
        Y9(rootView);
        ba(rootView);
        X9(rootView);
        aa(rootView);
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, rootView, null);
        com.qzone.reborn.albumx.common.viewmodel.b Ne = cVar != null ? cVar.Ne() : null;
        Intrinsics.checkNotNull(Ne);
        ha(Ne);
        l9.c cVar2 = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, rootView, null);
        com.qzone.reborn.albumx.common.viewmodel.e qf5 = cVar2 != null ? cVar2.qf() : null;
        Intrinsics.checkNotNull(qf5);
        qf5.d2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.common.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.ea(i.this, (Boolean) obj);
            }
        });
        qf5.a2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.common.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.ga(i.this, (Integer) obj);
            }
        });
        ma(qf5);
    }

    private final void T9(boolean isOperateMode) {
        LinearLayout linearLayout = null;
        if (isOperateMode) {
            L9().l2(F9().N1());
            CommonAlbumInfo value = F9().M1().getValue();
            if (value != null) {
                L9().k2(value);
            }
            LinearLayout linearLayout2 = this.llOperateLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llOperateLayout");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.startAnimation(M9());
            return;
        }
        LinearLayout linearLayout3 = this.llOperateLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llOperateLayout");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.startAnimation(N9());
    }

    private final void X9(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.meh);
        this.llChangeAlbum = linearLayout;
        if (linearLayout != null) {
            Boolean valueOf = Boolean.valueOf(ca());
            linearLayout.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, linearLayout)) == null) {
                linearLayout.setVisibility(8);
            }
            linearLayout.setOnClickListener(this);
            rn.h.a((ImageView) rootView.findViewById(R.id.kuj), "qui_transfer", R.color.qui_common_icon_primary);
        }
    }

    private final void Y9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f162754mg2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ll_delete)");
        ia((LinearLayout) findViewById);
        View findViewById2 = rootView.findViewById(R.id.kwd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_delete)");
        ImageView imageView = (ImageView) findViewById2;
        this.ivDelete = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
            imageView = null;
        }
        rn.h.a(imageView, "qui_delete", R.color.qui_common_icon_primary);
        if (U9()) {
            H9().setVisibility(0);
            ImageView imageView3 = this.ivDelete;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(0);
            H9().setOnClickListener(this);
            return;
        }
        H9().setVisibility(8);
        ImageView imageView4 = this.ivDelete;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(8);
    }

    private final void Z9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f162756mg4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ll_download)");
        ja((LinearLayout) findViewById);
        View findViewById2 = rootView.findViewById(R.id.l0q);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_download)");
        ImageView imageView = (ImageView) findViewById2;
        this.ivDownload = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivDownload");
            imageView = null;
        }
        rn.h.a(imageView, "qui_download", R.color.qui_common_icon_primary);
        if (V9()) {
            I9().setVisibility(0);
            ImageView imageView3 = this.ivDownload;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivDownload");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(0);
            I9().setOnClickListener(this);
            return;
        }
        I9().setVisibility(8);
        ImageView imageView4 = this.ivDownload;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivDownload");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(8);
    }

    private final void aa(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.mga);
        this.llMore = linearLayout;
        if (linearLayout != null) {
            Boolean valueOf = Boolean.valueOf(da());
            linearLayout.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, linearLayout)) == null) {
                linearLayout.setVisibility(8);
            }
            linearLayout.setOnClickListener(this);
            rn.h.a((ImageView) rootView.findViewById(R.id.ljh), "qui_more_light", R.color.qui_common_icon_primary);
        }
    }

    private final void ba(View rootView) {
        View findViewById = rootView.findViewById(R.id.mgf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ll_reship)");
        la((LinearLayout) findViewById);
        View findViewById2 = rootView.findViewById(R.id.lqt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_reship)");
        ImageView imageView = (ImageView) findViewById2;
        this.ivReship = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivReship");
            imageView = null;
        }
        rn.h.a(imageView, "qui_copy_light", R.color.qui_common_icon_primary);
        if (W9()) {
            K9().setVisibility(0);
            ImageView imageView3 = this.ivReship;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivReship");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(0);
            K9().setOnClickListener(this);
            return;
        }
        K9().setVisibility(8);
        ImageView imageView4 = this.ivReship;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivReship");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(8);
    }

    protected void na(int selectCount) {
        if (selectCount <= 0) {
            H9().setAlpha(0.5f);
            I9().setAlpha(0.5f);
            K9().setAlpha(0.5f);
            LinearLayout linearLayout = this.llChangeAlbum;
            if (linearLayout != null) {
                linearLayout.setAlpha(0.5f);
            }
            LinearLayout linearLayout2 = this.llMore;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setAlpha(0.5f);
            return;
        }
        H9().setAlpha(1.0f);
        I9().setAlpha(1.0f);
        K9().setAlpha(selectCount > 100 ? 0.5f : 1.0f);
        LinearLayout linearLayout3 = this.llChangeAlbum;
        if (linearLayout3 != null) {
            linearLayout3.setAlpha(0.5f);
        }
        LinearLayout linearLayout4 = this.llMore;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setAlpha(0.5f);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/albumx/common/part/i$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LinearLayout linearLayout = i.this.llOperateLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llOperateLayout");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/albumx/common/part/i$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LinearLayout linearLayout = i.this.llOperateLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llOperateLayout");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
