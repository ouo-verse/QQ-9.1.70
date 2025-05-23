package com.tencent.android.androidbypass.richui.viewdata;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00052\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010u\u001a\u00020r\u00a2\u0006\u0004\bv\u0010wJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00002\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0017J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\"\u0010!\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fJ\b\u0010\"\u001a\u0004\u0018\u00010\nJ\"\u0010#\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH$J\u0012\u0010%\u001a\u0004\u0018\u00010\u00002\u0006\u0010$\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0019H\u0017J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010+\u001a\u00020*2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0002J \u0010.\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\rH\u0004J4\u00103\u001a\u00020\u00042*\u00102\u001a&\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003000/j\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u000300`1H&J4\u00104\u001a\u00020\u00042*\u00102\u001a&\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003000/j\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u000300`1H&J\b\u00105\u001a\u00020\u0004H\u0017R$\u0010;\u001a\u00020\r2\u0006\u00106\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010<R\"\u0010C\u001a\u00020=8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010F\u001a\u00020=8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010>\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u0018R\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0018R\u0016\u0010K\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0018R\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00108R\"\u0010Q\u001a\u00020\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bN\u00108\u001a\u0004\bN\u0010:\"\u0004\bO\u0010PR\"\u0010U\u001a\u00020\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bR\u00108\u001a\u0004\bS\u0010:\"\u0004\bT\u0010PR\"\u0010[\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010b\u001a\u0004\u0018\u00010\\8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010d\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u00108\u001a\u0004\bR\u0010:\"\u0004\bc\u0010PR\"\u0010h\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\be\u0010V\u001a\u0004\bf\u0010X\"\u0004\bg\u0010ZR\u0018\u0010j\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010iR$\u0010q\u001a\u0004\u0018\u00010k8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0017\u0010u\u001a\u00020r8\u0006\u00a2\u0006\f\n\u0004\b?\u0010s\u001a\u0004\be\u0010t\u00a8\u0006x"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/k;", "", "Landroid/widget/LinearLayout$LayoutParams;", "lp", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "Landroid/view/ViewGroup$MarginLayoutParams;", "t", "Landroid/view/View;", "view", "b", "", "value", "", HippyTKDListViewAdapter.X, "viewNode", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/richui/event/c;", "eventList", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/android/androidbypass/richui/event/g;", "data", "D", "Lorg/json/JSONObject;", "dataJson", "w", "y", "Lcom/tencent/android/androidbypass/richui/view/i;", "viewDelegateFactory", "Lcom/tencent/android/androidbypass/richui/view/j;", "listener", tl.h.F, DomainData.DOMAIN_NAME, "f", "id", "g", "attrData", BdhLogUtil.LogTag.Tag_Conn, "c", "originLp", "Landroid/widget/FrameLayout$LayoutParams;", "l", "jsonObject", "key", "v", "Ljava/util/HashMap;", "Lcom/tencent/android/androidbypass/richui/view/h;", "Lkotlin/collections/HashMap;", "cache", "e", "d", "u", "<set-?>", "a", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "viewId", "Landroid/view/View;", "", UserInfo.SEX_FEMALE, "r", "()F", "setWidth", "(F)V", "width", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setHeight", "height", "", NodeProps.MARGIN_LEFT, NodeProps.MARGIN_TOP, NodeProps.MARGIN_RIGHT, NodeProps.MARGIN_BOTTOM, "i", LayoutAttrDefine.Gravity.Gravity, "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "background", "k", "getBackgroundColor", "setBackgroundColor", "backgroundColor", "I", "p", "()I", "B", "(I)V", "radius", "Lcom/tencent/android/androidbypass/richui/viewdata/b;", "Lcom/tencent/android/androidbypass/richui/viewdata/b;", "getBgGradient", "()Lcom/tencent/android/androidbypass/richui/viewdata/b;", "setBgGradient", "(Lcom/tencent/android/androidbypass/richui/viewdata/b;)V", "bgGradient", "setClickSchema", "clickSchema", "o", "getVisibility", "setVisibility", "visibility", "Lcom/tencent/android/androidbypass/richui/view/j;", "clickListener", "Lcom/tencent/android/androidbypass/richui/event/a;", "Lcom/tencent/android/androidbypass/richui/event/a;", "getEventCollection", "()Lcom/tencent/android/androidbypass/richui/event/a;", "setEventCollection", "(Lcom/tencent/android/androidbypass/richui/event/a;)V", "eventCollection", "Lcom/tencent/android/androidbypass/richui/f;", "Lcom/tencent/android/androidbypass/richui/f;", "()Lcom/tencent/android/androidbypass/richui/f;", "options", "<init>", "(Lcom/tencent/android/androidbypass/richui/f;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class k {
    static IPatchRedirector $redirector_;

    /* renamed from: s */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private String viewId;

    /* renamed from: b, reason: from kotlin metadata */
    private View view;

    /* renamed from: c */
    private float width;

    /* renamed from: d */
    private float height;

    /* renamed from: e, reason: from kotlin metadata */
    private double com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_LEFT java.lang.String;

    /* renamed from: f, reason: from kotlin metadata */
    private double com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_TOP java.lang.String;

    /* renamed from: g, reason: from kotlin metadata */
    private double com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_RIGHT java.lang.String;

    /* renamed from: h */
    private double marginBottom;

    /* renamed from: i, reason: from kotlin metadata */
    private String com.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String;

    /* renamed from: j, reason: from kotlin metadata */
    @NotNull
    private String background;

    /* renamed from: k, reason: from kotlin metadata */
    @NotNull
    private String backgroundColor;

    /* renamed from: l, reason: from kotlin metadata */
    private int radius;

    /* renamed from: m */
    @Nullable
    private com.tencent.android.androidbypass.richui.viewdata.b bgGradient;

    /* renamed from: n */
    @NotNull
    private String clickSchema;

    /* renamed from: o, reason: from kotlin metadata */
    private int visibility;

    /* renamed from: p, reason: from kotlin metadata */
    private com.tencent.android.androidbypass.richui.view.j clickListener;

    /* renamed from: q */
    @Nullable
    private com.tencent.android.androidbypass.richui.event.a eventCollection;

    /* renamed from: r, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.richui.f options;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/k$a;", "", "", "DATA_PREFIX", "Ljava/lang/String;", "TAG", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.richui.viewdata.k$a */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/android/androidbypass/richui/viewdata/ViewNode$generateView$1$1"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                com.tencent.android.androidbypass.config.a.f72049a.i("RichUI.ViewData", "[onClick]: schema is " + k.this.k());
                com.tencent.android.androidbypass.richui.view.j jVar = k.this.clickListener;
                if (jVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    jVar.onClick(it, k.this.q(), k.this.k());
                }
            }
            EventCollector.getInstance().onViewClicked(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) k.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) it);
            } else {
                com.tencent.android.androidbypass.config.a.f72049a.i("RichUI.ViewData", "[onClick]: schema is " + k.this.k());
                com.tencent.android.androidbypass.richui.view.j jVar = k.this.clickListener;
                if (jVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    jVar.onClick(it, k.this.q(), k.this.k());
                }
            }
            EventCollector.getInstance().onViewClicked(it);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k(@NotNull com.tencent.android.androidbypass.richui.f options) {
        float f16;
        Integer b16;
        Integer b17;
        Intrinsics.checkNotNullParameter(options, "options");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) options);
            return;
        }
        this.options = options;
        this.viewId = "";
        if (!options.f() && (b17 = options.b()) != null && b17.intValue() == 0) {
            f16 = 0.0f;
        } else {
            f16 = -1.0f;
        }
        this.width = f16;
        this.height = (options.f() || (b16 = options.b()) == null || b16.intValue() != 1) ? -1.0f : 0.0f;
        this.com.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String = "default";
        this.background = "";
        this.backgroundColor = "";
        this.clickSchema = "";
    }

    private final int D(com.tencent.android.androidbypass.richui.event.g data) {
        if (data.b() && !TextUtils.isEmpty(data.a())) {
            return 0;
        }
        if (data.c() == 1) {
            return 4;
        }
        return 8;
    }

    private final void b(View view) {
        boolean z16;
        GradientDrawable.Orientation orientation;
        Context context = view.getContext();
        if (this.backgroundColor.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            com.tencent.android.androidbypass.richui.utils.b bVar = com.tencent.android.androidbypass.richui.utils.b.f72344a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            gradientDrawable.setColor(com.tencent.android.androidbypass.richui.utils.b.c(bVar, context, this.backgroundColor, null, 4, null));
            gradientDrawable.setCornerRadius(vt.a.a(context, this.radius));
            view.setBackground(gradientDrawable);
            return;
        }
        com.tencent.android.androidbypass.richui.viewdata.b bVar2 = this.bgGradient;
        if (bVar2 != null) {
            Intrinsics.checkNotNull(bVar2);
            com.tencent.android.androidbypass.richui.utils.b bVar3 = com.tencent.android.androidbypass.richui.utils.b.f72344a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ColorStateList c16 = com.tencent.android.androidbypass.richui.utils.b.c(bVar3, context, bVar2.b(), null, 4, null);
            ColorStateList c17 = com.tencent.android.androidbypass.richui.utils.b.c(bVar3, context, bVar2.a(), null, 4, null);
            if (bVar2.c()) {
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            } else {
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, new int[]{c16.getDefaultColor(), c17.getDefaultColor()});
            float a16 = vt.a.a(context, this.radius);
            gradientDrawable2.setCornerRadii(new float[]{a16, a16, a16, a16, 0.0f, 0.0f, 0.0f, 0.0f});
            view.setBackground(gradientDrawable2);
            return;
        }
        view.setBackground(null);
    }

    public static /* synthetic */ View i(k kVar, Context context, com.tencent.android.androidbypass.richui.view.i iVar, com.tencent.android.androidbypass.richui.view.j jVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                jVar = null;
            }
            return kVar.h(context, iVar, jVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateView");
    }

    private final void s(LinearLayout.LayoutParams layoutParams) {
        Integer b16;
        Integer b17;
        Integer b18;
        if (Intrinsics.areEqual(this.com.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String, LayoutAttrDefine.CENTER_HORIZONTAL) && (((b18 = this.options.b()) != null && b18.intValue() == 1) || this.options.b() == null)) {
            layoutParams.gravity = 1;
            return;
        }
        if (Intrinsics.areEqual(this.com.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String, LayoutAttrDefine.CENTER_VERTICAL) && (((b17 = this.options.b()) != null && b17.intValue() == 0) || this.options.b() == null)) {
            layoutParams.gravity = 16;
            return;
        }
        if (Intrinsics.areEqual(this.com.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String, "center") && this.options.b() == null) {
            layoutParams.gravity = 17;
            return;
        }
        if (Intrinsics.areEqual(this.com.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String, "right") && (((b16 = this.options.b()) != null && b16.intValue() == 1) || this.options.b() == null)) {
            layoutParams.gravity = 5;
            return;
        }
        if (Intrinsics.areEqual(this.com.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String, "bottom")) {
            Integer b19 = this.options.b();
            if ((b19 != null && b19.intValue() == 0) || this.options.b() == null) {
                layoutParams.gravity = 80;
            }
        }
    }

    private final void t(Context context, ViewGroup.MarginLayoutParams lp5) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        double d16 = this.com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_LEFT java.lang.String;
        if (d16 != 0.0d) {
            if (!(lp5 instanceof ViewGroup.MarginLayoutParams)) {
                marginLayoutParams3 = null;
            } else {
                marginLayoutParams3 = lp5;
            }
            if (marginLayoutParams3 != null) {
                marginLayoutParams3.leftMargin = vt.a.a(context, (float) d16);
            }
        }
        double d17 = this.com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_TOP java.lang.String;
        if (d17 != 0.0d) {
            if (!(lp5 instanceof ViewGroup.MarginLayoutParams)) {
                marginLayoutParams2 = null;
            } else {
                marginLayoutParams2 = lp5;
            }
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.topMargin = vt.a.a(context, (float) d17);
            }
        }
        double d18 = this.com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_RIGHT java.lang.String;
        if (d18 != 0.0d) {
            if (!(lp5 instanceof ViewGroup.MarginLayoutParams)) {
                marginLayoutParams = null;
            } else {
                marginLayoutParams = lp5;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.rightMargin = vt.a.a(context, (float) d18);
            }
        }
        double d19 = this.marginBottom;
        if (d19 != 0.0d) {
            if (!(lp5 instanceof ViewGroup.MarginLayoutParams)) {
                lp5 = null;
            }
            if (lp5 != null) {
                lp5.bottomMargin = vt.a.a(context, (float) d19);
            }
        }
    }

    private final int x(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1901805651) {
                if (hashCode == 3178655 && str.equals("gone")) {
                    return 8;
                }
            } else if (str.equals(QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE)) {
                return 4;
            }
        }
        return 0;
    }

    private final void z(k kVar, ArrayList<com.tencent.android.androidbypass.richui.event.c> arrayList) {
        if (arrayList != null) {
            for (com.tencent.android.androidbypass.richui.event.c cVar : arrayList) {
                if (cVar instanceof com.tencent.android.androidbypass.richui.event.g) {
                    kVar.visibility = D((com.tencent.android.androidbypass.richui.event.g) cVar);
                } else if (cVar instanceof com.tencent.android.androidbypass.richui.event.f) {
                    kVar.width = ((com.tencent.android.androidbypass.richui.event.f) cVar).a();
                } else if (cVar instanceof com.tencent.android.androidbypass.richui.event.d) {
                    kVar.height = ((com.tencent.android.androidbypass.richui.event.d) cVar).a();
                } else if (cVar instanceof com.tencent.android.androidbypass.richui.event.e) {
                    com.tencent.android.androidbypass.richui.event.e eVar = (com.tencent.android.androidbypass.richui.event.e) cVar;
                    kVar.height = eVar.a();
                    kVar.width = eVar.d();
                    if (kVar instanceof f) {
                        ((f) kVar).F(eVar.c());
                    }
                }
            }
        }
    }

    public final void A(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.background = str;
        }
    }

    public final void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.radius = i3;
        }
    }

    @CallSuper
    public void C(@NotNull JSONObject attrData) {
        boolean z16;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) attrData);
            return;
        }
        Intrinsics.checkNotNullParameter(attrData, "attrData");
        boolean z17 = false;
        if (attrData.has("backgroundColor")) {
            String optString = attrData.optString("backgroundColor");
            Intrinsics.checkNotNullExpressionValue(optString, "attrData.optString(Commo\u2026SON_KEY_BACKGROUND_COLOR)");
            this.backgroundColor = optString;
            z16 = true;
        } else {
            z16 = false;
        }
        if (attrData.has("radius")) {
            this.radius = attrData.optInt("radius");
            z16 = true;
        }
        if (attrData.has("bgGradient")) {
            JSONObject jSONObject = attrData.getJSONObject("bgGradient");
            boolean equals = jSONObject.optString("direction").equals("vertical");
            String optString2 = jSONObject.optString("startColor");
            Intrinsics.checkNotNullExpressionValue(optString2, "bgGradientData.optString\u2026nts.JSON_KEY_START_COLOR)");
            String optString3 = jSONObject.optString("endColor");
            Intrinsics.checkNotNullExpressionValue(optString3, "bgGradientData.optString\u2026tants.JSON_KEY_END_COLOR)");
            this.bgGradient = new com.tencent.android.androidbypass.richui.viewdata.b(optString2, optString3, equals);
            z16 = true;
        }
        if (z16 && (view = this.view) != null) {
            b(view);
        }
        if (attrData.has(QZoneDTLoginReporter.SCHEMA)) {
            String optString4 = attrData.optString(QZoneDTLoginReporter.SCHEMA);
            Intrinsics.checkNotNullExpressionValue(optString4, "attrData.optString(Commo\u2026ts.JSON_KEY_CLICK_SCHEMA)");
            this.clickSchema = optString4;
            if (optString4.length() > 0) {
                z17 = true;
            }
            if (z17) {
                View view2 = this.view;
                if (view2 != null) {
                    view2.setOnClickListener(new c());
                    return;
                }
                return;
            }
            View view3 = this.view;
            if (view3 != null) {
                view3.setOnClickListener(null);
            }
        }
    }

    public void c(@NotNull View view) {
        Integer b16;
        Integer b17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        s(layoutParams);
        float f16 = this.height;
        float f17 = 0;
        if (f16 > f17) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            layoutParams.height = vt.a.a(context, this.height);
        } else if (f16 == 0.0f) {
            layoutParams.height = 0;
            layoutParams.weight = 1.0f;
        } else if (f16 == -1.0f) {
            if (!this.options.f() && ((b16 = this.options.b()) == null || b16.intValue() != 0)) {
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.height = -1;
            }
        } else {
            layoutParams.height = (int) f16;
        }
        float f18 = this.width;
        if (f18 > f17) {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            layoutParams.width = vt.a.a(context2, this.width);
        } else if (f18 == 0.0f) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else if (f18 == -1.0f) {
            if (!this.options.f() && ((b17 = this.options.b()) == null || b17.intValue() != 1)) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -1;
            }
        } else {
            layoutParams.width = (int) f18;
        }
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        t(context3, layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public abstract void d(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache);

    public abstract void e(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache);

    @NotNull
    protected abstract View f(@NotNull Context context, @NotNull com.tencent.android.androidbypass.richui.view.i viewDelegateFactory, @Nullable com.tencent.android.androidbypass.richui.view.j listener);

    @Nullable
    public k g(@NotNull String id5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (k) iPatchRedirector.redirect((short) 24, (Object) this, (Object) id5);
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        if (id5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual(this.viewId, id5)) {
            return this;
        }
        return null;
    }

    @NotNull
    public final View h(@NotNull Context context, @NotNull com.tencent.android.androidbypass.richui.view.i viewDelegateFactory, @Nullable com.tencent.android.androidbypass.richui.view.j jVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, this, context, viewDelegateFactory, jVar);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewDelegateFactory, "viewDelegateFactory");
        this.clickListener = jVar;
        View f16 = f(context, viewDelegateFactory, jVar);
        this.view = f16;
        if (this.clickSchema.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16.setOnClickListener(new b());
        }
        c(f16);
        b(f16);
        f16.setVisibility(this.visibility);
        return f16;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.background;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.clickSchema;
    }

    @NotNull
    public final FrameLayout.LayoutParams l(@NotNull Context context, @NotNull LinearLayout.LayoutParams originLp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (FrameLayout.LayoutParams) iPatchRedirector.redirect((short) 27, (Object) this, (Object) context, (Object) originLp);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originLp, "originLp");
        int i3 = originLp.width;
        int i16 = -1;
        if (i3 == 0 && originLp.weight == 1.0f) {
            i3 = -1;
        }
        int i17 = originLp.height;
        if (i17 != 0 || originLp.weight != 1.0f) {
            i16 = i17;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
        t(context, layoutParams);
        layoutParams.gravity = originLp.gravity;
        return layoutParams;
    }

    public final float m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.height;
    }

    @Nullable
    public final View n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.view;
    }

    @NotNull
    public final com.tencent.android.androidbypass.richui.f o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (com.tencent.android.androidbypass.richui.f) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.options;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.radius;
    }

    @NotNull
    public final String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.viewId;
    }

    public final float r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return this.width;
    }

    @CallSuper
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        View view = this.view;
        if (view != null) {
            b(view);
        }
    }

    @NotNull
    public final String v(@NotNull JSONObject jsonObject, @NotNull JSONObject dataJson, @NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, this, jsonObject, dataJson, key);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        Intrinsics.checkNotNullParameter(key, "key");
        return com.tencent.android.androidbypass.richui.utils.a.f72343a.b(jsonObject, dataJson, key);
    }

    @CallSuper
    public void w(@NotNull JSONObject dataJson) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) dataJson);
            return;
        }
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        JSONObject c16 = this.options.c();
        JSONObject a16 = this.options.a();
        String optString = c16.optString("viewId");
        Intrinsics.checkNotNullExpressionValue(optString, "layoutData.optString(Com\u2026nstants.JSON_KEY_VIEW_ID)");
        this.viewId = optString;
        this.width = (float) c16.optDouble("width", this.width);
        this.height = (float) c16.optDouble("height", this.height);
        this.com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_LEFT java.lang.String = c16.optDouble(NodeProps.MARGIN_LEFT);
        this.com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_RIGHT java.lang.String = c16.optDouble(NodeProps.MARGIN_RIGHT);
        this.com.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_TOP java.lang.String = c16.optDouble(NodeProps.MARGIN_TOP);
        this.marginBottom = c16.optDouble(NodeProps.MARGIN_BOTTOM);
        String optString2 = c16.optString(LayoutAttrDefine.Gravity.Gravity, "default");
        Intrinsics.checkNotNullExpressionValue(optString2, "layoutData.optString(Com\u2026tants.GRAVITY, \"default\")");
        this.com.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String = optString2;
        String optString3 = a16.optString("src");
        Intrinsics.checkNotNullExpressionValue(optString3, "attrData.optString(CommonConstants.JSON_KEY_SRC)");
        this.background = optString3;
        String optString4 = a16.optString("backgroundColor");
        Intrinsics.checkNotNullExpressionValue(optString4, "attrData.optString(Commo\u2026SON_KEY_BACKGROUND_COLOR)");
        this.backgroundColor = optString4;
        this.radius = a16.optInt("radius");
        if (a16.has("bgGradient")) {
            JSONObject jSONObject = a16.getJSONObject("bgGradient");
            boolean equals = jSONObject.optString("direction").equals("vertical");
            String optString5 = jSONObject.optString("startColor");
            Intrinsics.checkNotNullExpressionValue(optString5, "bgGradientData.optString\u2026nts.JSON_KEY_START_COLOR)");
            String optString6 = jSONObject.optString("endColor");
            Intrinsics.checkNotNullExpressionValue(optString6, "bgGradientData.optString\u2026tants.JSON_KEY_END_COLOR)");
            this.bgGradient = new com.tencent.android.androidbypass.richui.viewdata.b(optString5, optString6, equals);
        }
        this.clickSchema = v(a16, dataJson, QZoneDTLoginReporter.SCHEMA);
        this.visibility = x(a16.optString("visibility", ""));
        this.eventCollection = com.tencent.android.androidbypass.richui.event.b.f72325a.b(a16.optJSONObject("event"), dataJson);
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        com.tencent.android.androidbypass.richui.event.a aVar = this.eventCollection;
        if (aVar != null) {
            z(this, aVar.a());
        }
    }
}
