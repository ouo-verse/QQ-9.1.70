package com.tencent.weiyun.poi;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.WeiyunLiteGlobal;
import com.tencent.weiyun.utils.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes27.dex */
public final class PoiDbManager {
    static IPatchRedirector $redirector_ = null;
    public static final String COL_POI_ADDRESS = "address";
    public static final String COL_POI_CITY_ID = "city_id";
    public static final String COL_POI_CITY_NAME = "city_name";
    public static final String COL_POI_ID = "_id";
    public static final String COL_POI_LATITUDE = "latitude";
    public static final String COL_POI_LONGITUDE = "longitude";
    public static final String COL_POI_NATION_NAME = "nation_name";
    public static final String COL_POI_NATION_TYPE = "nation_type";
    public static final String COL_POI_POI_ID = "poi_id";
    public static final String COL_POI_POI_NAME = "poi_name";
    public static final String TBL_POI = "poi";
    private static Singleton<PoiDbManager, Void> sInstance;
    private final PoiDbHelper mPoiDbHelper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11088);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            sInstance = new Singleton<PoiDbManager, Void>() { // from class: com.tencent.weiyun.poi.PoiDbManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.weiyun.utils.Singleton
                public PoiDbManager create(Void r46) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new PoiDbManager(null) : (PoiDbManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
                }
            };
        }
    }

    /* synthetic */ PoiDbManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
    }

    public static PoiDbManager getInstance() {
        return sInstance.get(null);
    }

    public void closePoiDb(PoiDbWrapper poiDbWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) poiDbWrapper);
        } else if (poiDbWrapper != null) {
            this.mPoiDbHelper.closeDatabase(poiDbWrapper.database());
        }
    }

    public void dumpDb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mPoiDbHelper.dumpDb(WeiyunLiteGlobal.getInstance().getContext(), Environment.getExternalStorageDirectory());
    }

    public PoiDbWrapper openPoiDb(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PoiDbWrapper) iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
        SQLiteDatabase openDatabase = this.mPoiDbHelper.openDatabase(z16);
        if (openDatabase == null) {
            return null;
        }
        return new PoiDbWrapper(openDatabase);
    }

    PoiDbManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mPoiDbHelper = new PoiDbHelper(WeiyunLiteGlobal.getInstance().getContext());
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
