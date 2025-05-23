package com.tencent.vas.update.wrapper;

import com.tencent.vas.update.module.impl.VasUpdateSystemImpl;
import sw4.a;
import sw4.b;
import sw4.c;
import sw4.d;
import sw4.e;
import sw4.f;
import sw4.g;
import sw4.h;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VasUpdateWrapper {
    private static a mCmdManager;
    private static b mCommonManager;
    private static c mDbManager;
    private static d mHttpDownloader;
    private static e mMMKVManager;
    private static f mReporter;
    private static g mVasLog;
    private static uw4.d mVasUpdateSystem;
    private static h mWrapper;

    public static a getCmdManager() {
        a aVar = mCmdManager;
        if (aVar != null) {
            return aVar;
        }
        a c16 = mWrapper.c();
        mCmdManager = c16;
        if (c16 == null) {
            mCmdManager = tw4.g.e().c();
        }
        return mCmdManager;
    }

    public static b getCommonManager() {
        b bVar = mCommonManager;
        if (bVar != null) {
            return bVar;
        }
        b a16 = mWrapper.a();
        mCommonManager = a16;
        if (a16 == null) {
            mCommonManager = tw4.g.e().a();
        }
        return mCommonManager;
    }

    public static c getDbManager() {
        c cVar = mDbManager;
        if (cVar != null) {
            return cVar;
        }
        c dbManager = mWrapper.getDbManager();
        mDbManager = dbManager;
        if (dbManager == null) {
            mDbManager = tw4.g.e().getDbManager();
        }
        return mDbManager;
    }

    public static d getHttpDownloader() {
        d dVar = mHttpDownloader;
        if (dVar != null) {
            return dVar;
        }
        d httpDownloader = mWrapper.getHttpDownloader();
        mHttpDownloader = httpDownloader;
        if (httpDownloader == null) {
            mHttpDownloader = tw4.g.e().getHttpDownloader();
        }
        return mHttpDownloader;
    }

    public static g getLog() {
        g gVar = mVasLog;
        if (gVar != null) {
            return gVar;
        }
        g d16 = mWrapper.d();
        mVasLog = d16;
        if (d16 == null) {
            mVasLog = tw4.g.e().d();
        }
        return mVasLog;
    }

    public static e getMMKVManager() {
        e eVar = mMMKVManager;
        if (eVar != null) {
            return eVar;
        }
        e b16 = mWrapper.b();
        mMMKVManager = b16;
        if (b16 == null) {
            mMMKVManager = tw4.g.e().b();
        }
        return mMMKVManager;
    }

    public static f getReportManager() {
        f fVar = mReporter;
        if (fVar != null) {
            return fVar;
        }
        f reportManager = mWrapper.getReportManager();
        mReporter = reportManager;
        if (reportManager == null) {
            mReporter = tw4.g.e().getReportManager();
        }
        return mReporter;
    }

    public static uw4.d getVasUpdateSystem() {
        if (mVasUpdateSystem == null) {
            mVasUpdateSystem = new VasUpdateSystemImpl();
        }
        return mVasUpdateSystem;
    }

    public static void setVasUpdateWrapper(h hVar) {
        if (hVar == null) {
            hVar = tw4.g.e();
        }
        mWrapper = hVar;
    }
}
