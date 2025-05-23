package com.tencent.sonic.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicDBHelper extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_ = null;
    private static final int SONIC_DATABASE_FIRST_VERSION = 1;
    private static final String SONIC_DATABASE_NAME = "sonic.db";
    private static final int SONIC_DATABASE_VERSION = 3;
    private static final String TAG = "SonicSdk_SonicDBHelper";
    private static AtomicBoolean isDBUpgrading;
    private static SonicDBHelper sInstance;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            sInstance = null;
            isDBUpgrading = new AtomicBoolean(false);
        }
    }

    SonicDBHelper(Context context) {
        super(context, SONIC_DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized SonicDBHelper createInstance(Context context) {
        SonicDBHelper sonicDBHelper;
        synchronized (SonicDBHelper.class) {
            if (sInstance == null) {
                sInstance = new SonicDBHelper(context);
            }
            sonicDBHelper = sInstance;
        }
        return sonicDBHelper;
    }

    private void doUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
        } else {
            upgradeToVersion_2(sQLiteDatabase);
        }
        upgradeToVersion_3(sQLiteDatabase);
    }

    public static synchronized SonicDBHelper getInstance() {
        SonicDBHelper sonicDBHelper;
        synchronized (SonicDBHelper.class) {
            sonicDBHelper = sInstance;
            if (sonicDBHelper == null) {
                throw new IllegalStateException("SonicDBHelper::createInstance() needs to be called before SonicDBHelper::getInstance()!");
            }
        }
        return sonicDBHelper;
    }

    private void upgradeToVersion_2(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SonicResourceDataHelper.CREATE_TABLE_SQL);
    }

    private void upgradeToVersion_3(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SonicChunkDataHelper.CREATE_TABLE_SQL);
    }

    public boolean isUpgrading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return isDBUpgrading.get();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
            return;
        }
        sQLiteDatabase.execSQL(SonicDataHelper.CREATE_TABLE_SQL);
        sQLiteDatabase.execSQL(SonicChunkDataHelper.CREATE_TABLE_SQL);
        onUpgrade(sQLiteDatabase, -1, 3);
        doUpgrade(sQLiteDatabase, 1, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (isDBUpgrading.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            SonicUtils.log(TAG, 4, "onUpgrade start, from " + i3 + " to " + i16 + ".");
            if (-1 == i3) {
                SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable() { // from class: com.tencent.sonic.sdk.SonicDBHelper.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SonicDBHelper.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            SonicUtils.removeAllSessionCache();
                            SonicDBHelper.isDBUpgrading.set(false);
                        }
                    }
                }, 0L);
            } else {
                doUpgrade(sQLiteDatabase, i3, i16);
                isDBUpgrading.set(false);
            }
            SonicUtils.log(TAG, 4, "onUpgrade finish, cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
    }
}
