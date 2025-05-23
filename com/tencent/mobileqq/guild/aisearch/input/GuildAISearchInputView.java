package com.tencent.mobileqq.guild.aisearch.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputView;
import com.tencent.mobileqq.guild.api.IGuildTextUtil;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.config.GuildAISearchModel;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.NumberUtil;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0002FGB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\u0013\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00102\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010*R\u0016\u00103\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010&R\u0016\u00104\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010.R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u00106R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u000209088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, UserInfo.SEX_FEMALE, "", "o", BdhLogUtil.LogTag.Tag_Conn, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "keyboardHeight", "E", "text", "B", "Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView$b;", "d", "Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView$b;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView$b;", "setInputViewListener", "(Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView$b;)V", "inputViewListener", "Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchEditText;", "e", "Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchEditText;", "editText", "Landroid/view/View;", "f", "Landroid/view/View;", "modelLayout", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "modelName", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "modelArrow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "modelTips", "textLimit", "sendLayout", "sendButton", "Landroidx/constraintlayout/widget/Guideline;", "Landroidx/constraintlayout/widget/Guideline;", "bottomLine", "", "Lcom/tencent/mobileqq/guild/config/d;", "G", "Ljava/util/List;", "modelList", "H", "Ljava/lang/String;", "currentModelType", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "I", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildAISearchInputView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView textLimit;

    /* renamed from: D, reason: from kotlin metadata */
    private View sendLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView sendButton;

    /* renamed from: F, reason: from kotlin metadata */
    private Guideline bottomLine;

    /* renamed from: G, reason: from kotlin metadata */
    private List<GuildAISearchModel> modelList;

    /* renamed from: H, reason: from kotlin metadata */
    private String currentModelType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b inputViewListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildAISearchEditText editText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View modelLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView modelName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView modelArrow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView modelTips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView$b;", "", "", "searchText", "modelType", "modelTitle", "modelDesc", "shareInfo", "", "showSpeed", "", "a", "Landroid/view/KeyEvent;", "event", "", "onKeyEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void a(@NotNull String searchText, @NotNull String modelType, @NotNull String modelTitle, @NotNull String modelDesc, @NotNull String shareInfo, int showSpeed);

        boolean onKeyEvent(@NotNull KeyEvent event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildAISearchInputView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        boolean z16;
        boolean z17;
        Object obj;
        String o16 = o();
        if (o16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        TextView textView = this.textLimit;
        List<GuildAISearchModel> list = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textLimit");
            textView = null;
        }
        if (textView.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            QQToastUtil.showQQToast(0, "\u6700\u591a\u53ea\u80fd\u8f93\u5165500\u5b57");
            return;
        }
        List<GuildAISearchModel> list2 = this.modelList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelList");
            list2 = null;
        }
        Iterator<T> it = list2.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                String modelType = ((GuildAISearchModel) obj).getModelType();
                String str = this.currentModelType;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentModelType");
                    str = null;
                }
                if (Intrinsics.areEqual(modelType, str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GuildAISearchModel guildAISearchModel = (GuildAISearchModel) obj;
        if (guildAISearchModel == null) {
            String str2 = this.currentModelType;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentModelType");
                str2 = null;
            }
            List<GuildAISearchModel> list3 = this.modelList;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modelList");
            } else {
                list = list3;
            }
            QLog.w("GuildAISearchInputView", 1, "model is empty, modelType: " + str2 + ", modelSize: " + list.size());
            return;
        }
        GuildAISearchEditText guildAISearchEditText = this.editText;
        if (guildAISearchEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            guildAISearchEditText = null;
        }
        guildAISearchEditText.setText((CharSequence) null);
        b bVar = this.inputViewListener;
        if (bVar != null) {
            bVar.a(o16, guildAISearchModel.getModelType(), guildAISearchModel.getModelTitle(), guildAISearchModel.getModelDesc(), guildAISearchModel.getModelShareInfo(), guildAISearchModel.getModelShowSpeed());
        }
    }

    private final void D() {
        List<GuildAISearchModel> list = this.modelList;
        View view = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelList");
            list = null;
        }
        if (list.isEmpty()) {
            QLog.w("GuildAISearchInputView", 1, "showModelPopupWindow fail, modelList is empty");
            return;
        }
        F(true);
        List<GuildAISearchModel> list2 = this.modelList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelList");
            list2 = null;
        }
        Iterator<GuildAISearchModel> it = list2.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                String modelType = it.next().getModelType();
                String str = this.currentModelType;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentModelType");
                    str = null;
                }
                if (Intrinsics.areEqual(modelType, str)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        List<GuildAISearchModel> list3 = this.modelList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelList");
            list3 = null;
        }
        GuildAISearchModelPopupWindow guildAISearchModelPopupWindow = new GuildAISearchModelPopupWindow(context, list3, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputView$showModelPopupWindow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void invoke(int i16, @NotNull String selectedType) {
                TextView textView;
                List list4;
                Object obj;
                String str2;
                String str3;
                Intrinsics.checkNotNullParameter(selectedType, "selectedType");
                GuildAISearchInputView.this.currentModelType = selectedType;
                textView = GuildAISearchInputView.this.modelName;
                String str4 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("modelName");
                    textView = null;
                }
                list4 = GuildAISearchInputView.this.modelList;
                if (list4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("modelList");
                    list4 = null;
                }
                GuildAISearchInputView guildAISearchInputView = GuildAISearchInputView.this;
                Iterator it5 = list4.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it5.next();
                    String modelType2 = ((GuildAISearchModel) obj).getModelType();
                    str3 = guildAISearchInputView.currentModelType;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentModelType");
                        str3 = null;
                    }
                    if (Intrinsics.areEqual(modelType2, str3)) {
                        break;
                    }
                }
                GuildAISearchModel guildAISearchModel = (GuildAISearchModel) obj;
                textView.setText(guildAISearchModel != null ? guildAISearchModel.getModelTitle() : null);
                bw bwVar = bw.f235485a;
                str2 = GuildAISearchInputView.this.currentModelType;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentModelType");
                } else {
                    str4 = str2;
                }
                bwVar.E0(str4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                invoke(num.intValue(), str2);
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputView$showModelPopupWindow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildAISearchInputView.this.F(false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        View view2 = this.modelLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelLayout");
        } else {
            view = view2;
        }
        guildAISearchModelPopupWindow.m(view, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(boolean isOpen) {
        float f16;
        ImageView imageView = this.modelArrow;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelArrow");
            imageView = null;
        }
        if (isOpen) {
            f16 = -180.0f;
        } else {
            f16 = 0.0f;
        }
        imageView.setRotation(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o() {
        CharSequence trim;
        GuildAISearchEditText guildAISearchEditText = this.editText;
        if (guildAISearchEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            guildAISearchEditText = null;
        }
        trim = StringsKt__StringsKt.trim((CharSequence) guildAISearchEditText.getText().toString());
        return trim.toString();
    }

    private final void q() {
        View view;
        View view2;
        View view3 = this.modelLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelLayout");
            view = null;
        } else {
            view = view3;
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        if1.a.b(view, "em_sgrp_ai_model", null, null, exposurePolicy, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.aisearch.input.b
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map r16;
                r16 = GuildAISearchInputView.r(GuildAISearchInputView.this, str);
                return r16;
            }
        }, 118, null);
        View view4 = this.sendLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendLayout");
            view2 = null;
        } else {
            view2 = view4;
        }
        if1.a.b(view2, "em_sgrp_send", null, null, exposurePolicy, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.aisearch.input.c
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map s16;
                s16 = GuildAISearchInputView.s(GuildAISearchInputView.this, str);
                return s16;
            }
        }, 118, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map r(GuildAISearchInputView this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = this$0.currentModelType;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentModelType");
            str2 = null;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_ai_model_type", Integer.valueOf(NumberUtil.stringToInt(str2))));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map s(GuildAISearchInputView this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, this$0.o()));
        return mapOf;
    }

    private final void t() {
        GuildAISearchEditText guildAISearchEditText = this.editText;
        GuildAISearchEditText guildAISearchEditText2 = null;
        if (guildAISearchEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            guildAISearchEditText = null;
        }
        guildAISearchEditText.addTextChangedListener(new c());
        GuildAISearchEditText guildAISearchEditText3 = this.editText;
        if (guildAISearchEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            guildAISearchEditText3 = null;
        }
        guildAISearchEditText3.setOnKeyEventPreImeListener(new Function1<KeyEvent, Boolean>() { // from class: com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputView$initEditText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable KeyEvent keyEvent) {
                boolean z16;
                if (keyEvent != null) {
                    GuildAISearchInputView.b inputViewListener = GuildAISearchInputView.this.getInputViewListener();
                    Boolean valueOf = inputViewListener != null ? Boolean.valueOf(inputViewListener.onKeyEvent(keyEvent)) : null;
                    if (valueOf != null) {
                        z16 = valueOf.booleanValue();
                        return Boolean.valueOf(z16);
                    }
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        });
        GuildAISearchEditText guildAISearchEditText4 = this.editText;
        if (guildAISearchEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
        } else {
            guildAISearchEditText2 = guildAISearchEditText4;
        }
        guildAISearchEditText2.setHint(GuildAISearchConfBean.INSTANCE.a().getSearchInputTips());
    }

    private final void u() {
        Object obj;
        String str;
        Object obj2;
        ArrayList<GuildAISearchModel> i3 = GuildAISearchConfBean.INSTANCE.a().i();
        this.modelList = i3;
        View view = null;
        if (i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelList");
            i3 = null;
        }
        if (i3.isEmpty()) {
            QLog.w("GuildAISearchInputView", 1, "init modelList is empty");
        }
        this.currentModelType = bw.f235485a.c();
        List<GuildAISearchModel> list = this.modelList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                String modelType = ((GuildAISearchModel) obj).getModelType();
                String str2 = this.currentModelType;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentModelType");
                    str2 = null;
                }
                if (Intrinsics.areEqual(modelType, str2)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GuildAISearchModel guildAISearchModel = (GuildAISearchModel) obj;
        if (guildAISearchModel == null) {
            this.currentModelType = GuildAISearchConfBean.INSTANCE.a().getDefaultModelType();
            List<GuildAISearchModel> list2 = this.modelList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modelList");
                list2 = null;
            }
            Iterator<T> it5 = list2.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj2 = it5.next();
                    String modelType2 = ((GuildAISearchModel) obj2).getModelType();
                    String str3 = this.currentModelType;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentModelType");
                        str3 = null;
                    }
                    if (Intrinsics.areEqual(modelType2, str3)) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            guildAISearchModel = (GuildAISearchModel) obj2;
        }
        if (guildAISearchModel == null) {
            List<GuildAISearchModel> list3 = this.modelList;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modelList");
                list3 = null;
            }
            if (!list3.isEmpty()) {
                List<GuildAISearchModel> list4 = this.modelList;
                if (list4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("modelList");
                    list4 = null;
                }
                guildAISearchModel = list4.get(0);
                this.currentModelType = guildAISearchModel.getModelType();
            }
        }
        TextView textView = this.modelName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelName");
            textView = null;
        }
        if (guildAISearchModel != null) {
            str = guildAISearchModel.getModelTitle();
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = this.modelTips;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelTips");
            textView2 = null;
        }
        textView2.setText(GuildAISearchConfBean.INSTANCE.a().getSearchInputModelTips());
        View view2 = this.modelLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modelLayout");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.input.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildAISearchInputView.v(GuildAISearchInputView.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GuildAISearchInputView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w(Context context) {
        LayoutInflater.from(context).inflate(R.layout.f168025ee2, this);
        View findViewById = findViewById(R.id.f164084sg4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ai_search_edit_text)");
        this.editText = (GuildAISearchEditText) findViewById;
        View findViewById2 = findViewById(R.id.sg_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ai_search_model_select_layout)");
        this.modelLayout = findViewById2;
        View findViewById3 = findViewById(R.id.sg9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ai_search_model_name)");
        this.modelName = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.sg6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ai_search_model_arrow)");
        this.modelArrow = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.sgb);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ai_search_model_tips)");
        this.modelTips = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.sgc);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ai_search_text_limit)");
        this.textLimit = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.t_7);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.bottom_button_container)");
        this.sendLayout = findViewById7;
        View findViewById8 = findViewById(R.id.sga);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.ai_search_model_send)");
        this.sendButton = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.sg5);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.ai_search_guideline)");
        this.bottomLine = (Guideline) findViewById9;
        View view = this.sendLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendLayout");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.input.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildAISearchInputView.x(GuildAISearchInputView.this, view2);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.input.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildAISearchInputView.y(GuildAISearchInputView.this, view2);
            }
        });
        setClickable(true);
        setClipChildren(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(GuildAISearchInputView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            this$0.A();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(GuildAISearchInputView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            this$0.C();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void B(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        GuildAISearchEditText guildAISearchEditText = this.editText;
        if (guildAISearchEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            guildAISearchEditText = null;
        }
        guildAISearchEditText.setText(text);
        A();
    }

    public final void C() {
        GuildAISearchEditText guildAISearchEditText = this.editText;
        GuildAISearchEditText guildAISearchEditText2 = null;
        if (guildAISearchEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            guildAISearchEditText = null;
        }
        guildAISearchEditText.requestFocus();
        GuildAISearchEditText guildAISearchEditText3 = this.editText;
        if (guildAISearchEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
        } else {
            guildAISearchEditText2 = guildAISearchEditText3;
        }
        InputMethodUtil.show(guildAISearchEditText2);
    }

    public final void E(int keyboardHeight) {
        Guideline guideline = this.bottomLine;
        if (guideline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLine");
            guideline = null;
        }
        guideline.setGuidelineEnd(keyboardHeight);
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final b getInputViewListener() {
        return this.inputViewListener;
    }

    public final void p() {
        GuildAISearchEditText guildAISearchEditText = this.editText;
        GuildAISearchEditText guildAISearchEditText2 = null;
        if (guildAISearchEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            guildAISearchEditText = null;
        }
        guildAISearchEditText.clearFocus();
        GuildAISearchEditText guildAISearchEditText3 = this.editText;
        if (guildAISearchEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
        } else {
            guildAISearchEditText2 = guildAISearchEditText3;
        }
        InputMethodUtil.hide(guildAISearchEditText2);
    }

    public final void setInputViewListener(@Nullable b bVar) {
        this.inputViewListener = bVar;
    }

    public final void z() {
        this.inputViewListener = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildAISearchInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildAISearchInputView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildAISearchInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        w(context);
        u();
        t();
        q();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            String o16 = GuildAISearchInputView.this.o();
            if (o16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ImageView imageView = null;
            if (z16) {
                ImageView imageView2 = GuildAISearchInputView.this.sendButton;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendButton");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageResource(R.drawable.guild_ai_search_send_icon_disabled);
                return;
            }
            int countText = ((IGuildTextUtil) QRoute.api(IGuildTextUtil.class)).countText(o16);
            if (countText > 500) {
                TextView textView = GuildAISearchInputView.this.textLimit;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textLimit");
                    textView = null;
                }
                textView.setVisibility(0);
                TextView textView2 = GuildAISearchInputView.this.textLimit;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textLimit");
                    textView2 = null;
                }
                textView2.setText("-" + (countText - 500));
            } else {
                TextView textView3 = GuildAISearchInputView.this.textLimit;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textLimit");
                    textView3 = null;
                }
                textView3.setVisibility(8);
            }
            ImageView imageView3 = GuildAISearchInputView.this.sendButton;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendButton");
            } else {
                imageView = imageView3;
            }
            imageView.setImageResource(R.drawable.guild_ai_search_send_icon);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
