package com.tencent.mobileqq.qqexpand.chat.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J.\u0010\u0010\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u001a\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J6\u0010\u001c\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010 \u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/impl/ExpandChatUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/IExpandChatUtils;", "()V", "bNeedShowLimitChatInTitleEntrance", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "clearAllMatchChatLocalData", "", "getInstance", "Lcom/tencent/mobileqq/qqexpand/bean/chat/ExpandFriendData;", "matchUin", "", "getLastMatchChatGrayTipsSection", "", "getMatchAlgorithmId", "handlePreLoadDataForIcebreakerTopic", "uinType", "data", "", "isMiniProfileCard", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "markEnterAio", "needShowLimitChatOnPlus", "reportInSubThread", "setLastMatchChatGrayTipsSection", "section", "showIcebreakerTopic", "matchSrc", "extendObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "updateInstance", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ExpandChatUtilsImpl implements IExpandChatUtils {
    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public boolean bNeedShowLimitChatInTitleEntrance(BaseQQAppInterface app) {
        return ExpandChatUtil.d(app);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public void clearAllMatchChatLocalData(BaseQQAppInterface app) {
        ExpandChatUtil.i(app);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public ExpandFriendData getInstance(BaseQQAppInterface app, String matchUin) {
        return ExpandChatUtil.m(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public int getLastMatchChatGrayTipsSection(BaseQQAppInterface app, String matchUin) {
        return ExpandChatUtil.n(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public String getMatchAlgorithmId(BaseQQAppInterface app, String matchUin) {
        return ExpandChatUtil.q(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public void handlePreLoadDataForIcebreakerTopic(BaseQQAppInterface app, String matchUin, int uinType, Object data) {
        ExpandChatUtil.t(app, matchUin, uinType, data);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public boolean isMiniProfileCard(MessageRecord message) {
        return ExpandChatUtil.y(message);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public void markEnterAio(BaseQQAppInterface app, String matchUin) {
        ExpandChatUtil.A(app, matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public boolean needShowLimitChatOnPlus(BaseQQAppInterface app) {
        return ExpandChatUtil.C(app);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public void reportInSubThread(String matchUin) {
        ExpandChatUtil.E(matchUin);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public void setLastMatchChatGrayTipsSection(BaseQQAppInterface app, String matchUin, int section) {
        ExpandChatUtil.H(app, matchUin, section);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public void showIcebreakerTopic(BaseQQAppInterface app, String matchUin, int uinType, int matchSrc, BusinessObserver extendObserver) {
        ExpandChatUtil.J(app, matchUin, uinType, matchSrc, extendObserver);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
    public void updateInstance(BaseQQAppInterface app, ExpandFriendData data) {
        ExpandChatUtil.K(app, data);
    }
}
