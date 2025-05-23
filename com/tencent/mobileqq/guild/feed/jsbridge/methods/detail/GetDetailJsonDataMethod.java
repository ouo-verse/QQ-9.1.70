package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GetDetailJsonDataMethod extends c {

    /* renamed from: h, reason: collision with root package name */
    public static String f219989h = "feedId";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    public static class Result {
        public static final int RET_ERROR = -1;
        public static final int RET_SUCCESS = 0;

        @SerializedName("feedJson")
        public String mFeedJson;

        @SerializedName("ret")
        public int mRet;

        public Result(String str, int i3) {
            this.mFeedJson = str;
            this.mRet = i3;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    private void p() {
        GuildFeedDetailInitBean initBean;
        lj1.a l3 = l();
        if (l3 == null || (initBean = l3.getInitBean()) == null) {
            return;
        }
        final String feedId = initBean.getFeedId();
        if (!TextUtils.equals(feedId, g(f219989h))) {
            return;
        }
        String q16 = GuildFeedDetailDataCacheManager.y().q(feedId, initBean.getLastModifiedTime());
        if (!TextUtils.isEmpty(q16)) {
            i(new Result(q16, 0).toJson());
            QLog.d("GetDetailJsonDataMethod", 1, "callbackDetailData FeedWebBundle== use current feed cache: " + feedId);
            GuildFeedReportHelper.i().n(true);
            return;
        }
        GuildFeedReportHelper.i().n(false);
        QLog.d("GetDetailJsonDataMethod", 1, "callbackDetailData wait from FeedCacheCallback! " + feedId);
        l3.setFeedCacheCallback(new GuildFeedDetailWebViewFragment.g() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.GetDetailJsonDataMethod.1
            @Override // com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment.g
            public void onResult(final String str) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.GetDetailJsonDataMethod.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!TextUtils.isEmpty(str)) {
                            QLog.d("GetDetailJsonDataMethod", 1, "callbackDetailData from FeedCacheCallback! " + feedId);
                            GetDetailJsonDataMethod.this.i(new Result(str, 0).toJson());
                            GuildFeedReportHelper.i().n(true);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "getDetailJsonData";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        if (!GuildFeedDetailDataCacheManager.y().m()) {
            return false;
        }
        p();
        return true;
    }
}
