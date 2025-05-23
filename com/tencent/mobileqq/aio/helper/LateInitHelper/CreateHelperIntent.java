package com.tencent.mobileqq.aio.helper.LateInitHelper;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/LateInitHelper/CreateHelperIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "CreateHelperRealIntent", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/CreateHelperIntent$CreateHelperRealIntent;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public abstract class CreateHelperIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/LateInitHelper/CreateHelperIntent$CreateHelperRealIntent;", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/CreateHelperIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "helperID", "Lcom/tencent/mvi/base/route/MsgIntent;", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "c", "()Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/a;", "f", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/a;", "a", "()Lcom/tencent/mobileqq/aio/helper/LateInitHelper/a;", "callback", "<init>", "(ILcom/tencent/mvi/base/route/MsgIntent;Lcom/tencent/mobileqq/aio/helper/LateInitHelper/a;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class CreateHelperRealIntent extends CreateHelperIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int helperID;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgIntent msgIntent;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final a callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreateHelperRealIntent(int i3, @NotNull MsgIntent msgIntent, @Nullable a aVar) {
            super(null);
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), msgIntent, aVar);
                return;
            }
            this.helperID = i3;
            this.msgIntent = msgIntent;
            this.callback = aVar;
        }

        @Nullable
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.callback;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.helperID;
        }

        @NotNull
        public final MsgIntent c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MsgIntent) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.msgIntent;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateHelperRealIntent)) {
                return false;
            }
            CreateHelperRealIntent createHelperRealIntent = (CreateHelperRealIntent) other;
            if (this.helperID == createHelperRealIntent.helperID && Intrinsics.areEqual(this.msgIntent, createHelperRealIntent.msgIntent) && Intrinsics.areEqual(this.callback, createHelperRealIntent.callback)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent.CreateHelperRealIntent";
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            int hashCode2 = ((this.helperID * 31) + this.msgIntent.hashCode()) * 31;
            a aVar = this.callback;
            if (aVar == null) {
                hashCode = 0;
            } else {
                hashCode = aVar.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "CreateHelperRealIntent(helperID=" + this.helperID + ", msgIntent=" + this.msgIntent + ", callback=" + this.callback + ")";
        }

        public /* synthetic */ CreateHelperRealIntent(int i3, MsgIntent msgIntent, a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, msgIntent, (i16 & 4) != 0 ? null : aVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), msgIntent, aVar, Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    public /* synthetic */ CreateHelperIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    CreateHelperIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
