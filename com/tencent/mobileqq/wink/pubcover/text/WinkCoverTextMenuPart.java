package com.tencent.mobileqq.wink.pubcover.text;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.editor.sticker.text.TextMenuBgView;
import com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment;
import com.tencent.mobileqq.wink.pubcover.s;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/text/WinkCoverTextMenuPart;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;", "", "B9", "Lcom/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment;", "cd", "", "wb", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "model", "Lcom/tencent/mobileqq/wink/pubcover/s;", "stickerHelper", "bd", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Fb", "Jb", "Landroid/graphics/Bitmap;", "gb", "", "isTemplateText", "Ya", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "fb", "()Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "applyMaterialTask", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkCoverTextMenuPart extends WinkEditorTextMenuPart {

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/pubcover/text/WinkCoverTextMenuPart$a", "Lcom/tencent/mobileqq/wink/flow/a;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "", "F1", "g", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends com.tencent.mobileqq.wink.flow.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void F1(@NotNull ApplyMaterialTask.Status downloadStatus, int position, @NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
            Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (m.W(material)) {
                super.F1(downloadStatus, position, material, callback);
            } else {
                l.K(material, callback);
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void g(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            WinkCoverTextMenuPart.this.qb().M1(material);
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public boolean z(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            if (!Intrinsics.areEqual("TEXT_DEFAULT_DEFAULT_ID", material.f30533id) && !Intrinsics.areEqual("TEXT_PATTERN_NON_ID", material.f30533id) && !Intrinsics.areEqual("TEXT_DECOR_NON_ID", material.f30533id)) {
                return super.z(position, material);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dd(WinkCoverTextMenuPart this$0, WinkStickerModel winkStickerModel) {
        List<WinkStickerModel> listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkCoverSelectFragment cd5 = this$0.cd();
        if (cd5 != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(winkStickerModel);
            cd5.bj(listOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ed(WinkCoverTextMenuPart this$0, MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkCoverSelectFragment cd5 = this$0.cd();
        if (metaMaterial != null && cd5 != null) {
            cd5.ei(metaMaterial);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fd(WinkCoverTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorTextMenuPart.cb(this$0, false, 0, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gd(WinkCoverTextMenuPart this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.qb().P1(v3, v3.getId(), this$0.sb());
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hd(WinkCoverTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorTextMenuPart.cb(this$0, true, 0, 2, null);
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(7, 100));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart, com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.u_n;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Fb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.pubcover.text.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkCoverTextMenuPart.gd(WinkCoverTextMenuPart.this, view);
            }
        };
        sc((LinearLayout) rootView.findViewById(R.id.z3e));
        TextView textView = (TextView) rootView.findViewById(R.id.ybm);
        ImageView imageView = null;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        } else {
            textView = null;
        }
        rc(textView);
        TextView textView2 = (TextView) rootView.findViewById(R.id.f94975dq);
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        } else {
            textView2 = null;
        }
        xc(textView2);
        TextView textView3 = (TextView) rootView.findViewById(R.id.f94875dg);
        if (textView3 != null) {
            textView3.setOnClickListener(onClickListener);
        } else {
            textView3 = null;
        }
        wc(textView3);
        TextView textView4 = (TextView) rootView.findViewById(R.id.f94755d5);
        if (textView4 != null) {
            textView4.setOnClickListener(onClickListener);
        } else {
            textView4 = null;
        }
        uc(textView4);
        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.f164882u45);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.pubcover.text.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkCoverTextMenuPart.hd(WinkCoverTextMenuPart.this, view);
                }
            });
            imageView = imageView2;
        }
        tc(imageView);
        rootView.findViewById(R.id.tld).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.pubcover.text.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkCoverTextMenuPart.fd(WinkCoverTextMenuPart.this, view);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Jb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Ya(boolean isTemplateText) {
        int i3;
        TextMenuBgView textMenuBgView = getTextMenuBgView();
        if (textMenuBgView != null) {
            textMenuBgView.d(isTemplateText, new Function0<Size>() { // from class: com.tencent.mobileqq.wink.pubcover.text.WinkCoverTextMenuPart$adjustMask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Size invoke() {
                    WinkCoverSelectFragment cd5 = WinkCoverTextMenuPart.this.cd();
                    ViewGroup ki5 = cd5 != null ? cd5.ki() : null;
                    if (ki5 == null) {
                        return null;
                    }
                    return new Size(ki5.getMeasuredWidth(), ki5.getMeasuredHeight());
                }
            });
        }
        TextMenuBgView textMenuBgView2 = getTextMenuBgView();
        if (textMenuBgView2 != null) {
            if (isTemplateText) {
                i3 = R.color.ckv;
            } else {
                i3 = R.color.bdd;
            }
            textMenuBgView2.l(isTemplateText, i3, new Function0<Bitmap>() { // from class: com.tencent.mobileqq.wink.pubcover.text.WinkCoverTextMenuPart$adjustMask$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Bitmap invoke() {
                    return WinkCoverTextMenuPart.this.gb();
                }
            });
        }
    }

    public final void bd(@NotNull WinkStickerModel model, @NotNull s stickerHelper) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(stickerHelper, "stickerHelper");
        if (model.isTemplateTextSticker()) {
            qb().F2(model);
            qb().I2(1);
            return;
        }
        if (model.isBackgroundTextSticker()) {
            qb().F2(model);
            qb().I2(2);
        } else if (model.isTextSticker()) {
            qb().F2(model);
            stickerHelper.k(model);
            qb().I2(0);
        } else {
            ms.a.c(this.TAG, "sticker can not edit as text: " + model);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WinkCoverSelectFragment cd() {
        if (getHostFragment() instanceof WinkCoverSelectFragment) {
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNull(hostFragment, "null cannot be cast to non-null type com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment");
            return (WinkCoverSelectFragment) hostFragment;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    @NotNull
    protected ApplyMaterialTask fb() {
        if (getMApplyMaterialTask() == null) {
            oc(new a());
        }
        ApplyMaterialTask mApplyMaterialTask = getMApplyMaterialTask();
        Intrinsics.checkNotNull(mApplyMaterialTask);
        return mApplyMaterialTask;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    @Nullable
    public Bitmap gb() {
        View view;
        TextureView textureView;
        ViewGroup ki5;
        WinkCoverSelectFragment cd5 = cd();
        if (cd5 != null && (ki5 = cd5.ki()) != null) {
            view = ki5.getChildAt(0);
        } else {
            view = null;
        }
        if (view instanceof TextureView) {
            textureView = (TextureView) view;
        } else {
            textureView = null;
        }
        if (textureView == null) {
            return null;
        }
        return textureView.getBitmap();
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void wb() {
        qb().e2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.pubcover.text.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkCoverTextMenuPart.dd(WinkCoverTextMenuPart.this, (WinkStickerModel) obj);
            }
        });
        qb().S1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.pubcover.text.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkCoverTextMenuPart.ed(WinkCoverTextMenuPart.this, (MetaMaterial) obj);
            }
        });
    }
}
