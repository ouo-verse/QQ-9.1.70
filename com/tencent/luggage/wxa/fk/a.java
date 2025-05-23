package com.tencent.luggage.wxa.fk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.gk.a;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6220a f126195a = new C6220a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f126196b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6220a {
        public C6220a() {
        }

        public /* synthetic */ C6220a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f126204b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f126205c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1 f126206d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity, b bVar, Function1 function1) {
            super(1);
            this.f126204b = activity;
            this.f126205c = bVar;
            this.f126206d = function1;
        }

        public final void a(boolean z16) {
            com.tencent.luggage.wxa.fk.c cVar;
            a.this.a(this.f126204b, this.f126205c.c(), z16);
            Function1 function1 = this.f126206d;
            if (function1 != null) {
                if (z16) {
                    cVar = com.tencent.luggage.wxa.fk.c.SUCCESS;
                } else {
                    cVar = com.tencent.luggage.wxa.fk.c.LAUNCH_PHASE_FAIL;
                }
                function1.invoke(cVar);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f126207a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f126208b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f126209c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f126210d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f126211e;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fk.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6222a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Activity f126212a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.gk.b f126213b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0 f126214c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f126215d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Activity f126216e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ String f126217f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Function1 f126218g;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.fk.a$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class DialogInterfaceOnClickListenerC6223a implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Function0 f126219a;

                public DialogInterfaceOnClickListenerC6223a(Function0 function0) {
                    this.f126219a = function0;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    this.f126219a.invoke();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.fk.a$d$a$b */
            /* loaded from: classes8.dex */
            public static final class b implements DialogInterface.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f126220a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Activity f126221b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f126222c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ Function1 f126223d;

                public b(a aVar, Activity activity, String str, Function1 function1) {
                    this.f126220a = aVar;
                    this.f126221b = activity;
                    this.f126222c = str;
                    this.f126223d = function1;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    this.f126220a.c(this.f126221b, this.f126222c);
                    Function1 function1 = this.f126223d;
                    if (function1 != null) {
                        function1.invoke(com.tencent.luggage.wxa.fk.c.USER_CANCEL);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6222a(Activity activity, com.tencent.luggage.wxa.gk.b bVar, Function0 function0, a aVar, Activity activity2, String str, Function1 function1) {
                super(0);
                this.f126212a = activity;
                this.f126213b = bVar;
                this.f126214c = function0;
                this.f126215d = aVar;
                this.f126216e = activity2;
                this.f126217f = str;
                this.f126218g = function1;
            }

            public final void a() {
                MMAlertDialog.Builder builder = new MMAlertDialog.Builder(this.f126212a);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this.f126212a.getString(R.string.z1f);
                Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(R.string.a\u2026rt_link_launch_alert_mgs)");
                String format = String.format(string, Arrays.copyOf(new Object[]{this.f126213b.b()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                builder.setMsg(format);
                builder.setCancelable(false);
                builder.setPositiveBtnText(this.f126212a.getString(R.string.z1d));
                builder.setNegativeBtnText(this.f126212a.getString(R.string.z1e));
                builder.setPositiveBtnListener(new DialogInterfaceOnClickListenerC6223a(this.f126214c));
                builder.setNegativeBtnListener(new b(this.f126215d, this.f126216e, this.f126217f, this.f126218g));
                builder.create().show();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f126224a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f126225b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.gk.b f126226c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f126227d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Function1 f126228e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(a aVar, Activity activity, com.tencent.luggage.wxa.gk.b bVar, String str, Function1 function1) {
                super(0);
                this.f126224a = aVar;
                this.f126225b = activity;
                this.f126226c = bVar;
                this.f126227d = str;
                this.f126228e = function1;
            }

            public final void a() {
                this.f126224a.a(this.f126225b, new b(this.f126226c.a(), this.f126226c.c(), this.f126226c.d(), this.f126226c.e(), this.f126227d, null, 32, null), this.f126228e);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity, Function1 function1, a aVar, String str, boolean z16) {
            super(2);
            this.f126207a = activity;
            this.f126208b = function1;
            this.f126209c = aVar;
            this.f126210d = str;
            this.f126211e = z16;
        }

        public final void a(boolean z16, com.tencent.luggage.wxa.gk.b bVar) {
            boolean z17;
            Activity activity = (Activity) new WeakReference(this.f126207a).get();
            if (com.tencent.luggage.wxa.h6.d.b(activity)) {
                Function1 function1 = this.f126208b;
                if (function1 != null) {
                    function1.invoke(com.tencent.luggage.wxa.fk.c.CONTEXT_RELEASE);
                    return;
                }
                return;
            }
            if (z16 && com.tencent.luggage.wxa.h6.d.a(bVar)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!this.f126209c.a(activity, z17)) {
                Function1 function12 = this.f126208b;
                if (function12 != null) {
                    function12.invoke(com.tencent.luggage.wxa.fk.c.INTERRUPT);
                    return;
                }
                return;
            }
            if (!z17) {
                this.f126209c.a(activity, this.f126210d);
                Function1 function13 = this.f126208b;
                if (function13 != null) {
                    function13.invoke(com.tencent.luggage.wxa.fk.c.DECODE_LINK_FAIL);
                    return;
                }
                return;
            }
            Intrinsics.checkNotNull(bVar);
            this.f126209c.b();
            b bVar2 = new b(this.f126209c, activity, bVar, this.f126210d, this.f126208b);
            if (this.f126211e) {
                com.tencent.luggage.wxa.h6.d.a((Function0) new C6222a(this.f126207a, bVar, bVar2, this.f126209c, activity, this.f126210d, this.f126208b));
            } else {
                bVar2.invoke();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Boolean) obj).booleanValue(), (com.tencent.luggage.wxa.gk.b) obj2);
            return Unit.INSTANCE;
        }
    }

    static {
        Pattern compile = Pattern.compile("^mp://\\w+");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\"^$SHORT_LINK_SCHEME\\\\w+\")");
        f126196b = compile;
    }

    public abstract a.b a();

    public void a(Activity ctx, String url) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public abstract void a(Context context, b bVar, Function1 function1);

    public com.tencent.luggage.wxa.fk.b b() {
        return null;
    }

    public void c(Activity ctx, String url) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<b> CREATOR = new C6221a();

        /* renamed from: a, reason: collision with root package name */
        public final String f126197a;

        /* renamed from: b, reason: collision with root package name */
        public final String f126198b;

        /* renamed from: c, reason: collision with root package name */
        public final int f126199c;

        /* renamed from: d, reason: collision with root package name */
        public final int f126200d;

        /* renamed from: e, reason: collision with root package name */
        public final String f126201e;

        /* renamed from: f, reason: collision with root package name */
        public final String f126202f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fk.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6221a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new b(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(String appId, String path, int i3, int i16, String shortLink, String userName) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(shortLink, "shortLink");
            Intrinsics.checkNotNullParameter(userName, "userName");
            this.f126197a = appId;
            this.f126198b = path;
            this.f126199c = i3;
            this.f126200d = i16;
            this.f126201e = shortLink;
            this.f126202f = userName;
        }

        public final String a() {
            return this.f126197a;
        }

        public final String b() {
            return this.f126198b;
        }

        public final String c() {
            return this.f126201e;
        }

        public final int d() {
            return this.f126200d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(this.f126197a, bVar.f126197a) && Intrinsics.areEqual(this.f126198b, bVar.f126198b) && this.f126199c == bVar.f126199c && this.f126200d == bVar.f126200d && Intrinsics.areEqual(this.f126201e, bVar.f126201e) && Intrinsics.areEqual(this.f126202f, bVar.f126202f)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.f126197a.hashCode() * 31) + this.f126198b.hashCode()) * 31) + this.f126199c) * 31) + this.f126200d) * 31) + this.f126201e.hashCode()) * 31) + this.f126202f.hashCode();
        }

        public String toString() {
            return "WxaShortLinkLaunchParams(appId=" + this.f126197a + ", path=" + this.f126198b + ", version=" + this.f126199c + ", versionType=" + this.f126200d + ", shortLink=" + this.f126201e + ", userName=" + this.f126202f + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.f126197a);
            out.writeString(this.f126198b);
            out.writeInt(this.f126199c);
            out.writeInt(this.f126200d);
            out.writeString(this.f126201e);
            out.writeString(this.f126202f);
        }

        public /* synthetic */ b(String str, String str2, int i3, int i16, String str3, String str4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i3, i16, str3, (i17 & 32) != 0 ? "" : str4);
        }
    }

    public void a(Activity ctx, String url, boolean z16) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void b(Activity ctx, String url) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public boolean a(Activity ctx, boolean z16) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return true;
    }

    public final void a(Activity ctx, String link, boolean z16, Function1 function1) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(link, "link");
        d dVar = new d(ctx, function1, this, link, z16);
        b();
        if (f126196b.matcher(link).matches()) {
            new com.tencent.luggage.wxa.gk.a().a(link, a(), dVar);
            return;
        }
        b(ctx, link);
        if (function1 != null) {
            function1.invoke(com.tencent.luggage.wxa.fk.c.ILLEGAL_LINK);
        }
    }

    public final void a(Activity activity, b bVar, Function1 function1) {
        a((Context) activity, bVar, (Function1) new c(activity, bVar, function1));
    }
}
