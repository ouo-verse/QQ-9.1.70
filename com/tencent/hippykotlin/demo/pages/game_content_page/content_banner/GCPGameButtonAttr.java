package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GamePrivilegeInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.kuikly.core.base.k;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPGameButtonAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "packName", "getPackName()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "appStoreUrl", "getAppStoreUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "androidDownloadUrl", "getAndroidDownloadUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "buttonText", "getButtonText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "buttonTextColor", "getButtonTextColor()J", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "buttonColor", "getButtonColor()J", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "status", "getStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "subscribeStatus", "getSubscribeStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "followStatus", "getFollowStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "taskStatus", "getTaskStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "buttonProgress", "getButtonProgress()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "subscribeSucUrl", "getSubscribeSucUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, "gameName", "getGameName()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameButtonAttr.class, VasWebviewConstants.KEY_ADTAG, "getAdTag()Ljava/lang/String;", 0)};
    public boolean buttonFixedWidth;
    public String channelId;
    public String detailUrl;
    public int downloadProgress;
    public String gameId;
    public GameTab gameTab;
    public boolean isDarkStyle;
    public String pkgSize;
    public GamePrivilegeInfo privilege;
    public final ReadWriteProperty packName$delegate = c.a("");
    public final ReadWriteProperty appStoreUrl$delegate = c.a("");
    public final ReadWriteProperty androidDownloadUrl$delegate = c.a("");
    public float buttonFontSize = 14.0f;
    public final ReadWriteProperty buttonText$delegate = c.a("\u9884\u7ea6");
    public final ReadWriteProperty buttonTextColor$delegate = c.a(4294967295L);
    public final ReadWriteProperty buttonColor$delegate = c.a(4278229503L);
    public final ReadWriteProperty status$delegate = c.a(3);
    public final ReadWriteProperty subscribeStatus$delegate = c.a(1);
    public final ReadWriteProperty followStatus$delegate = c.a(1);
    public final ReadWriteProperty taskStatus$delegate = c.a(0);
    public final ReadWriteProperty buttonProgress$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty subscribeSucUrl$delegate = c.a("");
    public int scene = 1;
    public final ReadWriteProperty gameName$delegate = c.a("");
    public final ReadWriteProperty adTag$delegate = c.a("xiaoshijie_gametab");

    public final String getAppStoreUrl() {
        return (String) this.appStoreUrl$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final float getButtonProgress() {
        return ((Number) this.buttonProgress$delegate.getValue(this, $$delegatedProperties[10])).floatValue();
    }

    public final String getChannelId() {
        String str = this.channelId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channelId");
        return null;
    }

    public final int getFollowStatus() {
        return ((Number) this.followStatus$delegate.getValue(this, $$delegatedProperties[8])).intValue();
    }

    public final String getGameId() {
        String str = this.gameId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(VirtualAppProxy.KEY_GAME_ID);
        return null;
    }

    public final String getGameName() {
        return (String) this.gameName$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final String getPackName() {
        return (String) this.packName$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final int getStatus() {
        return ((Number) this.status$delegate.getValue(this, $$delegatedProperties[6])).intValue();
    }

    public final int getSubscribeStatus() {
        return ((Number) this.subscribeStatus$delegate.getValue(this, $$delegatedProperties[7])).intValue();
    }

    public final int getTaskStatus() {
        return ((Number) this.taskStatus$delegate.getValue(this, $$delegatedProperties[9])).intValue();
    }

    public final void setButtonColor(long j3) {
        this.buttonColor$delegate.setValue(this, $$delegatedProperties[5], Long.valueOf(j3));
    }

    public final void setStatus(int i3) {
        this.status$delegate.setValue(this, $$delegatedProperties[6], Integer.valueOf(i3));
    }

    public final void setTaskStatus(int i3) {
        this.taskStatus$delegate.setValue(this, $$delegatedProperties[9], Integer.valueOf(i3));
    }
}
