package com.tencent.robot.adelie.homepage.utils;

import android.graphics.Bitmap;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002Jq\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022Q\u0010\n\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/AdelieGuideUtil;", "", "", "url", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bgBitmap", "", "callBack", "b", "fullScreenBgUrl", "bannerBgUrl", "robotUrl", "Lkotlin/Function3;", "fullScreenBitmap", "bannerBgBitmap", "robotBitmap", "d", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieGuideUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdelieGuideUtil f366639a = new AdelieGuideUtil();

    AdelieGuideUtil() {
    }

    private final void b(final String url, final Function1<? super Bitmap, Unit> callBack) {
        Option option = Option.obtain().setUrl(url);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.utils.j
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                AdelieGuideUtil.c(url, callBack, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String url, Function1 callBack, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        QLog.i("AdelieGuideAutoControllerImpl", 1, "loadImage onStateChange: " + loadState + ", url=" + url);
        if (loadState == LoadState.STATE_SUCCESS) {
            callBack.invoke(option.getResultBitMap());
        }
    }

    public final void d(@NotNull String fullScreenBgUrl, @NotNull String bannerBgUrl, @NotNull String robotUrl, @NotNull final Function3<? super Bitmap, ? super Bitmap, ? super Bitmap, Unit> callBack) {
        Intrinsics.checkNotNullParameter(fullScreenBgUrl, "fullScreenBgUrl");
        Intrinsics.checkNotNullParameter(bannerBgUrl, "bannerBgUrl");
        Intrinsics.checkNotNullParameter(robotUrl, "robotUrl");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        QLog.i("AdelieGuideAutoControllerImpl", 1, "preloadRobotGuideBg " + fullScreenBgUrl);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        b(fullScreenBgUrl, new Function1<Bitmap, Unit>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieGuideUtil$preloadRobotGuideBg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                objectRef.element = bitmap;
                booleanRef.element = true;
                if (booleanRef2.element && booleanRef3.element) {
                    callBack.invoke(bitmap, objectRef2.element, objectRef3.element);
                }
            }
        });
        b(bannerBgUrl, new Function1<Bitmap, Unit>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieGuideUtil$preloadRobotGuideBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                objectRef2.element = bitmap;
                booleanRef2.element = true;
                if (booleanRef.element && booleanRef3.element) {
                    callBack.invoke(objectRef.element, bitmap, objectRef3.element);
                }
            }
        });
        b(robotUrl, new Function1<Bitmap, Unit>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieGuideUtil$preloadRobotGuideBg$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                objectRef3.element = bitmap;
                booleanRef3.element = true;
                if (booleanRef.element && booleanRef2.element) {
                    callBack.invoke(objectRef.element, objectRef2.element, bitmap);
                }
            }
        });
    }
}
