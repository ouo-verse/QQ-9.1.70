package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.config.avatar.AvatarViewConfig;
import com.tencent.mobileqq.config.avatar.ConfigData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JI\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J(\u0010\u001e\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\"\u0010#\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002J*\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010%\u001a\u00020$H\u0002J0\u0010(\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0'2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002J\"\u0010)\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002JK\u0010*\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/OnlineStatusSharePosterHelper;", "", "Landroid/content/Context;", "context", "", "showAvatar", "Landroid/view/View;", "i", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/onlinestatus/model/g;", "onlineStatusData", "", "backgroundUrl", "Landroid/graphics/Bitmap;", "qrCodeBitmap", "Landroid/graphics/drawable/Drawable;", "avatarDrawable", "", "l", "(Landroid/view/View;Lcom/tencent/mobileqq/onlinestatus/model/g;Ljava/lang/String;Landroid/graphics/Bitmap;ZLandroid/graphics/drawable/Drawable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "(Landroid/view/View;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "defaultBackground", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/onlinestatus/au;", "onlineStatusItem", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "simpleInfo", "g", "Landroid/widget/TextView;", "descTextView", "f", "Lkotlin/Pair;", tl.h.F, "j", "e", "(Landroid/content/Context;Lcom/tencent/mobileqq/onlinestatus/model/g;Ljava/lang/String;Landroid/graphics/Bitmap;ZLandroid/graphics/drawable/Drawable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusSharePosterHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(String str, Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        boolean z16 = true;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            str = "https://online-status-avatar.cdn-go.cn/resources/0.0.9/filament/bg_resource/state_bg_cedff1.png";
        }
        QQPicLoader.f201806a.d().download(Option.obtain().setUrl(str), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper$downloadBackground$2$1
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                boolean z17;
                if (loadState == LoadState.STATE_DOWNLOAD_SUCCESS) {
                    final String picLocalPath = QQPicLoader.f201806a.d().getPicLocalPath(option);
                    if (picLocalPath != null && picLocalPath.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (z17) {
                        QLog.d("OnlineStatusSharePosterHelper", 1, "downloadBackground localPath is null");
                        cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper$downloadBackground$2$1.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    final CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl;
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper$downloadBackground$2$1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Bitmap decodeFile = BitmapUtil.decodeFile(picLocalPath);
                            if (QLog.isDevelopLevel()) {
                                QLog.d("OnlineStatusSharePosterHelper", 4, "downloadBackground success");
                            }
                            cancellableContinuation.resume(decodeFile, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper.downloadBackground.2.1.2.1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    }, 16, null, true);
                    return;
                }
                if (loadState == LoadState.STATE_DOWNLOAD_FAILED) {
                    QLog.d("OnlineStatusSharePosterHelper", 1, "downloadBackground failed");
                    cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper$downloadBackground$2$1.3
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final String f(com.tencent.mobileqq.onlinestatus.model.g onlineStatusData, au onlineStatusItem, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo, TextView descTextView) {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        if (onlineStatusItem.f255489b == 2000) {
            if (onlineStatusData.f256022a == AppRuntime.Status.online) {
                af C = af.C();
                if (onlineStatusItem.f255489b > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return C.x(peekAppRuntime, simpleInfo, descTextView, 3, onlineStatusItem, Boolean.valueOf(z16));
            }
            return af.C().o(peekAppRuntime, onlineStatusItem, onlineStatusData.f256022a, simpleInfo, descTextView, 3);
        }
        return onlineStatusItem.f255490c;
    }

    private final Drawable g(com.tencent.mobileqq.onlinestatus.model.g onlineStatusData, au onlineStatusItem, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo) {
        Drawable O;
        boolean z16;
        AppRuntime.Status status = onlineStatusData.f256022a;
        AppRuntime.Status status2 = AppRuntime.Status.online;
        if (status == status2) {
            af C = af.C();
            if (onlineStatusItem.f255489b > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!C.h0(onlineStatusItem, simpleInfo, z16)) {
                O = af.C().O(0L, status2, 1, simpleInfo, 0);
                return com.tencent.mobileqq.onlinestatus.utils.j.a(O);
            }
        }
        O = af.C().O(onlineStatusData.f256023b, onlineStatusData.f256022a, 1, simpleInfo, 0);
        return com.tencent.mobileqq.onlinestatus.utils.j.a(O);
    }

    private final Pair<String, String> h(com.tencent.mobileqq.onlinestatus.model.g onlineStatusData, au onlineStatusItem, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo) {
        String str;
        String str2;
        au auVar;
        ArrayList<au> arrayList;
        Object orNull;
        int i3 = bs.r(onlineStatusData.f256022a, onlineStatusData.f256023b).f256383a;
        int t16 = bs.t(simpleInfo, i3);
        ConfigData f16 = AvatarViewConfig.INSTANCE.a().f(i3, t16);
        if (OnlineStatusToggleUtils.d()) {
            if (onlineStatusItem.f255489b == 1000 && onlineStatusItem.f255494g == AppRuntime.Status.online && (arrayList = onlineStatusItem.f255512y) != null && arrayList.size() > 0) {
                ArrayList<au> arrayList2 = onlineStatusItem.f255512y;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "onlineStatusItem.batteryList");
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList2, t16);
                auVar = (au) orNull;
            } else {
                auVar = null;
            }
            if (auVar != null) {
                str = auVar.f255508u;
                str2 = auVar.f255509v;
            } else {
                String str3 = onlineStatusItem.f255508u;
                String str4 = onlineStatusItem.f255509v;
                str = str3;
                str2 = str4;
            }
        } else if (f16 != null) {
            str = f16.getPosterText();
            str2 = f16.getPosterStatusTextColor();
        } else {
            str = "";
            str2 = "";
        }
        return new Pair<>(str, str2);
    }

    private final View i(Context context, boolean showAvatar) {
        int i3;
        LayoutInflater from = LayoutInflater.from(context);
        if (showAvatar) {
            i3 = R.layout.f167530dq1;
        } else {
            i3 = R.layout.f167532dq3;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        from.inflate(i3, frameLayout);
        return frameLayout;
    }

    private final void j(View container, boolean showAvatar, Drawable avatarDrawable) {
        ImageView imageView;
        if (showAvatar && avatarDrawable != null && (imageView = (ImageView) container.findViewById(R.id.zyb)) != null) {
            imageView.setImageDrawable(avatarDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k(View view, String str, Continuation<? super Unit> continuation) {
        OnlineStatusSharePosterHelper$updateBackground$1 onlineStatusSharePosterHelper$updateBackground$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        MainCoroutineDispatcher main;
        OnlineStatusSharePosterHelper$updateBackground$3 onlineStatusSharePosterHelper$updateBackground$3;
        if (continuation instanceof OnlineStatusSharePosterHelper$updateBackground$1) {
            onlineStatusSharePosterHelper$updateBackground$1 = (OnlineStatusSharePosterHelper$updateBackground$1) continuation;
            int i16 = onlineStatusSharePosterHelper$updateBackground$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                onlineStatusSharePosterHelper$updateBackground$1.label = i16 - Integer.MIN_VALUE;
                Object obj = onlineStatusSharePosterHelper$updateBackground$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = onlineStatusSharePosterHelper$updateBackground$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) onlineStatusSharePosterHelper$updateBackground$1.L$1;
                    View view2 = (View) onlineStatusSharePosterHelper$updateBackground$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef = objectRef2;
                    view = view2;
                } else {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    OnlineStatusSharePosterHelper$updateBackground$2 onlineStatusSharePosterHelper$updateBackground$2 = new OnlineStatusSharePosterHelper$updateBackground$2(str, objectRef, this, null);
                    onlineStatusSharePosterHelper$updateBackground$1.L$0 = view;
                    onlineStatusSharePosterHelper$updateBackground$1.L$1 = objectRef;
                    onlineStatusSharePosterHelper$updateBackground$1.label = 1;
                    if (BuildersKt.withContext(io5, onlineStatusSharePosterHelper$updateBackground$2, onlineStatusSharePosterHelper$updateBackground$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                main = Dispatchers.getMain();
                onlineStatusSharePosterHelper$updateBackground$3 = new OnlineStatusSharePosterHelper$updateBackground$3(view, objectRef, null);
                onlineStatusSharePosterHelper$updateBackground$1.L$0 = null;
                onlineStatusSharePosterHelper$updateBackground$1.L$1 = null;
                onlineStatusSharePosterHelper$updateBackground$1.label = 2;
                if (BuildersKt.withContext(main, onlineStatusSharePosterHelper$updateBackground$3, onlineStatusSharePosterHelper$updateBackground$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        onlineStatusSharePosterHelper$updateBackground$1 = new OnlineStatusSharePosterHelper$updateBackground$1(this, continuation);
        Object obj2 = onlineStatusSharePosterHelper$updateBackground$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusSharePosterHelper$updateBackground$1.label;
        if (i3 == 0) {
        }
        main = Dispatchers.getMain();
        onlineStatusSharePosterHelper$updateBackground$3 = new OnlineStatusSharePosterHelper$updateBackground$3(view, objectRef, null);
        onlineStatusSharePosterHelper$updateBackground$1.L$0 = null;
        onlineStatusSharePosterHelper$updateBackground$1.L$1 = null;
        onlineStatusSharePosterHelper$updateBackground$1.label = 2;
        if (BuildersKt.withContext(main, onlineStatusSharePosterHelper$updateBackground$3, onlineStatusSharePosterHelper$updateBackground$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(View view, com.tencent.mobileqq.onlinestatus.model.g gVar, String str, Bitmap bitmap, boolean z16, Drawable drawable, Continuation<? super Unit> continuation) {
        OnlineStatusSharePosterHelper$updateData$1 onlineStatusSharePosterHelper$updateData$1;
        Object coroutine_suspended;
        int i3;
        boolean z17;
        OnlineStatusSharePosterHelper onlineStatusSharePosterHelper;
        if (continuation instanceof OnlineStatusSharePosterHelper$updateData$1) {
            onlineStatusSharePosterHelper$updateData$1 = (OnlineStatusSharePosterHelper$updateData$1) continuation;
            int i16 = onlineStatusSharePosterHelper$updateData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                onlineStatusSharePosterHelper$updateData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = onlineStatusSharePosterHelper$updateData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = onlineStatusSharePosterHelper$updateData$1.label;
                z17 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        z16 = onlineStatusSharePosterHelper$updateData$1.Z$0;
                        drawable = (Drawable) onlineStatusSharePosterHelper$updateData$1.L$5;
                        bitmap = (Bitmap) onlineStatusSharePosterHelper$updateData$1.L$4;
                        str = (String) onlineStatusSharePosterHelper$updateData$1.L$3;
                        gVar = (com.tencent.mobileqq.onlinestatus.model.g) onlineStatusSharePosterHelper$updateData$1.L$2;
                        view = (View) onlineStatusSharePosterHelper$updateData$1.L$1;
                        onlineStatusSharePosterHelper = (OnlineStatusSharePosterHelper) onlineStatusSharePosterHelper$updateData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    onlineStatusSharePosterHelper$updateData$1.L$0 = this;
                    onlineStatusSharePosterHelper$updateData$1.L$1 = view;
                    onlineStatusSharePosterHelper$updateData$1.L$2 = gVar;
                    onlineStatusSharePosterHelper$updateData$1.L$3 = str;
                    onlineStatusSharePosterHelper$updateData$1.L$4 = bitmap;
                    onlineStatusSharePosterHelper$updateData$1.L$5 = drawable;
                    onlineStatusSharePosterHelper$updateData$1.Z$0 = z16;
                    onlineStatusSharePosterHelper$updateData$1.label = 1;
                    if (k(view, str, onlineStatusSharePosterHelper$updateData$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    onlineStatusSharePosterHelper = this;
                }
                onlineStatusSharePosterHelper.o(view);
                onlineStatusSharePosterHelper.p(view, z16);
                onlineStatusSharePosterHelper.m(view);
                onlineStatusSharePosterHelper.r(view);
                onlineStatusSharePosterHelper.q(view, bitmap);
                if (str != null && str.length() != 0) {
                    z17 = false;
                }
                onlineStatusSharePosterHelper.n(view, gVar, z16, z17);
                onlineStatusSharePosterHelper.j(view, z16, drawable);
                return Unit.INSTANCE;
            }
        }
        onlineStatusSharePosterHelper$updateData$1 = new OnlineStatusSharePosterHelper$updateData$1(this, continuation);
        Object obj2 = onlineStatusSharePosterHelper$updateData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusSharePosterHelper$updateData$1.label;
        z17 = true;
        if (i3 == 0) {
        }
        onlineStatusSharePosterHelper.o(view);
        onlineStatusSharePosterHelper.p(view, z16);
        onlineStatusSharePosterHelper.m(view);
        onlineStatusSharePosterHelper.r(view);
        onlineStatusSharePosterHelper.q(view, bitmap);
        if (str != null) {
            z17 = false;
        }
        onlineStatusSharePosterHelper.n(view, gVar, z16, z17);
        onlineStatusSharePosterHelper.j(view, z16, drawable);
        return Unit.INSTANCE;
    }

    private final void m(View container) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String buddyName = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(str, false);
        TextView textView = (TextView) container.findViewById(R.id.f61792z3);
        if (textView != null) {
            textView.setText(buddyName);
        }
    }

    private final void n(View container, com.tencent.mobileqq.onlinestatus.model.g onlineStatusData, boolean showAvatar, boolean defaultBackground) {
        int i3;
        TextView textView;
        au I = af.C().I(onlineStatusData.f256022a, onlineStatusData.f256023b);
        Intrinsics.checkNotNullExpressionValue(I, "getInstance().getOnlineS\u2026Data.mExtStatus\n        )");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnlineStatusSharePosterHelper");
        if (H == null) {
            QLog.e("OnlineStatusSharePosterHelper", 1, "updateOnlineStatus simpleInfo is null");
            return;
        }
        if (showAvatar) {
            i3 = R.id.fd9;
        } else {
            i3 = R.id.zxn;
        }
        ImageView imageView = (ImageView) container.findViewById(i3);
        if (imageView != null) {
            imageView.setImageDrawable(g(onlineStatusData, I, H));
        }
        Pair<String, String> h16 = h(onlineStatusData, I, H);
        String first = h16.getFirst();
        String second = h16.getSecond();
        if (!TextUtils.isEmpty(first) && (textView = (TextView) container.findViewById(R.id.f84474mc)) != null) {
            textView.setText(first);
        }
        TextView onlineStatusDescTextView = (TextView) container.findViewById(R.id.zy5);
        Intrinsics.checkNotNullExpressionValue(onlineStatusDescTextView, "onlineStatusDescTextView");
        onlineStatusDescTextView.setText(f(onlineStatusData, I, H, onlineStatusDescTextView));
        if (!TextUtils.isEmpty(second) && !defaultBackground) {
            try {
                onlineStatusDescTextView.setTextColor(Color.parseColor(second));
            } catch (Throwable unused) {
                QLog.e("OnlineStatusSharePosterHelper", 1, "parse posterTextColor error, color is ", second);
            }
        } else if (defaultBackground) {
            onlineStatusDescTextView.setTextColor(container.getContext().getColor(R.color.cez));
        }
    }

    private final void o(View container) {
        ImageView imageView = (ImageView) container.findViewById(R.id.f59152ry);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            imageView.setImageDrawable(BaseImageUtil.maskDrawableByColor(drawable, -16777216));
        }
        ImageView imageView2 = (ImageView) container.findViewById(R.id.f59162rz);
        Drawable drawable2 = imageView2.getDrawable();
        if (drawable2 != null) {
            imageView2.setImageDrawable(BaseImageUtil.maskDrawableByColor(drawable2, -16777216));
        }
    }

    private final void p(View container, boolean showAvatar) {
        String str;
        if (showAvatar) {
            return;
        }
        ImageView imageView = (ImageView) container.findViewById(R.id.gqx);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
        qQProAvatarDrawable.q(container.getContext(), 1, str);
        imageView.setImageDrawable(qQProAvatarDrawable);
    }

    private final void q(View container, Bitmap qrCodeBitmap) {
        ImageView imageView = (ImageView) container.findViewById(R.id.f84484md);
        if (imageView != null) {
            imageView.setImageBitmap(qrCodeBitmap);
        }
    }

    private final void r(View container) {
        String format = new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        TextView textView = (TextView) container.findViewById(R.id.f84264ls);
        if (textView != null) {
            textView.setText(format);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(@NotNull Context context, @NotNull com.tencent.mobileqq.onlinestatus.model.g gVar, @Nullable String str, @Nullable Bitmap bitmap, boolean z16, @Nullable Drawable drawable, @NotNull Continuation<? super Bitmap> continuation) {
        OnlineStatusSharePosterHelper$generatePosterBitmap$1 onlineStatusSharePosterHelper$generatePosterBitmap$1;
        Object coroutine_suspended;
        int i3;
        boolean z17;
        boolean z18;
        View view;
        try {
            if (continuation instanceof OnlineStatusSharePosterHelper$generatePosterBitmap$1) {
                onlineStatusSharePosterHelper$generatePosterBitmap$1 = (OnlineStatusSharePosterHelper$generatePosterBitmap$1) continuation;
                int i16 = onlineStatusSharePosterHelper$generatePosterBitmap$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    onlineStatusSharePosterHelper$generatePosterBitmap$1.label = i16 - Integer.MIN_VALUE;
                    OnlineStatusSharePosterHelper$generatePosterBitmap$1 onlineStatusSharePosterHelper$generatePosterBitmap$12 = onlineStatusSharePosterHelper$generatePosterBitmap$1;
                    Object obj = onlineStatusSharePosterHelper$generatePosterBitmap$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = onlineStatusSharePosterHelper$generatePosterBitmap$12.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            view = (View) onlineStatusSharePosterHelper$generatePosterBitmap$12.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (z16) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        View i17 = i(context, z17);
                        if (z16) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        onlineStatusSharePosterHelper$generatePosterBitmap$12.L$0 = i17;
                        onlineStatusSharePosterHelper$generatePosterBitmap$12.label = 1;
                        if (l(i17, gVar, str, bitmap, z18, drawable, onlineStatusSharePosterHelper$generatePosterBitmap$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        view = i17;
                    }
                    int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.bwx);
                    int dimensionPixelSize2 = view.getResources().getDimensionPixelSize(R.dimen.bww);
                    view.measure(View.MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824), View.MeasureSpec.makeMeasureSpec(dimensionPixelSize2, 1073741824));
                    view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                    Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawColor(-1);
                    view.draw(canvas);
                    return createBitmap;
                }
            }
            if (i3 == 0) {
            }
            int dimensionPixelSize3 = view.getResources().getDimensionPixelSize(R.dimen.bwx);
            int dimensionPixelSize22 = view.getResources().getDimensionPixelSize(R.dimen.bww);
            view.measure(View.MeasureSpec.makeMeasureSpec(dimensionPixelSize3, 1073741824), View.MeasureSpec.makeMeasureSpec(dimensionPixelSize22, 1073741824));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize3, dimensionPixelSize22, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            canvas2.drawColor(-1);
            view.draw(canvas2);
            return createBitmap2;
        } catch (Exception e16) {
            QLog.e("OnlineStatusSharePosterHelper", 1, "generatePosterBitmap error: ", e16);
            return null;
        }
        onlineStatusSharePosterHelper$generatePosterBitmap$1 = new OnlineStatusSharePosterHelper$generatePosterBitmap$1(this, continuation);
        OnlineStatusSharePosterHelper$generatePosterBitmap$1 onlineStatusSharePosterHelper$generatePosterBitmap$122 = onlineStatusSharePosterHelper$generatePosterBitmap$1;
        Object obj2 = onlineStatusSharePosterHelper$generatePosterBitmap$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusSharePosterHelper$generatePosterBitmap$122.label;
    }
}
