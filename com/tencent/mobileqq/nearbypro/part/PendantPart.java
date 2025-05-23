package com.tencent.mobileqq.nearbypro.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.map.request.GetRecInfoRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xp4.g;
import xp4.i;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00029:B\u0007\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001c\u0010\u001f\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010%\u001a\u00020$H\u0016J\u001c\u0010+\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/PendantPart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mobileqq/soso/location/data/SosoLocation;", "location", "", "K9", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", Const.BUNDLE_KEY_REQUEST, "Lxp4/g;", "rsp", "J9", "Lxp4/i;", "recIcon", "Lcom/tencent/mobileqq/nearbypro/part/PendantPart$BubbleType;", "bubbleType", "N9", "Lqp4/a;", GdtGetUserInfoHandler.KEY_AREA, "M9", "I9", "H9", "", "show", "Landroid/view/View;", "bubbleView", "O9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onPartPause", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/os/Message;", "msg", "handleMessage", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/util/WeakReferenceHandler;", "f", "Lcom/tencent/util/WeakReferenceHandler;", "uiHandler", h.F, "Z", "hasRequestInfo", "i", "Landroid/view/View;", "currentBubble", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "BubbleType", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PendantPart extends e implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReferenceHandler uiHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasRequestInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View currentBubble;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/PendantPart$BubbleType;", "", "(Ljava/lang/String;I)V", "NONE", "REC", "LANDMARK", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public enum BubbleType {
        NONE,
        REC,
        LANDMARK
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/part/PendantPart$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f253661d;

        b(View view) {
            this.f253661d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f253661d.setVisibility(8);
        }
    }

    private final void H9() {
        View view = this.currentBubble;
        if (view != null && view.getVisibility() != 8) {
            O9(false, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I9(qp4.a area) {
        Object firstOrNull;
        boolean z16;
        boolean z17;
        int i3 = area.f429197a;
        String str = null;
        long roomId = ((za2.c) getViewModel(getPartHost(), null, za2.c.class)).getRoomId();
        qp4.b[] bVarArr = area.f429200d;
        Intrinsics.checkNotNullExpressionValue(bVarArr, "area.attachment");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
        qp4.b bVar = (qp4.b) firstOrNull;
        if (bVar != null) {
            str = bVar.f429205c;
        }
        if (str != null) {
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (z16) {
                    str = URLEncoder.encode(str, "utf-8");
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Long.valueOf(roomId);
                if (str == null) {
                    str = "";
                }
                objArr[2] = str;
                String format = String.format("mqqapi://zplan/enterChatLand?appId=%s&roomId=%s&source=6&jump_url=%s", Arrays.copyOf(objArr, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                j.c().d("NBP.Pendant", "handleClickLandmarkEntrance, appId=" + i3 + ", roomId=" + roomId + ", scheme=" + format);
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iZPlanApi.launchScheme(context, format);
            }
        }
        z16 = false;
        if (z16) {
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(i3);
        objArr2[1] = Long.valueOf(roomId);
        if (str == null) {
        }
        objArr2[2] = str;
        String format2 = String.format("mqqapi://zplan/enterChatLand?appId=%s&roomId=%s&source=6&jump_url=%s", Arrays.copyOf(objArr2, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        j.c().d("NBP.Pendant", "handleClickLandmarkEntrance, appId=" + i3 + ", roomId=" + roomId + ", scheme=" + format2);
        IZPlanApi iZPlanApi2 = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        iZPlanApi2.launchScheme(context2, format2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(NearbyProBaseRequest request, g rsp) {
        i iVar;
        int i3;
        BubbleType bubbleType;
        qp4.d dVar;
        Object firstOrNull;
        Object firstOrNull2;
        j.c().d("NBP.Pendant", "handleFetchRecInfo " + rsp);
        i[] iVarArr = rsp.f448322b;
        qp4.a aVar = null;
        if (iVarArr != null) {
            firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(iVarArr);
            iVar = (i) firstOrNull2;
        } else {
            iVar = null;
        }
        qp4.a[] aVarArr = rsp.f448323c;
        if (aVarArr != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(aVarArr);
            aVar = (qp4.a) firstOrNull;
        }
        boolean z16 = false;
        if (aVar != null && (dVar = aVar.f429201e) != null) {
            i3 = dVar.f429212c;
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            z16 = true;
        }
        if (z16) {
            bubbleType = BubbleType.LANDMARK;
        } else {
            bubbleType = BubbleType.NONE;
        }
        if (iVar != null) {
            N9(iVar, bubbleType);
        }
        if (aVar != null) {
            M9(aVar, bubbleType);
        }
        if (bubbleType != BubbleType.NONE) {
            this.uiHandler.removeMessages(100);
            this.uiHandler.sendEmptyMessageDelayed(100, 3000L);
        }
    }

    private final void K9(SosoLocation location) {
        if (this.hasRequestInfo) {
            return;
        }
        this.hasRequestInfo = true;
        if (location != null) {
            j.c().d("NBP.Pendant", "requestPendant, location = " + location + ", address = " + location.address + ", province = " + location.province + ", city = " + location.city + ", district = " + location.district + ", gps = {" + location.mLat02 + ", " + location.mLon02 + "}");
        }
        op4.h hVar = new op4.h();
        if (location != null) {
            hVar.f423334e = location.address;
            op4.f fVar = new op4.f();
            double d16 = 1000000;
            fVar.f423324a = (long) (location.mLat02 * d16);
            fVar.f423325b = (long) (location.mLon02 * d16);
            hVar.f423336g = fVar;
            hVar.f423341l = location.province;
            hVar.f423342m = location.city;
            hVar.f423346q = location.district;
        }
        j.e().c(getContext(), new GetRecInfoRequest(hVar), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.part.f
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                PendantPart.L9(PendantPart.this, (NearbyProBaseRequest) obj, rspStatus, (g) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(final PendantPart this$0, final NearbyProBaseRequest request, final RspStatus rspStatus, final g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.part.PendantPart$requestPendantIfNeeded$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                g gVar2;
                j.c().d("NBP.Pendant", "fetchRecInfo " + RspStatus.this);
                if (!RspStatus.this.c() || (gVar2 = gVar) == null) {
                    return;
                }
                this$0.J9(request, gVar2);
            }
        });
    }

    private final void M9(final qp4.a area, BubbleType bubbleType) {
        View view;
        TextView textView;
        int i3;
        qp4.d dVar;
        RoundImageView roundImageView;
        qp4.d dVar2;
        String[] avatars;
        Object firstOrNull;
        ViewStub viewStub;
        RoundImageView roundImageView2;
        qp4.d dVar3;
        String str;
        final View findViewById;
        ViewStub viewStub2;
        View partRootView = getPartRootView();
        View view2 = null;
        if (partRootView != null && (viewStub2 = (ViewStub) partRootView.findViewById(R.id.f166182yx2)) != null) {
            view = viewStub2.inflate();
        } else {
            view = null;
        }
        if (view != null && (findViewById = view.findViewById(R.id.yct)) != null) {
            final long j3 = 200;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.PendantPart$setupLandmarkEntrance$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.I9(area);
                    final View view3 = findViewById;
                    view3.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.PendantPart$setupLandmarkEntrance$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view3.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
        if (view != null && (roundImageView2 = (RoundImageView) view.findViewById(R.id.ycu)) != null && area != null && (dVar3 = area.f429201e) != null && (str = dVar3.f429214e) != null) {
            PicLoadUtilsKt.c(str, roundImageView2);
        }
        if (bubbleType == BubbleType.LANDMARK) {
            View partRootView2 = getPartRootView();
            if (partRootView2 != null && (viewStub = (ViewStub) partRootView2.findViewById(R.id.f166181yx1)) != null) {
                view2 = viewStub.inflate();
            }
            if (view2 != null && (roundImageView = (RoundImageView) view2.findViewById(R.id.ycr)) != null && (dVar2 = area.f429201e) != null && (avatars = dVar2.f429213d) != null) {
                Intrinsics.checkNotNullExpressionValue(avatars, "avatars");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(avatars);
                String str2 = (String) firstOrNull;
                if (str2 != null) {
                    PicLoadUtilsKt.c(str2, roundImageView);
                }
            }
            if (view2 != null && (textView = (TextView) view2.findViewById(R.id.ycs)) != null) {
                if (area != null && (dVar = area.f429201e) != null) {
                    i3 = dVar.f429212c;
                } else {
                    i3 = 0;
                }
                textView.setText(i3 + "\u4eba\u6b63\u5728\u70ed\u804a");
            }
            if (view2 != null) {
                O9(true, view2);
            }
            this.currentBubble = view2;
        }
    }

    private final void N9(final i recIcon, BubbleType bubbleType) {
        View view;
        final RoundImageView roundImageView;
        np4.e eVar;
        String str;
        ViewStub viewStub;
        View partRootView = getPartRootView();
        if (partRootView != null && (viewStub = (ViewStub) partRootView.findViewById(R.id.yx6)) != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        if (view != null && (roundImageView = (RoundImageView) view.findViewById(R.id.f70723m8)) != null) {
            if (recIcon != null && (eVar = recIcon.f448337d) != null && (str = eVar.f420679a) != null) {
                PicLoadUtilsKt.c(str, roundImageView);
            }
            final long j3 = 200;
            roundImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.PendantPart$setupRecEntrance$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    String str2;
                    String str3;
                    EventCollector.getInstance().onViewClickedBefore(it);
                    roundImageView.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    ga2.a c16 = j.c();
                    i iVar = recIcon;
                    if (iVar != null) {
                        str2 = iVar.f448338e;
                    } else {
                        str2 = null;
                    }
                    c16.d("NBP.Pendant", "handleClickRecEntrance, scheme = " + str2);
                    i iVar2 = recIcon;
                    if (iVar2 != null && (str3 = iVar2.f448338e) != null) {
                        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                        Context context = this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        iZPlanApi.launchScheme(context, str3);
                    }
                    final View view2 = roundImageView;
                    view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.PendantPart$setupRecEntrance$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
    }

    private final void O9(boolean show, View bubbleView) {
        if (show) {
            bubbleView.setAlpha(0.0f);
            bubbleView.setVisibility(0);
            bubbleView.animate().alpha(1.0f).setDuration(300L).setListener(null);
            return;
        }
        bubbleView.animate().alpha(0.0f).setDuration(300L).setListener(new b(bubbleView));
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "MSG_ON_LOCATION_RESULT_AND_SIG_CHECK")) {
            K9((SosoLocation) args);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 100) {
            H9();
            return true;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        this.uiHandler.removeMessages(100);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        H9();
    }
}
