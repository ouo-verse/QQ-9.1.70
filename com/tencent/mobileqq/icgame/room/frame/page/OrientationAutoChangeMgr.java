package com.tencent.mobileqq.icgame.room.frame.page;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.icgame.room.frame.page.OrientationAutoChangeMgr;
import com.tencent.mobileqq.icgame.room.frame.page.OrientationAutoChangeMgr$orientationEventListener$1;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0017\u0018\u0000 \u00032\u00020\u0001:\u0002\b\u000eB\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr;", "", "", "f", "", h.F, "i", "", "a", "J", "g", "()J", "roomId", "", "b", "I", "tempOrientation", "c", "currentOrientation", "d", "Z", "isActive", "Lkotlin/Lazy;", "com/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr$orientationEventListener$1$a", "e", "Lkotlin/Lazy;", "orientationEventListener", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr$b;", "callback", "<init>", "(Landroid/content/Context;JLcom/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr$b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class OrientationAutoChangeMgr {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int tempOrientation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int currentOrientation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<OrientationAutoChangeMgr$orientationEventListener$1.a> orientationEventListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr$b;", "", "", "orientation", "", DomainData.DOMAIN_NAME, "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void n(int orientation);
    }

    public OrientationAutoChangeMgr(@NotNull final Context context, long j3, @NotNull final b callback) {
        Lazy<OrientationAutoChangeMgr$orientationEventListener$1.a> lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.roomId = j3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<OrientationAutoChangeMgr$orientationEventListener$1.a>() { // from class: com.tencent.mobileqq.icgame.room.frame.page.OrientationAutoChangeMgr$orientationEventListener$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr$orientationEventListener$1$a", "Landroid/view/OrientationEventListener;", "", "orientation", "", "onOrientationChanged", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a extends OrientationEventListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Context f237594a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ OrientationAutoChangeMgr f237595b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ OrientationAutoChangeMgr.b f237596c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(Context context, OrientationAutoChangeMgr orientationAutoChangeMgr, OrientationAutoChangeMgr.b bVar) {
                    super(context, 3);
                    this.f237594a = context;
                    this.f237595b = orientationAutoChangeMgr;
                    this.f237596c = bVar;
                }

                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    boolean z16;
                    int i3;
                    int i16;
                    boolean z17;
                    int i17;
                    int i18;
                    int i19;
                    boolean z18;
                    boolean z19;
                    boolean z26;
                    if (orientation == -1) {
                        return;
                    }
                    boolean z27 = true;
                    if (330 <= orientation && orientation < 361) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        if (orientation >= 0 && orientation < 31) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18) {
                            if (60 <= orientation && orientation < 121) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (z19) {
                                this.f237595b.tempOrientation = 8;
                            } else {
                                if (150 <= orientation && orientation < 211) {
                                    z26 = true;
                                } else {
                                    z26 = false;
                                }
                                if (!z26) {
                                    if (240 > orientation || orientation >= 301) {
                                        z27 = false;
                                    }
                                    if (z27) {
                                        this.f237595b.tempOrientation = 0;
                                    }
                                }
                            }
                            i3 = this.f237595b.currentOrientation;
                            i16 = this.f237595b.tempOrientation;
                            if (i3 == i16 && vt0.a.a(this.f237594a)) {
                                z17 = this.f237595b.isActive;
                                if (z17) {
                                    OrientationAutoChangeMgr orientationAutoChangeMgr = this.f237595b;
                                    i17 = orientationAutoChangeMgr.tempOrientation;
                                    orientationAutoChangeMgr.currentOrientation = i17;
                                    a.Companion companion = rt0.a.INSTANCE;
                                    i18 = this.f237595b.currentOrientation;
                                    companion.j("ICGameAudience|ICGameOrientationAutoChangeMgr", "\u5207\u6362:" + i18 + ", roomId:" + this.f237595b.getRoomId() + ", hashCode:" + hashCode());
                                    OrientationAutoChangeMgr.b bVar = this.f237596c;
                                    i19 = this.f237595b.currentOrientation;
                                    bVar.n(i19);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    this.f237595b.tempOrientation = 1;
                    i3 = this.f237595b.currentOrientation;
                    i16 = this.f237595b.tempOrientation;
                    if (i3 == i16) {
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(context, this, callback);
            }
        });
        this.orientationEventListener = lazy;
    }

    public final boolean f() {
        return this.orientationEventListener.getValue().canDetectOrientation();
    }

    /* renamed from: g, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    public final void h() {
        rt0.a.INSTANCE.f("ICGameAudience|ICGameOrientationAutoChangeMgr", "startCheck, roomId:" + this.roomId + ", hashCode:" + hashCode());
        this.isActive = true;
        this.orientationEventListener.getValue().enable();
    }

    public final void i() {
        rt0.a.INSTANCE.f("ICGameAudience|ICGameOrientationAutoChangeMgr", "stopCheck, roomId:" + this.roomId + ", hashCode:" + hashCode());
        this.isActive = false;
        this.orientationEventListener.getValue().disable();
    }
}
