package com.tencent.mobileqq.guild.robot.components.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotAuthClassInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotAuthGetInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotAuthSetInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionRsp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotAuthorizeAddInfo implements Parcelable {
    public static final Parcelable.Creator<RobotAuthorizeAddInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private int f232081d;

    /* renamed from: e, reason: collision with root package name */
    private int f232082e;

    /* renamed from: f, reason: collision with root package name */
    private List<Permission> f232083f;

    /* renamed from: h, reason: collision with root package name */
    private List<ClassInfo> f232084h;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class Permission implements Parcelable {

        /* renamed from: d, reason: collision with root package name */
        private int f232087d;

        /* renamed from: e, reason: collision with root package name */
        private String f232088e;

        /* renamed from: f, reason: collision with root package name */
        private String f232089f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f232090h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f232091i;

        /* renamed from: m, reason: collision with root package name */
        private String f232092m;
        public static final Parcelable.Creator<Permission> CREATOR = new a();
        public static final Parcelable.Creator<ClassInfo> CLASS_INFO_CREATOR = new b();

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class a implements Parcelable.Creator<Permission> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Permission createFromParcel(Parcel parcel) {
                return new Permission(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Permission[] newArray(int i3) {
                return new Permission[i3];
            }
        }

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class b implements Parcelable.Creator<ClassInfo> {
            b() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ClassInfo createFromParcel(Parcel parcel) {
                return new ClassInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ClassInfo[] newArray(int i3) {
                return new ClassInfo[i3];
            }
        }

        public Permission() {
        }

        public static <C extends Collection<GProGuildRobotAuthSetInfo>> C a(C c16, Collection<Permission> collection) {
            for (Permission permission : collection) {
                c16.add(new GProGuildRobotAuthSetInfo(permission.c(), permission.f() ? 1 : 0));
            }
            return c16;
        }

        public static Permission b(GProGuildRobotAuthGetInfo gProGuildRobotAuthGetInfo) {
            boolean z16;
            Permission permission = new Permission();
            permission.f232087d = gProGuildRobotAuthGetInfo.getId();
            permission.f232088e = gProGuildRobotAuthGetInfo.getTitle();
            permission.f232089f = gProGuildRobotAuthGetInfo.getDesc();
            boolean z17 = false;
            if (gProGuildRobotAuthGetInfo.getNeedAdmin() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            permission.f232090h = z16;
            if (gProGuildRobotAuthGetInfo.getFlag() == 1) {
                z17 = true;
            }
            permission.f232091i = z17;
            permission.f232092m = gProGuildRobotAuthGetInfo.getClassName();
            return permission;
        }

        public int c() {
            return this.f232087d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f232092m;
        }

        public boolean f() {
            return this.f232091i;
        }

        public boolean g() {
            return this.f232090h;
        }

        public String getTitle() {
            return this.f232088e;
        }

        public void j(boolean z16) {
            this.f232091i = z16;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f232087d);
            parcel.writeString(this.f232088e);
            parcel.writeString(this.f232089f);
            parcel.writeByte(this.f232090h ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f232091i ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f232092m);
        }

        protected Permission(Parcel parcel) {
            this.f232087d = parcel.readInt();
            this.f232088e = parcel.readString();
            this.f232089f = parcel.readString();
            this.f232090h = parcel.readByte() != 0;
            this.f232091i = parcel.readByte() != 0;
            this.f232092m = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<RobotAuthorizeAddInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RobotAuthorizeAddInfo createFromParcel(Parcel parcel) {
            return new RobotAuthorizeAddInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RobotAuthorizeAddInfo[] newArray(int i3) {
            return new RobotAuthorizeAddInfo[i3];
        }
    }

    public RobotAuthorizeAddInfo() {
        this.f232083f = new ArrayList();
        this.f232084h = new ArrayList();
    }

    public static RobotAuthorizeAddInfo a(GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
        if (gProGuildRobotPermissionRsp == null) {
            return null;
        }
        RobotAuthorizeAddInfo robotAuthorizeAddInfo = new RobotAuthorizeAddInfo();
        robotAuthorizeAddInfo.f232081d = gProGuildRobotPermissionRsp.getRole();
        robotAuthorizeAddInfo.f232082e = gProGuildRobotPermissionRsp.getOperatorRole();
        Iterator<GProGuildRobotAuthGetInfo> it = gProGuildRobotPermissionRsp.getAuthGetInfos().iterator();
        while (it.hasNext()) {
            robotAuthorizeAddInfo.f232083f.add(Permission.b(it.next()));
        }
        for (GProGuildRobotAuthClassInfo gProGuildRobotAuthClassInfo : gProGuildRobotPermissionRsp.getClassInfos()) {
            robotAuthorizeAddInfo.f232084h.add(new ClassInfo(gProGuildRobotAuthClassInfo.getClassName(), gProGuildRobotAuthClassInfo.getOrder()));
        }
        return robotAuthorizeAddInfo;
    }

    public List<ClassInfo> b() {
        return this.f232084h;
    }

    public int c() {
        return this.f232082e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Permission> e() {
        return this.f232083f;
    }

    public int f() {
        return this.f232081d;
    }

    public void g(int i3) {
        this.f232081d = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f232081d);
        parcel.writeInt(this.f232082e);
        parcel.writeTypedList(this.f232083f);
        parcel.writeTypedList(this.f232084h);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class ClassInfo implements Parcelable {
        public static final Parcelable.Creator<ClassInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private String f232085d;

        /* renamed from: e, reason: collision with root package name */
        private int f232086e;

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class a implements Parcelable.Creator<ClassInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ClassInfo createFromParcel(Parcel parcel) {
                return new ClassInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ClassInfo[] newArray(int i3) {
                return new ClassInfo[i3];
            }
        }

        public ClassInfo(String str, int i3) {
            this.f232085d = str;
            this.f232086e = i3;
        }

        public String a() {
            return this.f232085d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getOrder() {
            return this.f232086e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f232085d);
            parcel.writeInt(this.f232086e);
        }

        protected ClassInfo(Parcel parcel) {
            this.f232085d = parcel.readString();
            this.f232086e = parcel.readInt();
        }
    }

    protected RobotAuthorizeAddInfo(Parcel parcel) {
        this.f232081d = parcel.readInt();
        this.f232082e = parcel.readInt();
        this.f232083f = parcel.createTypedArrayList(Permission.CREATOR);
        this.f232084h = parcel.createTypedArrayList(Permission.CLASS_INFO_CREATOR);
    }
}
