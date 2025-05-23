package com.tencent.av.business.manager.pendant;

/* loaded from: classes3.dex */
public class PendantItem extends c {
    public static final int CATEGORY_BEAUTY_MAKEUP = 3;
    public static final int CATEGORY_FACE = 0;
    public static final int CATEGORY_FACE_AND_GESTURE = 2;
    public static final int CATEGORY_GESTURE = 1;
    public static final int ZPLAN_RENDER_TYPE_FILAMENT = 1;
    public static final int ZPLAN_RENDER_TYPE_UE = 0;
    private int category;
    private String categoryId;
    private String categoryName;
    private String currentLowestSupportLevel;
    private String desc;
    private String deviceBlackList;
    private String filtername;
    private String gestureType;
    private String gestureWording;
    private String iconurl;

    /* renamed from: id, reason: collision with root package name */
    private String f73404id;
    private int kind;
    private String md5;
    private int platform;
    private boolean predownload;
    private String resurl;
    private int type;
    private boolean usable;
    private String version;
    private String name = "";
    private boolean isshow = true;
    private int voiceid = 0;
    public boolean needHMirror = false;
    private boolean isZplan = false;
    private int zplanRenderType = 0;
    public Object extraParam = null;
    private a additionalPackage = null;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f73405a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f73406b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f73407c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f73408d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f73409e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f73410f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f73411g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f73412h = "";
    }

    public static boolean isBeautyMakeup(int i3) {
        if (i3 == 3) {
            return true;
        }
        return false;
    }

    public static boolean isFace(int i3) {
        if (i3 != 2 && i3 != 0) {
            return false;
        }
        return true;
    }

    public static boolean isGesture(int i3) {
        if (i3 == 2 || i3 == 1) {
            return true;
        }
        return false;
    }

    public static boolean isOnlySupportOldFilter(int i3) {
        if (22 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isPanorama(int i3) {
        if (7 == i3) {
            return true;
        }
        return false;
    }

    public a getAdditionalPackage() {
        return this.additionalPackage;
    }

    public int getCategory() {
        return this.category;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getCurrentLowestSupportLevel() {
        return this.currentLowestSupportLevel;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getDesc() {
        return this.desc;
    }

    public String getDeviceBlackList() {
        return this.deviceBlackList;
    }

    public String getFilterName() {
        return this.filtername;
    }

    public String getGestureType() {
        return this.gestureType;
    }

    public String getGestureWording() {
        return this.gestureWording;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getIconUrl() {
        return this.iconurl;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getId() {
        return this.f73404id;
    }

    public int getKind() {
        return this.kind;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getMd5() {
        return this.md5;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public int getPlatform() {
        return this.platform;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getResUrl() {
        return this.resurl;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getVersion() {
        return this.version;
    }

    public int getVoiceId() {
        return this.voiceid;
    }

    public int getZplanRenderType() {
        return this.zplanRenderType;
    }

    public boolean hasFace() {
        return isFace(this.category);
    }

    public boolean hasGesture() {
        return isGesture(this.category);
    }

    public boolean isShow() {
        return this.isshow;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public boolean isUsable() {
        return this.usable;
    }

    public boolean isZplan() {
        return this.isZplan;
    }

    public void setAdditionalPackage(a aVar) {
        this.additionalPackage = aVar;
    }

    public void setCategory(int i3) {
        this.category = i3;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCurrentLowestSupportLevel(String str) {
        this.currentLowestSupportLevel = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDeviceBlackList(String str) {
        this.deviceBlackList = str;
    }

    public void setFiltername(String str) {
        this.filtername = str;
    }

    public void setGestureType(String str) {
        this.gestureType = str;
    }

    public void setGestureWording(String str) {
        this.gestureWording = str;
    }

    public void setIconurl(String str) {
        this.iconurl = str;
    }

    public void setId(String str) {
        this.f73404id = str;
    }

    public void setIsZplan(boolean z16) {
        this.isZplan = z16;
    }

    public void setIsshow(boolean z16) {
        this.isshow = z16;
    }

    public void setKind(int i3) {
        this.kind = i3;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPlatform(int i3) {
        this.platform = i3;
    }

    public void setPredownload(boolean z16) {
        this.predownload = z16;
    }

    public void setResurl(String str) {
        this.resurl = str;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public void setUsable(boolean z16) {
        this.usable = z16;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setZplanRenderType(int i3) {
        this.zplanRenderType = i3;
    }

    public String toString() {
        return "id[" + this.f73404id + "], name[" + this.name + "], type[" + this.type + "], category[" + this.category + "], categoryName[" + this.categoryName + "], gestureType[" + this.gestureType + "], kind[" + this.kind + "], isDownloading[" + this.isDownloading + "], extraParam[" + this.extraParam + "]";
    }
}
