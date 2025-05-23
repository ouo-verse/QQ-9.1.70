package com.tencent.mobileqq.wink.dailysign;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.model.TextItem;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGText;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010)\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignTextMenuPart;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;", "", "text", "", "id", "", "wb", "Lorg/libpag/PAGText;", "pagText", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Rc", "Landroid/util/Pair;", "pair", "ub", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ab", "Lorg/libpag/PAGFile;", "rb", "materialPagFile", "Lorg/libpag/PAGView;", "mTextPagView", "Pc", "", "displayType", "jd", "Fb", "Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", "I0", "Lkotlin/Lazy;", "cd", "()Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", "dailySignViewModel", "J0", "I", "getCompositionWidth", "()I", "setCompositionWidth", "(I)V", "compositionWidth", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "K0", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "getDefaultTextMeta", "()Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "defaultTextMeta", "<init>", "()V", "L0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class DailySignTextMenuPart extends WinkEditorTextMenuPart {

    /* renamed from: I0, reason: from kotlin metadata */
    @NotNull
    private final Lazy dailySignViewModel;

    /* renamed from: J0, reason: from kotlin metadata */
    private int compositionWidth;

    /* renamed from: K0, reason: from kotlin metadata */
    @NotNull
    private final WinkStickerModel defaultTextMeta;

    public DailySignTextMenuPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DailySignViewModel>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignTextMenuPart$dailySignViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DailySignViewModel invoke() {
                return (DailySignViewModel) DailySignTextMenuPart.this.getViewModel(DailySignViewModel.class);
            }
        });
        this.dailySignViewModel = lazy;
        MetaMaterial a06 = com.tencent.mobileqq.wink.editor.sticker.m.a0();
        com.tencent.mobileqq.wink.editor.sticker.m.P0(a06, 90);
        Unit unit = Unit.INSTANCE;
        this.defaultTextMeta = new WinkStickerModel(null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, null, 0.0f, 0.0f, null, null, null, null, null, a06, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -1, 2096895, null);
    }

    private final DailySignViewModel cd() {
        Object value = this.dailySignViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dailySignViewModel>(...)");
        return (DailySignViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dd(WinkStickerModel winkStickerModel) {
        MetaMaterial material;
        boolean z16;
        if (winkStickerModel != null && (material = winkStickerModel.getMaterial()) != null && com.tencent.mobileqq.wink.editor.sticker.m.T(material)) {
            for (TextItem textItem : winkStickerModel.textItems) {
                if (textItem.text.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    w53.b.a("DailySignFragment", "textContent " + ((Object) textItem.text));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ed(DailySignTextMenuPart this$0, MetaMaterial metaMaterial) {
        float f16;
        float f17;
        float f18;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (metaMaterial != null) {
            String str = "0";
            float f19 = 0.0f;
            if (metaMaterial.additionalFields.containsKey("textBoundsTop")) {
                String str2 = metaMaterial.additionalFields.get("textBoundsTop");
                if (str2 == null) {
                    str2 = "0";
                }
                Float valueOf = Float.valueOf(str2);
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(material.additio\u2026t(\"textBoundsTop\")?: \"0\")");
                f16 = valueOf.floatValue();
            } else {
                f16 = 0.0f;
            }
            if (metaMaterial.additionalFields.containsKey("textBoundsBottom")) {
                String str3 = metaMaterial.additionalFields.get("textBoundsBottom");
                if (str3 == null) {
                    str3 = "0";
                }
                Float valueOf2 = Float.valueOf(str3);
                Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(material.additio\u2026textBoundsBottom\")?: \"0\")");
                f17 = valueOf2.floatValue();
            } else {
                f17 = 0.0f;
            }
            if (metaMaterial.additionalFields.containsKey("pagViewWidth")) {
                String str4 = metaMaterial.additionalFields.get("pagViewWidth");
                if (str4 != null) {
                    str = str4;
                }
                Float valueOf3 = Float.valueOf(str);
                Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(material.additio\u2026t(\"pagViewWidth\") ?: \"0\")");
                f18 = valueOf3.floatValue();
            } else {
                f18 = 0.0f;
            }
            float f26 = f17 - f16;
            if (f18 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    f19 = (this$0.compositionWidth * f26) / f18;
                } catch (JSONException unused) {
                    w53.b.a(this$0.TAG, "textContent " + com.tencent.mobileqq.wink.editor.sticker.m.l(metaMaterial) + " pagViewWidth : " + f18 + " height: " + f26 + ", compositionWidth " + this$0.compositionWidth);
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("text", com.tencent.mobileqq.wink.editor.sticker.m.l(metaMaterial));
            jSONObject.put("height", Float.valueOf(f19));
            jSONObject.put("needShowHint", false);
            jSONObject.put("isRandomChange", false);
            this$0.cd().Z1(jSONObject);
            w53.b.a(this$0.TAG, "textContent " + com.tencent.mobileqq.wink.editor.sticker.m.l(metaMaterial) + " pagViewWidth : " + f18 + " height: " + f26 + ", realHeight " + f19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fd(DailySignTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qb().N1("CATEGORY_KEYBOARD");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gd(DailySignTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorTextMenuPart.cb(this$0, false, 0, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hd(DailySignTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ab();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean id(String text) {
        int i3 = 0;
        for (int i16 = 0; i16 < text.length(); i16++) {
            if (text.charAt(i16) == '\n') {
                i3++;
            }
        }
        if (i3 <= 5) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Ab(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        vc((EditText) rootView.findViewById(R.id.f94815da));
        EditText mTextInput = getMTextInput();
        if (mTextInput != null) {
            mTextInput.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.ao
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DailySignTextMenuPart.fd(DailySignTextMenuPart.this, view);
                }
            });
        }
        EditText mTextInput2 = getMTextInput();
        if (mTextInput2 != null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = mTextInput2.getText().toString();
            mTextInput2.addTextChangedListener(new b(objectRef, this, mTextInput2));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Fb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.Fb(rootView);
        rootView.findViewById(R.id.tld).setVisibility(8);
        View findViewById = rootView.findViewById(R.id.f164882u45);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = rootView.findViewById(R.id.ud5);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.am
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DailySignTextMenuPart.gd(DailySignTextMenuPart.this, view);
                }
            });
        }
        ImageView imageView = (ImageView) rootView.findViewById(R.id.ud6);
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.an
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DailySignTextMenuPart.hd(DailySignTextMenuPart.this, view);
                }
            });
        } else {
            imageView = null;
        }
        tc(imageView);
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Pc(@Nullable PAGFile materialPagFile, @Nullable PAGView mTextPagView, @NotNull MetaMaterial material) {
        int i3;
        PAGComposition composition;
        Intrinsics.checkNotNullParameter(material, "material");
        super.Pc(materialPagFile, mTextPagView, material);
        if (mTextPagView != null && (composition = mTextPagView.getComposition()) != null) {
            i3 = composition.width();
        } else {
            i3 = 0;
        }
        this.compositionWidth = i3;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void Rc(@NotNull PAGText pagText, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(pagText, "pagText");
        Intrinsics.checkNotNullParameter(material, "material");
        pagText.text = com.tencent.mobileqq.wink.editor.sticker.m.l(material);
        pagText.fillColor = -1;
    }

    public final void jd(int displayType) {
        MetaMaterial material = this.defaultTextMeta.getMaterial();
        if (material != null) {
            com.tencent.mobileqq.wink.editor.sticker.m.n0(material, cd().getPublishConfig().getInputText());
        }
        qb().F2(this.defaultTextMeta);
        qb().I2(displayType);
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    @Nullable
    public PAGFile rb(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        String t26 = cd().t2();
        w53.b.a(this.TAG, "pagName " + t26);
        return com.tencent.mobileqq.wink.utils.x.b().c(t26);
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void ub(@NotNull Pair<String, Boolean> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        super.ub(pair);
        Object obj = pair.second;
        Intrinsics.checkNotNullExpressionValue(obj, "pair.second");
        if (((Boolean) obj).booleanValue()) {
            Map<String, Object> mParams = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(mParams, "mParams");
            mParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_DAILY_SIGNIN_PAGE);
            mParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_WORDS_OVER_LIMIT_TOAST);
            VideoReport.reportEvent("ev_xsj_abnormal_imp", mParams);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    public void wb() {
        qb().e2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignTextMenuPart.dd((WinkStickerModel) obj);
            }
        });
        qb().S1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignTextMenuPart.ed(DailySignTextMenuPart.this, (MetaMaterial) obj);
            }
        });
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignTextMenuPart$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f318091d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DailySignTextMenuPart f318092e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f318093f;

        b(Ref.ObjectRef<String> objectRef, DailySignTextMenuPart dailySignTextMenuPart, EditText editText) {
            this.f318091d = objectRef;
            this.f318092e = dailySignTextMenuPart;
            this.f318093f = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (s16 != null) {
                DailySignTextMenuPart dailySignTextMenuPart = this.f318092e;
                Ref.ObjectRef<String> objectRef = this.f318091d;
                EditText editText = this.f318093f;
                String obj = s16.toString();
                if (!dailySignTextMenuPart.id(obj)) {
                    dailySignTextMenuPart.qb().L1(obj);
                    return;
                }
                QQToast.makeText(dailySignTextMenuPart.getContext(), dailySignTextMenuPart.getContext().getString(R.string.f1646526e), 0).show();
                if (!dailySignTextMenuPart.id(objectRef.element)) {
                    editText.setText(objectRef.element);
                }
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            this.f318091d.element = String.valueOf(s16);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
