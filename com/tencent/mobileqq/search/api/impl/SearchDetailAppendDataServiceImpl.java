package com.tencent.mobileqq.search.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.search.api.ISearchDetailAppendDataService;
import com.tencent.mobileqq.search.util.ah;
import com.tencent.qphone.base.util.QLog;
import kotlin.C11734b;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/SearchDetailAppendDataServiceImpl;", "Lcom/tencent/mobileqq/search/api/ISearchDetailAppendDataService;", "", "intervalTime", "", "setAppendIntervalTime", "", "reqTimeMillSeconds", "setLatestAppendTime", "", "canReqAppendData", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "appendIntervalTime", "I", "lastReqAppendTime", "J", "<init>", "()V", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDetailAppendDataServiceImpl implements ISearchDetailAppendDataService {

    @NotNull
    public static final String MMKV_KEY_APPEND_INTERVAL_TIME = "MMKV_KEY_APPEND_INTERVAL_TIME";

    @NotNull
    public static final String MMKV_KEY_LAST_APPEND_REQ_TIME = "MMKV_KEY_LAST_APPEND_REQ_TIME";

    @NotNull
    public static final String TAG = "QQSearch.NetDetail.SearchDetailAppendDataServiceImpl";
    private int appendIntervalTime;
    private long lastReqAppendTime;

    @Override // com.tencent.mobileqq.search.api.ISearchDetailAppendDataService
    public boolean canReqAppendData() {
        if (System.currentTimeMillis() - this.lastReqAppendTime > this.appendIntervalTime * 1000) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        ah ahVar = ah.f284994a;
        this.appendIntervalTime = ahVar.d(MMKV_KEY_APPEND_INTERVAL_TIME, 0);
        this.lastReqAppendTime = ahVar.e(MMKV_KEY_LAST_APPEND_REQ_TIME, 0L);
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + TAG, 1, "onCreate appendIntervalTime=" + this.appendIntervalTime + " lastReqAppendTime=" + this.lastReqAppendTime, null);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.appendIntervalTime = 0;
        this.lastReqAppendTime = 0L;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDetailAppendDataService
    public void setAppendIntervalTime(int intervalTime) {
        this.appendIntervalTime = intervalTime;
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + TAG, 1, "setAppendIntervalTime appendIntervalTime=" + intervalTime, null);
        ah.f284994a.m(MMKV_KEY_APPEND_INTERVAL_TIME, this.appendIntervalTime);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDetailAppendDataService
    public void setLatestAppendTime(long reqTimeMillSeconds) {
        this.lastReqAppendTime = reqTimeMillSeconds;
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + TAG, 1, "setLatestAppendTime " + reqTimeMillSeconds, null);
        ah.f284994a.o(MMKV_KEY_LAST_APPEND_REQ_TIME, reqTimeMillSeconds);
    }
}
