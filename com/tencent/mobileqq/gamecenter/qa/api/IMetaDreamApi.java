package com.tencent.mobileqq.gamecenter.qa.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.gamecenter.metadream.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\nH&J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0017\u001a\u00020\nH&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH&J\b\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001d\u001a\u00020\u001cH&J$\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001f` H&J\n\u0010#\u001a\u0004\u0018\u00010\"H&J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H&J\u0010\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0\u0002H&J \u0010.\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020$H&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/api/IMetaDreamApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "getMetaDreamFrameClass", "Lcom/tencent/mobileqq/app/FrameFragment;", "fragment", "newMetaDreamFrame", "", "setMainFragment", "", NodeProps.VISIBLE, "notifyTabChange", "isOn", "setTabOn", "isTabOn", "Lcom/tencent/mobileqq/app/be;", AIInput.KEY_FRAME, "isMetaDreamFrame", "Lcom/tencent/mobileqq/gamecenter/metadream/a;", "redpointInfo", "setTabRedpointInfo", "getTabRedpointInfo", "isMetaDreamFrameAlive", "isAlive", "setMetaDreamFrameAlive", "", "getMetaDreamBundleName", "Lorg/json/JSONObject;", "getHippyBusinessData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getPerformanceData", "Ljava/lang/Object;", "getSSRBundleRequester", "", "tabIndex", "openMsgList", "Lcom/tencent/mobileqq/app/parser/av;", "getJumpParserClass", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "requestCode", "openImageCropFragment", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IMetaDreamApi extends QRouteApi {
    @NotNull
    JSONObject getHippyBusinessData();

    @NotNull
    Class<? extends av> getJumpParserClass();

    @NotNull
    String getMetaDreamBundleName();

    @NotNull
    Class<? extends Frame> getMetaDreamFrameClass();

    @NotNull
    HashMap<String, Long> getPerformanceData();

    @Nullable
    Object getSSRBundleRequester();

    @Nullable
    a getTabRedpointInfo();

    boolean isMetaDreamFrame(@Nullable be frame);

    boolean isMetaDreamFrameAlive();

    boolean isTabOn();

    @NotNull
    Frame newMetaDreamFrame(@NotNull FrameFragment fragment);

    void notifyTabChange(boolean visible);

    void openImageCropFragment(@NotNull Activity activity, @NotNull Intent intent, int requestCode);

    void openMsgList(int tabIndex);

    void setMainFragment(@Nullable FrameFragment fragment);

    void setMetaDreamFrameAlive(boolean isAlive);

    void setTabOn(boolean isOn);

    void setTabRedpointInfo(@Nullable a redpointInfo);
}
