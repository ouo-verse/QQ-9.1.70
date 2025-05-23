package com.tencent.mobileqq.selectfriend.api;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectfriend.model.a;
import com.tencent.mobileqq.selectfriend.processor.d;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J.\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u001c\u0010\u0018\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0019\u001a\u00020\u0002H&J\u001c\u0010\u001d\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u001aH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/IContentProcessorApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "forwardContentType", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/selectfriend/processor/d;", "getForwardContentProcessor", "", "toUin", "uinType", "toUinType", "guildId", "", "saveForwardRecord", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/selectfriend/model/a;", "dialogData", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "getForwardDefaultDialog", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", "sendMessage", "getForwardId", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getForwardNodeAdapter", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IContentProcessorApi extends QRouteApi {
    @NotNull
    Class<? extends d> getForwardContentProcessor(int forwardContentType);

    @Nullable
    QQCustomDialog getForwardDefaultDialog(@NotNull Activity activity, @Nullable a dialogData);

    int getForwardId();

    @Nullable
    List<RecyclerView.Adapter<?>> getForwardNodeAdapter(@NotNull QPublicFragmentActivity activity);

    void saveForwardRecord(@Nullable String toUin, @Nullable String uinType, int toUinType, @Nullable String guildId);

    void sendMessage(@Nullable Bundle bundle, @Nullable ResultRecord resultRecord);
}
