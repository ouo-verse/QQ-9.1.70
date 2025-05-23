package com.tencent.mobileqq.component.qrcode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.component.qrcode.utils.GyroscopeRotationSensor;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0002\b\u0000\u0018\u0000 K2\u00020\u0001:\u0002abB)\u0012\u0006\u0010W\u001a\u00020V\u0012\b\u0010Y\u001a\u0004\u0018\u00010X\u0012\u0006\u0010Z\u001a\u00020\u0005\u0012\u0006\u0010[\u001a\u00020\u0005\u00a2\u0006\u0004\b\\\u0010]B\u0011\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u00a2\u0006\u0004\b\\\u0010^B\u001b\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u0012\b\u0010Y\u001a\u0004\u0018\u00010X\u00a2\u0006\u0004\b\\\u0010_B#\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u0012\b\u0010Y\u001a\u0004\u0018\u00010X\u0012\u0006\u0010Z\u001a\u00020\u0005\u00a2\u0006\u0004\b\\\u0010`J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J(\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J(\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J \u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J(\u0010\u001b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\nH\u0014J\b\u0010\u001d\u001a\u00020\nH\u0014J\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\bJ\"\u0010(\u001a\u00020\n2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170%J\u0012\u0010)\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\u000e\u0010*\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0005H\u0014R?\u00107\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR*\u0010U\u001a\u00020M2\u0006\u0010N\u001a\u00020M8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView;", "Landroid/view/View;", "com/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView$c", "f", "()Lcom/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView$c;", "", "errCode", "version", "Lcom/tencent/mobileqq/component/qrcode/g;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/google/zxing/common/BitMatrix;", "bitMatrix", "size", "Lcom/tencent/mobileqq/component/qrcode/d;", "drawQRCodeParams", "l", tl.h.F, "g", "j", "", "dotCenterX", "dotCentY", "perDotSize", "i", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "r", "Lcom/tencent/mobileqq/component/qrcode/e;", "generateQRParams", "setTargetGenerateQRCodeParams", "", "content", DomainData.DOMAIN_NAME, "", NodeProps.COLORS, "positions", "o", "onDraw", "k", "changedView", "visibility", "onVisibilityChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "d", "Lkotlin/jvm/functions/Function1;", "getRefreshLogoSize", "()Lkotlin/jvm/functions/Function1;", "setRefreshLogoSize", "(Lkotlin/jvm/functions/Function1;)V", "refreshLogoSize", "e", "Lcom/tencent/mobileqq/component/qrcode/d;", "Lcom/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView$b;", "Lcom/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView$b;", "qRCodeMatrixGenerator", "Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor;", "Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor;", "rotationSensor", "Landroid/graphics/LinearGradient;", "Landroid/graphics/LinearGradient;", "gradientColorfulBg", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "navigationView", "D", UserInfo.SEX_FEMALE, "totalDegree", "", "value", "E", "Z", "getEnableGyroscopeRotation", "()Z", "setEnableGyroscopeRotation", "(Z)V", "enableGyroscopeRotation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class ColorfulQRCodeOnlyView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView navigationView;

    /* renamed from: D, reason: from kotlin metadata */
    private float totalDegree;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean enableGyroscopeRotation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Integer, Unit> refreshLogoSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d drawQRCodeParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b qRCodeMatrixGenerator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GyroscopeRotationSensor rotationSensor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearGradient gradientColorfulBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView$a;", "", "", "TAG", "Ljava/lang/String;", "", "xGravity", UserInfo.SEX_FEMALE, "yGravity", "<init>", "()V", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.component.qrcode.ColorfulQRCodeOnlyView$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$JH\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000226\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\u0005JF\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000226\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004J>\u0010\u0014\u001a\u00020\n26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0011\u0010\t\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView$b;", "", "", "content", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errCode", "version", "", "callback", "", "a", "Lcom/tencent/mobileqq/component/qrcode/e;", "generateQRParams", "g", "Lcom/tencent/mobileqq/component/qrcode/d;", "d", "f", "b", "I", "mVersion", "Lcom/google/zxing/common/BitMatrix;", "Lcom/google/zxing/common/BitMatrix;", "mBitMatrix", "c", "Lcom/tencent/mobileqq/component/qrcode/e;", "mGenerateQRParams", "Ljava/lang/String;", "mContent", "e", "()I", "()Lcom/google/zxing/common/BitMatrix;", "bitMatrix", "<init>", "()V", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int mVersion;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private BitMatrix mBitMatrix;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private e mGenerateQRParams;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String mContent;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mVersion = -1;
            this.mGenerateQRParams = new e(0, 0, null, null, 15, null);
            this.mContent = "";
        }

        private final boolean a(String content, Function2<? super Integer, ? super Integer, Unit> callback) {
            if (TextUtils.isEmpty(content)) {
                callback.invoke(-11, 0);
                return true;
            }
            if (Intrinsics.areEqual(this.mContent, content)) {
                callback.invoke(-12, 0);
                return true;
            }
            int d16 = this.mGenerateQRParams.d();
            int c16 = this.mGenerateQRParams.c();
            if (d16 <= c16) {
                while (this.mGenerateQRParams.b().containsKey(Integer.valueOf(d16))) {
                    if (d16 != c16) {
                        d16++;
                    }
                }
                callback.invoke(-13, 0);
                return true;
            }
            return false;
        }

        public final void b(@NotNull Function2<? super Integer, ? super Integer, Unit> callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
                return;
            }
            Intrinsics.checkNotNullParameter(callback, "callback");
            int d16 = this.mGenerateQRParams.d();
            int c16 = this.mGenerateQRParams.c();
            if (d16 <= c16) {
                while (true) {
                    QRCodeWriter qRCodeWriter = new QRCodeWriter();
                    HashMap hashMap = new HashMap();
                    hashMap.put(EncodeHintType.MARGIN, 0);
                    EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
                    String name = Charsets.UTF_8.name();
                    Intrinsics.checkNotNullExpressionValue(name, "UTF_8.name()");
                    hashMap.put(encodeHintType, name);
                    hashMap.put(EncodeHintType.ERROR_CORRECTION, this.mGenerateQRParams.a());
                    hashMap.put(EncodeHintType.QRCODE_VERSION, Integer.valueOf(d16));
                    try {
                        this.mVersion = d16;
                        this.mBitMatrix = qRCodeWriter.encode(this.mContent, 0, 0, hashMap);
                        callback.invoke(0, Integer.valueOf(d16));
                        return;
                    } catch (WriterException e16) {
                        e16.printStackTrace();
                        if (d16 == c16) {
                            break;
                        } else {
                            d16++;
                        }
                    }
                }
            }
            this.mVersion = -1;
            this.mBitMatrix = null;
            callback.invoke(-10, -1);
        }

        @Nullable
        public final BitMatrix c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BitMatrix) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mBitMatrix;
        }

        @Nullable
        public final d d(int version) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (d) iPatchRedirector.redirect((short) 5, (Object) this, version);
            }
            return this.mGenerateQRParams.b().get(Integer.valueOf(version));
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.mVersion;
        }

        public final void f(@NotNull String content, @NotNull Function2<? super Integer, ? super Integer, Unit> callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) content, (Object) callback);
                return;
            }
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (a(content, callback)) {
                return;
            }
            this.mContent = content;
            b(callback);
        }

        public final void g(@NotNull e generateQRParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) generateQRParams);
            } else {
                Intrinsics.checkNotNullParameter(generateQRParams, "generateQRParams");
                this.mGenerateQRParams = generateQRParams;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView$c", "Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$b;", "", BasicAnimation.KeyPath.ROTATION_X, BasicAnimation.KeyPath.ROTATION_Y, "rotationZ", "", "onChanged", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements GyroscopeRotationSensor.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ColorfulQRCodeOnlyView.this);
            }
        }

        @Override // com.tencent.mobileqq.component.qrcode.utils.GyroscopeRotationSensor.b
        public void onChanged(float rotationX, float rotationY, float rotationZ) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(rotationX), Float.valueOf(rotationY), Float.valueOf(rotationZ));
                return;
            }
            float f16 = (rotationX * 3.8f) + (rotationY * 3.8f);
            if (Math.abs(ColorfulQRCodeOnlyView.this.totalDegree - f16) > 1.0f) {
                ColorfulQRCodeOnlyView.this.totalDegree = f16;
                ColorfulQRCodeOnlyView.this.invalidate();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorfulQRCodeOnlyView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.qRCodeMatrixGenerator = new b();
        this.rotationSensor = new GyroscopeRotationSensor(context, f());
        this.paint = new Paint(1);
        this.enableGyroscopeRotation = true;
    }

    private final c f() {
        return new c();
    }

    private final void g(Canvas canvas, BitMatrix bitMatrix, int size, d drawQRCodeParams) {
        float f16 = size;
        float width = ((f16 / bitMatrix.getWidth()) / 2) * drawQRCodeParams.e();
        float f17 = f16 / 2.0f;
        float f18 = f17 - width;
        float f19 = f17 + width;
        canvas.drawRoundRect(f18, f18, f19, f19, drawQRCodeParams.d(), drawQRCodeParams.d(), this.paint);
        Function1<? super Integer, Unit> function1 = this.refreshLogoSize;
        if (function1 != null) {
            function1.invoke(Integer.valueOf((int) (width + width)));
        }
    }

    private final void h(Canvas canvas, BitMatrix bitMatrix, int size, d drawQRCodeParams) {
        int width = bitMatrix.getWidth();
        float f16 = size / width;
        float f17 = 2;
        float f18 = f16 / f17;
        float b16 = (f16 - drawQRCodeParams.b()) / f17;
        for (int i3 = 0; i3 < width; i3++) {
            for (int i16 = 0; i16 < width; i16++) {
                if (bitMatrix.get(i3, i16) && ((i3 > 6 || i16 > 6) && ((i3 > 6 || i16 < width - 7) && ((i3 < width - 7 || i16 > 6) && (Math.abs(((i3 * 2) - width) + 1) > drawQRCodeParams.c() - 1 || Math.abs(((i16 * 2) - width) + 1) > drawQRCodeParams.c() - 1))))) {
                    canvas.drawCircle((i3 * f16) + f18, (i16 * f16) + f18, b16, this.paint);
                }
            }
        }
    }

    private final void i(Canvas canvas, float dotCenterX, float dotCentY, float perDotSize) {
        Paint.Style style = this.paint.getStyle();
        float strokeWidth = this.paint.getStrokeWidth();
        this.paint.setStrokeWidth(perDotSize);
        this.paint.setStyle(Paint.Style.STROKE);
        float f16 = 2;
        canvas.drawCircle(dotCenterX, dotCentY, (6 * perDotSize) / f16, this.paint);
        this.paint.setStyle(style);
        this.paint.setStrokeWidth(strokeWidth);
        canvas.drawCircle(dotCenterX, dotCentY, (perDotSize * 3) / f16, this.paint);
    }

    private final void j(Canvas canvas, BitMatrix bitMatrix, int size) {
        float f16 = size;
        float width = f16 / bitMatrix.getWidth();
        float f17 = (7 * width) / 2;
        i(canvas, f17, f17, width);
        float f18 = f16 - f17;
        i(canvas, f17, f18, width);
        i(canvas, f18, f17, width);
    }

    private final void l(Canvas canvas, BitMatrix bitMatrix, int size, d drawQRCodeParams) {
        Matrix matrix = new Matrix();
        float f16 = size / 2;
        matrix.setRotate(this.totalDegree, f16, f16);
        ImageView imageView = this.navigationView;
        if (imageView != null) {
            imageView.setRotation(this.totalDegree - 45);
        }
        LinearGradient linearGradient = this.gradientColorfulBg;
        if (linearGradient != null) {
            linearGradient.setLocalMatrix(matrix);
        }
        h(canvas, bitMatrix, size, drawQRCodeParams);
        j(canvas, bitMatrix, size);
        g(canvas, bitMatrix, size, drawQRCodeParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int errCode, int version, g callback) {
        Unit unit;
        if (errCode != 0) {
            if (errCode != -12) {
                this.drawQRCodeParams = null;
            }
            callback.onResult(errCode);
            return;
        }
        d d16 = this.qRCodeMatrixGenerator.d(version);
        if (d16 != null) {
            this.drawQRCodeParams = d16;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.drawQRCodeParams = null;
            callback.onResult(-13);
        } else {
            callback.onResult(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ColorfulQRCodeOnlyView this$0, List colors, List positions) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(colors, "$colors");
        Intrinsics.checkNotNullParameter(positions, "$positions");
        this$0.o(colors, positions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ColorfulQRCodeOnlyView this$0, LinearGradient colorfulBg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(colorfulBg, "$colorfulBg");
        this$0.gradientColorfulBg = colorfulBg;
        this$0.invalidate();
    }

    public final void k(@NotNull Canvas canvas) {
        int coerceAtMost;
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BitMatrix c16 = this.qRCodeMatrixGenerator.c();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(getMeasuredWidth(), getMeasuredHeight());
        if (coerceAtMost != 0 && c16 != null && (dVar = this.drawQRCodeParams) != null) {
            l(canvas, c16, coerceAtMost, dVar);
        }
    }

    public final void n(@NotNull String content, @NotNull final g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) content, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.qRCodeMatrixGenerator.f(content, new Function2<Integer, Integer, Unit>(callback) { // from class: com.tencent.mobileqq.component.qrcode.ColorfulQRCodeOnlyView$refreshContent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ g $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ColorfulQRCodeOnlyView.this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                } else {
                    ColorfulQRCodeOnlyView.this.m(i3, i16, this.$callback);
                    ColorfulQRCodeOnlyView.this.invalidate();
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r2 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(@NotNull final List<Integer> colors, @NotNull final List<Float> positions) {
        boolean z16;
        int[] intArray;
        float[] floatArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) colors, (Object) positions);
            return;
        }
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(positions, "positions");
        boolean z17 = true;
        if (getMeasuredWidth() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (getMeasuredHeight() != 0.0f) {
                z17 = false;
            }
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.component.qrcode.b
            @Override // java.lang.Runnable
            public final void run() {
                ColorfulQRCodeOnlyView.p(ColorfulQRCodeOnlyView.this, colors, positions);
            }
        });
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        intArray = CollectionsKt___CollectionsKt.toIntArray(colors);
        floatArray = CollectionsKt___CollectionsKt.toFloatArray(positions);
        final LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, measuredWidth, measuredHeight, intArray, floatArray, Shader.TileMode.CLAMP);
        this.paint.setShader(linearGradient);
        if (!isAttachedToWindow()) {
            this.gradientColorfulBg = linearGradient;
            invalidate();
        } else {
            post(new Runnable() { // from class: com.tencent.mobileqq.component.qrcode.c
                @Override // java.lang.Runnable
                public final void run() {
                    ColorfulQRCodeOnlyView.q(ColorfulQRCodeOnlyView.this, linearGradient);
                }
            });
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (this.enableGyroscopeRotation) {
            this.rotationSensor.o();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onDetachedFromWindow();
            this.rotationSensor.p();
        }
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        int coerceAtMost;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        BitMatrix c16 = this.qRCodeMatrixGenerator.c();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(getMeasuredWidth(), getMeasuredHeight());
        if (c16 != null && canvas != null && coerceAtMost != 0 && this.gradientColorfulBg != null) {
            d dVar = this.drawQRCodeParams;
            if (dVar != null) {
                l(canvas, c16, coerceAtMost, dVar);
                return;
            }
            return;
        }
        if (c16 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.iAsync("ColorfulQRCodeOnlyView", 1, "onDraw bitMatrixNull:" + z16 + " canvas:" + canvas + " size:" + coerceAtMost + " gradientColorfulBg:" + this.gradientColorfulBg + " paint.shader:" + this.paint.getShader() + " drawQRCodeParams:" + this.drawQRCodeParams);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) changedView, visibility);
            return;
        }
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        QLog.d("ColorfulQRCodeOnlyView", 1, "onVisibilityChanged changedView:" + changedView + " visibility:" + visibility);
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.totalDegree = 0.0f;
        this.gradientColorfulBg = null;
        this.paint.setShader(null);
        this.rotationSensor.n();
    }

    public final void setEnableGyroscopeRotation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (!z16 && this.rotationSensor.m()) {
            this.rotationSensor.p();
        } else if (z16 && !this.rotationSensor.m() && isAttachedToWindow()) {
            this.rotationSensor.o();
        }
        this.enableGyroscopeRotation = z16;
    }

    public final void setRefreshLogoSize(@Nullable Function1<? super Integer, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function1);
        } else {
            this.refreshLogoSize = function1;
        }
    }

    public final void setTargetGenerateQRCodeParams(@NotNull e generateQRParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) generateQRParams);
            return;
        }
        Intrinsics.checkNotNullParameter(generateQRParams, "generateQRParams");
        this.qRCodeMatrixGenerator.g(generateQRParams);
        if (this.qRCodeMatrixGenerator.c() != null && this.qRCodeMatrixGenerator.e() != -1) {
            b bVar = this.qRCodeMatrixGenerator;
            d d16 = bVar.d(bVar.e());
            if (d16 != null) {
                this.drawQRCodeParams = d16;
                invalidate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorfulQRCodeOnlyView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorfulQRCodeOnlyView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorfulQRCodeOnlyView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, context, attributeSet, Integer.valueOf(i3));
    }
}
