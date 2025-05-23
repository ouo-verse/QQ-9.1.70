package com.tencent.biz.qqcircle.publish.plusmenu.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudPubGuideSvr$ExpInfo;
import feedcloud.FeedCloudPubGuideSvr$PlusEntryGuideReq;
import feedcloud.FeedCloudPubGuideSvr$PlusEntryGuideRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB+\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J!\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusmenu/request/QFSPlusMenuGetReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "tabAppId", "Ljava/lang/String;", "getTabAppId", "()Ljava/lang/String;", "tabExpId", "getTabExpId", "", "pgId", "I", "getPgId", "()I", "lightSdkVersion", "getLightSdkVersion", "Lfeedcloud/FeedCloudPubGuideSvr$PlusEntryGuideReq;", "req", "Lfeedcloud/FeedCloudPubGuideSvr$PlusEntryGuideReq;", "getReq", "()Lfeedcloud/FeedCloudPubGuideSvr$PlusEntryGuideReq;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPlusMenuGetReq extends QCircleBaseRequest {

    @NotNull
    public static final String TAG = "QFSPlusMenuGetReq";

    @NotNull
    private final String lightSdkVersion;
    private final int pgId;

    @NotNull
    private final FeedCloudPubGuideSvr$PlusEntryGuideReq req;

    @NotNull
    private final String tabAppId;

    @NotNull
    private final String tabExpId;

    public /* synthetic */ QFSPlusMenuGetReq(String str, String str2, int i3, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, i3, str3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] responseData) {
        try {
            T t16 = (T) new FeedCloudPubGuideSvr$PlusEntryGuideRsp().mergeFrom(responseData);
            if (t16 == null) {
                return null;
            }
            return t16;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "decode, error", e16);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.pub_guide_svr.PubGuideSvr.PlusEntryGuide";
    }

    @NotNull
    public final String getLightSdkVersion() {
        return this.lightSdkVersion;
    }

    public final int getPgId() {
        return this.pgId;
    }

    @NotNull
    public final FeedCloudPubGuideSvr$PlusEntryGuideReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    @NotNull
    public final String getTabAppId() {
        return this.tabAppId;
    }

    @NotNull
    public final String getTabExpId() {
        return this.tabExpId;
    }

    public QFSPlusMenuGetReq(@NotNull String tabAppId, @NotNull String tabExpId, int i3, @NotNull String lightSdkVersion) {
        Intrinsics.checkNotNullParameter(tabAppId, "tabAppId");
        Intrinsics.checkNotNullParameter(tabExpId, "tabExpId");
        Intrinsics.checkNotNullParameter(lightSdkVersion, "lightSdkVersion");
        this.tabAppId = tabAppId;
        this.tabExpId = tabExpId;
        this.pgId = i3;
        this.lightSdkVersion = lightSdkVersion;
        FeedCloudPubGuideSvr$PlusEntryGuideReq feedCloudPubGuideSvr$PlusEntryGuideReq = new FeedCloudPubGuideSvr$PlusEntryGuideReq();
        FeedCloudPubGuideSvr$ExpInfo feedCloudPubGuideSvr$ExpInfo = feedCloudPubGuideSvr$PlusEntryGuideReq.exp;
        FeedCloudPubGuideSvr$ExpInfo feedCloudPubGuideSvr$ExpInfo2 = new FeedCloudPubGuideSvr$ExpInfo();
        feedCloudPubGuideSvr$ExpInfo2.app_id.set(tabAppId);
        feedCloudPubGuideSvr$ExpInfo2.exp_id.set(tabExpId);
        feedCloudPubGuideSvr$ExpInfo.set(feedCloudPubGuideSvr$ExpInfo2);
        feedCloudPubGuideSvr$PlusEntryGuideReq.page.set(i3);
        feedCloudPubGuideSvr$PlusEntryGuideReq.light_sdk_version.set(lightSdkVersion);
        this.req = feedCloudPubGuideSvr$PlusEntryGuideReq;
    }
}
