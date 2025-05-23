package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.activity.QQGuildAIOSingleTaskTransActivity;
import com.tencent.mobileqq.guild.temp.api.IGuildArticleMsgApi;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildArticleMsgApiImpl implements IGuildArticleMsgApi {
    private boolean checkArticleDetailShowing(String str) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildArticleMsgApi
    public boolean judgeActivityIsArticleMsgDetailFragment(Object obj) {
        return (obj instanceof QQGuildAIOSingleTaskTransActivity) && judgeFragmentIsArticleMsgDetailFragment(((QQGuildAIOSingleTaskTransActivity) obj).getFragment());
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildArticleMsgApi
    public boolean judgeFragmentIsArticleMsgDetailFragment(Object obj) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildArticleMsgApi
    public MessageRecord queryArticleMsgItemByShmsgseq(String str, String str2, long j3) {
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildArticleMsgApi
    public void notifyRefreshArticleChatPie(String str, String str2) {
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildArticleMsgApi
    public void notifyArticleMessageListUpdate(String str, String str2, List<MessageRecord> list, boolean z16) {
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildArticleMsgApi
    public void updateArticleMessage(String str, String str2, MessageRecord messageRecord, boolean z16) {
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildArticleMsgApi
    public void notifyArticleMessageRevoke(String str, String str2, long j3) {
    }
}
