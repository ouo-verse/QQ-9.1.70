package com.tencent.mobileqq.zplan.couple.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.activity.aio.zplan.g;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleBubbleConfig;
import com.tencent.mobileqq.zplan.show.MsgData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.zplan.common.utils.h;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;
import t74.l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002JB\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J,\u0010!\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000fH\u0002J\u001f\u0010$\u001a\u0004\u0018\u00010\u00162\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J8\u0010&\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010(R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010+R\u0014\u0010.\u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/manager/ZPlanCoupleGuideBubblePlayManager;", "Lcom/tencent/mobileqq/zplan/couple/manager/a;", "", "p", "Landroid/content/Context;", "context", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "textureView", "Landroid/graphics/Point;", "headPoint", "Landroid/text/Spanned;", "bubbleSpanText", "", "guideBubbleId", "", "j", "Lcom/tencent/mobileqq/zplan/couple/config/a;", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "headPointEventData", "Lkotlin/Pair;", "Lorg/json/JSONObject;", DomainData.DOMAIN_NAME, "dataJSONObject", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "elementView", "eventId", "bubbleId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/zplan/show/b;", "inputInfo", "c", "(Lcom/tencent/mobileqq/zplan/show/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "b", "I", "requestHeadPointIndex", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "requestIdDataMap", "Ljava/lang/String;", "GUIDE_SHOW_INDEX_MMKV_KEY", "Lcom/tencent/mobileqq/activity/aio/zplan/g;", "d", "Lcom/tencent/mobileqq/activity/aio/zplan/g;", "existBubble", "<init>", "()V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanCoupleGuideBubblePlayManager implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int requestHeadPointIndex = 10000;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Integer, String> requestIdDataMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String GUIDE_SHOW_INDEX_MMKV_KEY = "ZPLAN_COUPLE_GUIDE_BUBBLE_SHOW_INDEX";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private g existBubble;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ZPlanCoupleGuideBubblePlayManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            g gVar = this$0.existBubble;
            if (gVar != null) {
                gVar.dismiss();
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "destroyBubble failed.", th5);
        }
    }

    private final void j(Context context, Activity activity, final View rootView, View textureView, Point headPoint, final Spanned bubbleSpanText, final int guideBubbleId) {
        TextView b16;
        if (p()) {
            final g gVar = new g(context);
            gVar.setFocusable(true);
            gVar.setOutsideTouchable(true);
            if ((bubbleSpanText.length() > 0) && (b16 = gVar.b()) != null) {
                b16.setText(bubbleSpanText);
                b16.setTextSize(10.0f);
                b16.setVisibility(0);
            }
            View contentView = gVar.getContentView();
            contentView.measure(-2, -2);
            int measuredWidth = headPoint.x - (contentView.getMeasuredWidth() / 2);
            int measuredHeight = contentView.getMeasuredHeight() + headPoint.y + ViewUtils.f352270a.b(16);
            QLog.i("ZPlanCoupleGuideBubblePlayManager", 1, "showAsDropDownBubble, offset: x: " + measuredWidth + ", y: " + measuredHeight + ", \nrichText: " + ((Object) bubbleSpanText));
            if (activity.isFinishing()) {
                QLog.w("ZPlanCoupleGuideBubblePlayManager", 1, "doShowBubble failed, activity finishing.");
                return;
            }
            g gVar2 = this.existBubble;
            if (gVar2 != null) {
                gVar2.dismiss();
            }
            this.existBubble = gVar;
            gVar.showAsDropDown(textureView, measuredWidth, -measuredHeight);
            q(rootView, gVar.getContentView(), "dt_imp", guideBubbleId);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.couple.manager.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanCoupleGuideBubblePlayManager.k(bubbleSpanText, gVar, this, rootView, guideBubbleId);
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Spanned bubbleSpanText, g bubblePopupWindow, ZPlanCoupleGuideBubblePlayManager this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(bubbleSpanText, "$bubbleSpanText");
        Intrinsics.checkNotNullParameter(bubblePopupWindow, "$bubblePopupWindow");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanCoupleGuideBubblePlayManager", 1, "bubble dismiss, richText: " + ((Object) bubbleSpanText) + ".");
        bubblePopupWindow.dismiss();
        this$0.existBubble = null;
        this$0.q(view, bubblePopupWindow.getContentView(), "dt_imp_end", i3);
    }

    private final Object l(Continuation<? super ZPlanCoupleBubbleConfig> continuation) {
        return CoroutineScopeKt.coroutineScope(new ZPlanCoupleGuideBubblePlayManager$getBubbleConfig$2(this, null), continuation);
    }

    private final JSONObject m(JSONObject dataJSONObject) {
        if (dataJSONObject.has("requestNodePointDataId")) {
            String str = this.requestIdDataMap.get(Integer.valueOf(dataJSONObject.optInt("requestNodePointDataId", -1)));
            if (str == null) {
                return null;
            }
            return new JSONObject(str);
        }
        QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "handleGetNodePoint failed, requestId in data invalid.");
        return null;
    }

    private final Pair<Point, JSONObject> n(String headPointEventData) {
        JSONObject b16 = h.f385294a.b(headPointEventData);
        if (b16 == null) {
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "getBubbleShowData failed, headPointEventData invalid.");
            return null;
        }
        if (!b16.optBoolean("isSuccess", false)) {
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "getBubbleShowData failed, errMsg: " + b16.optString("errMsg", ""));
            return null;
        }
        JSONObject m3 = m(b16);
        if (m3 == null) {
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "getBubbleShowData failed, bubbleContentJSON invalid.");
            return null;
        }
        Point o16 = o(b16);
        if (o16 == null) {
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "getBubbleShowData failed, headPoint invalid.");
            return null;
        }
        QLog.i("ZPlanCoupleGuideBubblePlayManager", 1, "getBubbleShowData, bubbleContent: " + m3 + ", headPoint: " + o16);
        return new Pair<>(o16, m3);
    }

    private final Point o(JSONObject dataJSONObject) {
        if (dataJSONObject.has("requestNodePointDataId")) {
            int optInt = dataJSONObject.optInt("headPointX", -1);
            if (dataJSONObject.has("headPointY")) {
                int optInt2 = dataJSONObject.optInt("headPointY", -1);
                QLog.i("ZPlanCoupleGuideBubblePlayManager", 1, "getHeadPoint, nodeX: " + optInt + ", nodeY: " + optInt2);
                return new Point(optInt, optInt2);
            }
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "handleGetNodePoint failed, HEAD_POINT_Y in data invalid.");
            return null;
        }
        QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "handleGetNodePoint failed, HEAD_POINT_X in data invalid.");
        return null;
    }

    private final boolean p() {
        String onGetCurrentPeekUin = ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onGetCurrentPeekUin();
        if (onGetCurrentPeekUin == null) {
            return true;
        }
        return ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(onGetCurrentPeekUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(View view, View view2, String eventId, int i3) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(eventId, "$eventId");
        try {
            VideoReport.setLogicParent(view, view2);
            VideoReport.setElementId(view, "em_zplan_avatar_bubble");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_avatar_bubble_type", Integer.valueOf(i3)));
            VideoReport.reportEvent(eventId, view, hashMapOf);
        } catch (Throwable th5) {
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "reportGuideBubble failed.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ZPlanCoupleGuideBubblePlayManager this$0, Context context, Activity activity, View view, View view2, Point headPoint, Spanned bubbleSpanText, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(headPoint, "$headPoint");
        try {
            Intrinsics.checkNotNullExpressionValue(bubbleSpanText, "bubbleSpanText");
            this$0.j(context, activity, view, view2, headPoint, bubbleSpanText, i3);
        } catch (Throwable th5) {
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "showBubble failed.", th5);
        }
    }

    @Override // com.tencent.mobileqq.zplan.couple.manager.a
    public void a(final Context context, final Activity activity, final View rootView, final View textureView, String headPointEventData) {
        Spanned fromHtml;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (context != null && textureView != null) {
            Pair<Point, JSONObject> n3 = n(headPointEventData);
            if (n3 == null) {
                return;
            }
            final Point component1 = n3.component1();
            JSONObject component2 = n3.component2();
            int i3 = component1.x;
            if (i3 > 0 && component1.y > 0 && i3 <= textureView.getWidth() && component1.y <= textureView.getHeight()) {
                String it = component2.optString("text", "");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!(it.length() > 0)) {
                    it = null;
                }
                if (it == null) {
                    return;
                }
                final int optInt = component2.optInt("bubbleId", -1);
                if (Build.VERSION.SDK_INT >= 24) {
                    fromHtml = Html.fromHtml(it, 63);
                } else {
                    fromHtml = Html.fromHtml(it);
                }
                final Spanned spanned = fromHtml;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.couple.manager.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanCoupleGuideBubblePlayManager.s(ZPlanCoupleGuideBubblePlayManager.this, context, activity, rootView, textureView, component1, spanned, optInt);
                    }
                });
                return;
            }
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "showBubble failed, headPoint invalid.");
            return;
        }
        QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "showBubble failed, context or textureView null.");
    }

    @Override // com.tencent.mobileqq.zplan.couple.manager.a
    public void b() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.couple.manager.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanCoupleGuideBubblePlayManager.i(ZPlanCoupleGuideBubblePlayManager.this);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.mobileqq.zplan.couple.manager.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(MsgData msgData, Continuation<? super String> continuation) {
        ZPlanCoupleGuideBubblePlayManager$getBubbleEventData$1 zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1;
        Object coroutine_suspended;
        int i3;
        ZPlanCoupleGuideBubblePlayManager zPlanCoupleGuideBubblePlayManager;
        ZPlanCoupleBubbleConfig zPlanCoupleBubbleConfig;
        if (continuation instanceof ZPlanCoupleGuideBubblePlayManager$getBubbleEventData$1) {
            zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1 = (ZPlanCoupleGuideBubblePlayManager$getBubbleEventData$1) continuation;
            int i16 = zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.L$0 = this;
                    zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.label = 1;
                    obj = l(zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanCoupleGuideBubblePlayManager = this;
                } else if (i3 == 1) {
                    zPlanCoupleGuideBubblePlayManager = (ZPlanCoupleGuideBubblePlayManager) zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                zPlanCoupleBubbleConfig = (ZPlanCoupleBubbleConfig) obj;
                if (zPlanCoupleBubbleConfig != null) {
                    return null;
                }
                int id5 = zPlanCoupleBubbleConfig.getId();
                String richText = zPlanCoupleBubbleConfig.getRichText();
                if (richText == null || richText.length() == 0) {
                    QLog.w("ZPlanCoupleGuideBubblePlayManager", 1, "guideBubbleRichText null or empty.");
                    return null;
                }
                int i17 = zPlanCoupleGuideBubblePlayManager.requestHeadPointIndex;
                if (i17 + 1 >= 20000) {
                    zPlanCoupleGuideBubblePlayManager.requestHeadPointIndex = 10000;
                } else {
                    zPlanCoupleGuideBubblePlayManager.requestHeadPointIndex = i17 + 1;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", richText);
                jSONObject.put("bubbleId", id5);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026eId)\n        }.toString()");
                zPlanCoupleGuideBubblePlayManager.requestIdDataMap.put(Boxing.boxInt(i17), jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("renderObjectType", "renderObjectRightAvatar");
                jSONObject3.put("renderObjectNodeName", "parietal");
                jSONObject3.put("requestNodePointDataId", i17);
                QLog.i("ZPlanCoupleGuideBubblePlayManager", 1, "getBubbleEventData, text: " + richText);
                return jSONObject3.toString();
            }
        }
        zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1 = new ZPlanCoupleGuideBubblePlayManager$getBubbleEventData$1(this, continuation);
        Object obj2 = zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanCoupleGuideBubblePlayManager$getBubbleEventData$1.label;
        if (i3 != 0) {
        }
        zPlanCoupleBubbleConfig = (ZPlanCoupleBubbleConfig) obj2;
        if (zPlanCoupleBubbleConfig != null) {
        }
    }

    private final void q(final View rootView, final View elementView, final String eventId, final int bubbleId) {
        if (rootView == null || elementView == null) {
            return;
        }
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.couple.manager.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanCoupleGuideBubblePlayManager.r(elementView, rootView, eventId, bubbleId);
            }
        });
    }
}
