package com.tencent.mobileqq.wink.editor.sticker.text;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContent;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContentWrapper;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel;
import com.tencent.mobileqq.wink.editor.subtitle.l;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorSubtitleTextMenuPart;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;", "", "bd", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "stickerModelMap", "id", "", "stickerMap", "jd", "Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "cc", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "wb", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Fb", "cd", "categoryId", "Gc", "Landroid/os/Bundle;", "args", "L9", "hc", "", "onBackEvent", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "I0", "Lkotlin/Lazy;", "dd", "()Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "winkSubtitleViewModel", "J0", "Z", "isPlayerPlaying", "<init>", "()V", "K0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorSubtitleTextMenuPart extends WinkEditorTextMenuPart {

    /* renamed from: I0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkSubtitleViewModel;

    /* renamed from: J0, reason: from kotlin metadata */
    private boolean isPlayerPlaying;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorSubtitleTextMenuPart$b", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/widget/TextView;", "v", "", "actionId", "Landroid/view/KeyEvent;", "event", "", "onEditorAction", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(@Nullable TextView v3, int actionId, @Nullable KeyEvent event) {
            boolean z16;
            if (actionId == 6) {
                WinkEditorSubtitleTextMenuPart.this.cd();
                z16 = true;
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onEditorAction(v3, actionId, event);
            return z16;
        }
    }

    public WinkEditorSubtitleTextMenuPart() {
        Lazy lazy;
        Bc(true);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkSubtitleViewModel>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorSubtitleTextMenuPart$winkSubtitleViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkSubtitleViewModel invoke() {
                return (WinkSubtitleViewModel) WinkEditorSubtitleTextMenuPart.this.getViewModel(WinkSubtitleViewModel.class);
            }
        });
        this.winkSubtitleViewModel = lazy;
    }

    private final void bd() {
        WinkEditorTextMenuPart.cb(this, false, 0, 2, null);
    }

    private final WinkSubtitleViewModel dd() {
        Object value = this.winkSubtitleViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkSubtitleViewModel>(...)");
        return (WinkSubtitleViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ed(WinkEditorSubtitleTextMenuPart this$0, Map stickerModelMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stickerModelMap, "stickerModelMap");
        this$0.id(stickerModelMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fd(WinkEditorSubtitleTextMenuPart this$0, MenuType menuType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuType, "menuType");
        if (menuType == this$0.ba()) {
            this$0.bd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gd(WinkEditorSubtitleTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cd();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hd(WinkEditorSubtitleTextMenuPart this$0, View view) {
        dr H9;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isPlayerPlaying && (H9 = this$0.H9()) != null) {
            H9.play();
        }
        WinkEditorTextMenuPart.cb(this$0, false, 0, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void id(Map<WinkStickerModel, MetaMaterial> stickerModelMap) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map<String, WinkStickerModel> mutableMap;
        WinkStickerModel winkStickerModel;
        dr H9 = H9();
        WinkEditorFragment F9 = F9();
        ArrayList arrayList = new ArrayList(stickerModelMap.size());
        for (Map.Entry<WinkStickerModel, MetaMaterial> entry : stickerModelMap.entrySet()) {
            WinkStickerModel key = entry.getKey();
            MetaMaterial value = entry.getValue();
            if (value != null) {
                MetaMaterial material = value.copy();
                Intrinsics.checkNotNullExpressionValue(material, "material");
                com.tencent.mobileqq.wink.editor.sticker.m.J0(material, true);
                if (H9 != null && F9 != null) {
                    winkStickerModel = com.tencent.mobileqq.wink.editor.sticker.l.v(material, H9, F9.getRenderWidth(), F9.getRenderHeight(), key);
                } else {
                    winkStickerModel = null;
                }
                if (winkStickerModel != null) {
                    key = winkStickerModel;
                }
            }
            arrayList.add(key);
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : arrayList) {
            linkedHashMap.put(((WinkStickerModel) obj).id, obj);
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        jd(mutableMap);
    }

    private final void jd(Map<String, WinkStickerModel> stickerMap) {
        dr H9 = H9();
        if (H9 != null) {
            H9.B(stickerMap);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart, com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f905652t;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Fb(@NotNull View rootView) {
        int i3;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.Fb(rootView);
        ImageView mTextConfirm = getMTextConfirm();
        if (mTextConfirm != null) {
            if (getIsSubtitleMode()) {
                i3 = R.drawable.l8p;
            } else {
                i3 = R.drawable.oqa;
            }
            mTextConfirm.setImageResource(i3);
        }
        ImageView mTextConfirm2 = getMTextConfirm();
        if (mTextConfirm2 != null) {
            mTextConfirm2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorSubtitleTextMenuPart.gd(WinkEditorSubtitleTextMenuPart.this, view);
                }
            });
        }
        rootView.findViewById(R.id.tld).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorSubtitleTextMenuPart.hd(WinkEditorSubtitleTextMenuPart.this, view);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Gc(@Nullable String categoryId) {
        if (!Intrinsics.areEqual(categoryId, "CATEGORY_TEXT_STYLE") && !Intrinsics.areEqual(categoryId, "CATEGORY_TEXT_PATTERN")) {
            super.Gc(categoryId);
        } else {
            super.Gc(categoryId);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        boolean z16;
        Map<String, WinkStickerModel> map;
        String str;
        int i3;
        View view;
        MetaMaterial material;
        View view2;
        dr H9 = H9();
        if (H9 != null && H9.isPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isPlayerPlaying = z16;
        dr H92 = H9();
        WinkStickerModel winkStickerModel = null;
        if (H92 != null) {
            map = H92.m();
        } else {
            map = null;
        }
        if (args != null) {
            str = args.getString(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID);
        } else {
            str = null;
        }
        if (args != null) {
            i3 = args.getInt(EmotionConstants.DISPLAY_TYPE);
        } else {
            i3 = 0;
        }
        super.L9(args);
        if (i3 == 3) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                view2 = partRootView.findViewById(R.id.f94745d4);
            } else {
                view2 = null;
            }
            if (view2 != null) {
                view2.setVisibility(0);
            }
            Gc("CATEGORY_KEYBOARD");
            TextView mKeyboardTv = getMKeyboardTv();
            if (mKeyboardTv != null) {
                mKeyboardTv.setVisibility(4);
            }
            TextView mTextStyleTv = getMTextStyleTv();
            if (mTextStyleTv != null) {
                mTextStyleTv.setVisibility(4);
            }
            TextView mTextPatternTv = getMTextPatternTv();
            if (mTextPatternTv != null) {
                mTextPatternTv.setVisibility(4);
            }
            TextView mTextDecorTv = getMTextDecorTv();
            if (mTextDecorTv != null) {
                mTextDecorTv.setVisibility(4);
            }
            Ac(true);
            EditText mTextInput = getMTextInput();
            if (mTextInput != null) {
                mTextInput.setSingleLine();
            }
            EditText mTextInput2 = getMTextInput();
            if (mTextInput2 != null) {
                mTextInput2.setImeOptions(6);
            }
            EditText mTextInput3 = getMTextInput();
            if (mTextInput3 != null) {
                mTextInput3.setImeActionLabel(getContext().getString(R.string.b9f), 6);
            }
            ImageView mTextConfirm = getMTextConfirm();
            if (mTextConfirm != null) {
                mTextConfirm.setImageResource(R.drawable.m3u);
            }
            EditText mTextInput4 = getMTextInput();
            if (mTextInput4 != null) {
                mTextInput4.setOnEditorActionListener(new b());
            }
        } else {
            View partRootView2 = getPartRootView();
            if (partRootView2 != null) {
                view = partRootView2.findViewById(R.id.f94745d4);
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(8);
            }
            Gc("CATEGORY_TEXT_STYLE");
            TextView mKeyboardTv2 = getMKeyboardTv();
            if (mKeyboardTv2 != null) {
                mKeyboardTv2.setVisibility(4);
            }
            TextView mTextStyleTv2 = getMTextStyleTv();
            if (mTextStyleTv2 != null) {
                mTextStyleTv2.setVisibility(0);
            }
            if (Intrinsics.areEqual(dd().a3().getValue(), Boolean.TRUE)) {
                TextView mTextPatternTv2 = getMTextPatternTv();
                if (mTextPatternTv2 != null) {
                    mTextPatternTv2.setVisibility(8);
                }
            } else {
                TextView mTextPatternTv3 = getMTextPatternTv();
                if (mTextPatternTv3 != null) {
                    mTextPatternTv3.setVisibility(0);
                }
            }
            TextView mTextDecorTv2 = getMTextDecorTv();
            if (mTextDecorTv2 != null) {
                mTextDecorTv2.setVisibility(4);
            }
            Ac(false);
        }
        if (str != null) {
            if (map != null) {
                winkStickerModel = map.get(str);
            }
            qb().G2(map, winkStickerModel);
            dr H93 = H9();
            if (H93 != null) {
                H93.B(new LinkedHashMap());
            }
            if (winkStickerModel != null && (material = winkStickerModel.getMaterial()) != null) {
                zc(qb().n2(material));
            }
        }
        qb().w2();
        if (i3 == 3) {
            qb().N1("CATEGORY_KEYBOARD");
        } else {
            qb().N1("CATEGORY_TEXT_STYLE");
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.SUBTITLE_TEXT;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    @NotNull
    public bb cc() {
        ViewModel viewModel = getViewModel("subtitle_", bb.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(\"subtitle_\"\u2026extViewModel::class.java)");
        return (bb) viewModel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
    
        if (r4 == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void cd() {
        String str;
        ArrayList<MetaMaterialContent> arrayList;
        MetaMaterialContent metaMaterialContent;
        ArrayList<MetaMaterialContent> metaMaterialContent2;
        MetaMaterialContent metaMaterialContent3;
        ArrayList<MetaMaterialContent> metaMaterialContent4;
        boolean z16;
        boolean z17;
        WinkStickerModel W1 = qb().W1();
        MetaMaterial value = qb().X1().getValue();
        String str2 = null;
        if (value != null) {
            str = com.tencent.mobileqq.wink.editor.sticker.m.l(value);
        } else {
            str = null;
        }
        if (dd().b3()) {
            if (str != null) {
                z16 = true;
                if (str.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z16 = false;
            if (z16) {
                WinkSubtitleViewModel dd5 = dd();
                if (dd5 != null) {
                    dd5.d4(l.a.f322200a);
                    return;
                }
                return;
            }
        }
        if (dd().getIsBilingual() && value != null && com.tencent.mobileqq.wink.editor.sticker.m.l(value) != null) {
            MetaMaterialContentWrapper m3 = com.tencent.mobileqq.wink.editor.sticker.m.m(value);
            if (m3 != null) {
                arrayList = m3.getMetaMaterialContent();
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                MetaMaterialContentWrapper m16 = com.tencent.mobileqq.wink.editor.sticker.m.m(value);
                if (m16 != null && (metaMaterialContent4 = m16.getMetaMaterialContent()) != null) {
                    metaMaterialContent = metaMaterialContent4.get(0);
                } else {
                    metaMaterialContent = null;
                }
                if (metaMaterialContent != null) {
                    MetaMaterialContentWrapper m17 = com.tencent.mobileqq.wink.editor.sticker.m.m(value);
                    if (m17 != null && (metaMaterialContent2 = m17.getMetaMaterialContent()) != null && (metaMaterialContent3 = metaMaterialContent2.get(0)) != null) {
                        str2 = metaMaterialContent3.getContent();
                    }
                    str = str2;
                }
            }
        }
        ab();
        dd().c4(W1, str, value, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorSubtitleTextMenuPart$confirmClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
            
                r0 = r1.this$0.H9();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                boolean z18;
                dr H9;
                z18 = WinkEditorSubtitleTextMenuPart.this.isPlayerPlaying;
                if (!z18 || H9 == null) {
                    return;
                }
                H9.play();
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void hc() {
        bd();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            WinkEditorTextMenuPart.cb(this, false, 0, 2, null);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void wb() {
        qb().o2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorSubtitleTextMenuPart.ed(WinkEditorSubtitleTextMenuPart.this, (Map) obj);
            }
        });
        jb().F2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorSubtitleTextMenuPart.fd(WinkEditorSubtitleTextMenuPart.this, (MenuType) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
