package com.tencent.ecommerce.biz.consumer;

import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.JumpInfo;
import com.tencent.ecommerce.richtext.utils.c;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J>\u0010\u001b\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018JP\u0010\u001d\u001a\u00020\u00192\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J\u001e\u0010\u001f\u001a\u00020\u00142\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004J\u001c\u0010!\u001a\u0004\u0018\u00010\u00142\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0016J\u0016\u0010#\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0014J(\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nJ\u0018\u0010)\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010-\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fJ!\u00100\u001a\u00020\u000e2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140.\"\u00020\u0014\u00a2\u0006\u0004\b0\u00101J\u001e\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006\u00a8\u00066"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECGoodsCommonUtils;", "", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/consumer/resp/JumpInfo;", "Lkotlin/collections/ArrayList;", "jumpInfoList", "", h.F, "Landroid/view/View;", "targetView", "", "j", "", "timeMillis", "", "l", "subscribeStatus", "taskStatus", "e", "f", "", WadlProxyConsts.KEY_JUMP_URL, "", "userData", "Lkotlin/Function1;", "", "jumpListener", DomainData.DOMAIN_NAME, "jumpLisener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "arrayList", "o", "redirectLinkMap", "p", "colorStr", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "width", "height", "radius", "Landroid/graphics/drawable/Drawable;", "g", "i", "k", "startTime", "endTime", "c", "", "params", "b", "([Ljava/lang/String;)Z", "followStatus", "d", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGoodsCommonUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ECGoodsCommonUtils f101579a = new ECGoodsCommonUtils();

    ECGoodsCommonUtils() {
    }

    private final int f(int taskStatus) {
        if (taskStatus == 2) {
            return 2;
        }
        if (taskStatus == 9) {
            return 5;
        }
        if (taskStatus == 4) {
            return 2;
        }
        if (taskStatus != 5) {
            if (taskStatus == 6) {
                return 4;
            }
            return 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float j(View targetView) {
        int i3;
        if (targetView.getHeight() > 0) {
            i3 = targetView.getHeight();
        } else {
            i3 = targetView.getLayoutParams().height;
        }
        return i3;
    }

    private final boolean l(long timeMillis) {
        return Long.toString(timeMillis).length() == 10;
    }

    public final boolean b(String... params) {
        if (params.length == 0) {
            return false;
        }
        for (String str : params) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public final String c(long startTime, long endTime) {
        String str = "";
        if (!l(startTime) || !l(endTime) || startTime > endTime) {
            return "";
        }
        long j3 = endTime - startTime;
        long j16 = 86400;
        long j17 = j3 / j16;
        String valueOf = String.valueOf(j17);
        if (j17 != 0) {
            long j18 = 9;
            if (1 <= j17 && j18 >= j17) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append('0');
                sb5.append(j17);
                str = sb5.toString();
            } else {
                str = valueOf;
            }
        }
        long j19 = j3 % j16;
        long j26 = 3600;
        long j27 = j19 / j26;
        String valueOf2 = String.valueOf(j27);
        long j28 = 10;
        if (j27 < j28) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append('0');
            sb6.append(j27);
            valueOf2 = sb6.toString();
        }
        long j29 = j19 % j26;
        long j36 = 60;
        long j37 = j29 / j36;
        String valueOf3 = String.valueOf(j37);
        if (j37 < j28) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append('0');
            sb7.append(j37);
            valueOf3 = sb7.toString();
        }
        long j38 = j29 % j36;
        String valueOf4 = String.valueOf(j38);
        if (j38 < j28) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append('0');
            sb8.append(j38);
            valueOf4 = sb8.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return valueOf2 + ':' + valueOf3 + ':' + valueOf4;
        }
        return str + '\u5929' + valueOf2 + ':' + valueOf3 + ':' + valueOf4;
    }

    public final Drawable g(String colorStr, float width, float height, float radius) {
        boolean contains$default;
        if (TextUtils.isEmpty(colorStr)) {
            return null;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) colorStr, (CharSequence) "linear-gradient", false, 2, (Object) null);
        if (contains$default) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{radius, radius, radius, radius, radius, radius, radius, radius}, null, null));
            shapeDrawable.getPaint().setShader(c.v(colorStr, width, height));
            return shapeDrawable;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(radius);
        gradientDrawable.setColor(com.tencent.ecommerce.richtext.utils.a.c(colorStr));
        return gradientDrawable;
    }

    public final Drawable i(String colorStr, float radius) {
        if (TextUtils.isEmpty(colorStr)) {
            return null;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{radius, radius, radius, radius, radius, radius, radius, radius}, null, null));
        shapeDrawable.getPaint().setColor(com.tencent.ecommerce.richtext.utils.a.c(colorStr));
        return new LayerDrawable(new ClipDrawable[]{new ClipDrawable(shapeDrawable, 8388611, 1)});
    }

    public final float k(View targetView) {
        int i3;
        if (targetView.getWidth() > 0) {
            i3 = targetView.getWidth();
        } else {
            i3 = targetView.getLayoutParams().width;
        }
        return i3;
    }

    public final void m(ArrayList<JumpInfo> jumpInfoList, Map<Object, ? extends Object> userData, Function1<? super String, Unit> jumpLisener) {
        cg0.a.b("ECGoodsCommonUtils", "[multiJumpByList] jumpInfoList = " + jumpInfoList + ", userData = " + userData);
        if (jumpInfoList == null || jumpInfoList.isEmpty()) {
            return;
        }
        if (h(jumpInfoList) != 40) {
            String o16 = o(jumpInfoList);
            ECScheme.e(o16, userData);
            com.tencent.ecommerce.biz.common.c.f101553a.c(o16);
            if (jumpLisener != null) {
                jumpLisener.invoke(o16);
                return;
            }
            return;
        }
        int size = jumpInfoList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            String url = jumpInfoList.get(size).getUrl();
            ECScheme.e(url, userData);
            com.tencent.ecommerce.biz.common.c.f101553a.c(url);
        }
        if (jumpInfoList.size() <= 0 || jumpLisener == null) {
            return;
        }
        jumpLisener.invoke(jumpInfoList.get(0).getUrl());
    }

    public final void n(String jumpUrl, Map<Object, ? extends Object> userData, Function1<? super String, Unit> jumpListener) {
        ECScheme.e(jumpUrl, userData);
        com.tencent.ecommerce.biz.common.c.f101553a.c(jumpUrl);
        if (jumpUrl == null || jumpListener == null) {
            return;
        }
        jumpListener.invoke(jumpUrl);
    }

    public final String o(ArrayList<JumpInfo> arrayList) {
        if (!arrayList.isEmpty()) {
            Iterator<JumpInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (url.length() > 0) {
                    return url;
                }
            }
            return "";
        }
        return "";
    }

    public final void q(final View targetView, final String colorStr) {
        if (TextUtils.isEmpty(colorStr)) {
            return;
        }
        targetView.post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils$setTargetViewGradientColour$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/ecommerce/biz/consumer/ECGoodsCommonUtils$setTargetViewGradientColour$1$a", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements ViewTreeObserver.OnPreDrawListener {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ShapeDrawable f101583e;

                a(ShapeDrawable shapeDrawable) {
                    this.f101583e = shapeDrawable;
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    targetView.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.f101583e.getPaint().setShader(c.v(colorStr, targetView.getMeasuredWidth(), targetView.getMeasuredHeight()));
                    targetView.setBackground(this.f101583e);
                    return true;
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean contains$default;
                float j3;
                float j16;
                float c16 = e.c(4.0f);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) colorStr, (CharSequence) "linear-gradient", false, 2, (Object) null);
                if (contains$default) {
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{c16, c16, c16, c16, c16, c16, c16, c16}, null, null));
                    ECGoodsCommonUtils eCGoodsCommonUtils = ECGoodsCommonUtils.f101579a;
                    if (eCGoodsCommonUtils.k(targetView) > 0.0f) {
                        j3 = eCGoodsCommonUtils.j(targetView);
                        if (j3 > 0.0f) {
                            Paint paint = shapeDrawable.getPaint();
                            String str = colorStr;
                            float k3 = eCGoodsCommonUtils.k(targetView);
                            j16 = eCGoodsCommonUtils.j(targetView);
                            paint.setShader(c.v(str, k3, j16));
                            targetView.setBackground(shapeDrawable);
                            return;
                        }
                    }
                    targetView.getViewTreeObserver().addOnPreDrawListener(new a(shapeDrawable));
                    targetView.setBackground(shapeDrawable);
                    return;
                }
                View view = targetView;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(c16);
                gradientDrawable.setColor(com.tencent.ecommerce.richtext.utils.a.c(colorStr));
                Unit unit = Unit.INSTANCE;
                view.setBackground(gradientDrawable);
            }
        });
    }

    public final String p(Map<Integer, String> redirectLinkMap) {
        String str = redirectLinkMap.get(30);
        if (!(str == null || str.length() == 0)) {
            return redirectLinkMap.get(30);
        }
        String str2 = redirectLinkMap.get(2);
        if (!(str2 == null || str2.length() == 0)) {
            return redirectLinkMap.get(2);
        }
        if (!redirectLinkMap.isEmpty()) {
            Iterator<Map.Entry<Integer, String>> it = redirectLinkMap.entrySet().iterator();
            while (it.hasNext()) {
                String value = it.next().getValue();
                if (value.length() > 0) {
                    return value;
                }
            }
            return "";
        }
        return "";
    }

    private final int h(ArrayList<JumpInfo> jumpInfoList) {
        if (jumpInfoList == null || jumpInfoList.isEmpty()) {
            return 0;
        }
        for (JumpInfo jumpInfo : jumpInfoList) {
            if (jumpInfo.getJumpType() != -1) {
                return jumpInfo.getJumpType();
            }
        }
        return 0;
    }

    private final int e(int subscribeStatus, int taskStatus) {
        if (subscribeStatus == 1) {
            return 100;
        }
        if (subscribeStatus != 2) {
            if (subscribeStatus == 3) {
                return f(taskStatus);
            }
            if (subscribeStatus != 1995001) {
                return -1;
            }
        }
        return 101;
    }

    public final int d(int followStatus, int subscribeStatus, int taskStatus) {
        if (followStatus == 0) {
            return e(subscribeStatus, taskStatus);
        }
        if (followStatus != 1) {
            return followStatus != 2 ? -1 : 103;
        }
        return 102;
    }
}
