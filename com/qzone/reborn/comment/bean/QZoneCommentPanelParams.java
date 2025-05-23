package com.qzone.reborn.comment.bean;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedpro.utils.d;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\bP\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001qB\u0007\u00a2\u0006\u0004\bp\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001b\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\"\u00102\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0013\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R\"\u00104\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0013\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\b\"\u0004\b9\u0010\nR\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0006\u001a\u0004\b;\u0010\b\"\u0004\b<\u0010\nR\"\u0010=\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u0013\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016R\"\u0010@\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u0013\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R\"\u0010C\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u0013\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016R\"\u0010F\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u0013\u001a\u0004\bG\u0010\u0014\"\u0004\bH\u0010\u0016R\"\u0010I\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\u0013\u001a\u0004\bJ\u0010\u0014\"\u0004\bK\u0010\u0016R\"\u0010L\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0013\u001a\u0004\bM\u0010\u0014\"\u0004\bN\u0010\u0016R(\u0010O\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\bO\u0010\u0006\u0012\u0004\bR\u0010S\u001a\u0004\bP\u0010\b\"\u0004\bQ\u0010\nR\"\u0010T\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010\u0013\u001a\u0004\bT\u0010\u0014\"\u0004\bU\u0010\u0016R\"\u0010V\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010\u0013\u001a\u0004\bW\u0010\u0014\"\u0004\bX\u0010\u0016R\"\u0010Y\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010\u0013\u001a\u0004\bZ\u0010\u0014\"\u0004\b[\u0010\u0016R\"\u0010\\\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010\u0006\u001a\u0004\b]\u0010\b\"\u0004\b^\u0010\nR\"\u0010_\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010\u001b\u001a\u0004\b`\u0010\u001d\"\u0004\ba\u0010\u001fR$\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u00a8\u0006r"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "Ljava/io/Serializable;", "", "toString", "", "refer", "I", "getRefer", "()I", "setRefer", "(I)V", "requestCode", "getRequestCode", "setRequestCode", "position", "getPosition", "setPosition", "", "isAllowEmpty", "Z", "()Z", "setAllowEmpty", "(Z)V", "maxInputLength", "getMaxInputLength", "setMaxInputLength", "hintText", "Ljava/lang/String;", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "autoFillText", "getAutoFillText", "setAutoFillText", "feedsId", "getFeedsId", "setFeedsId", "cacheFeedsKey", "getCacheFeedsKey", "setCacheFeedsKey", "autoSaveUgcKey", "getAutoSaveUgcKey", "setAutoSaveUgcKey", "cacheUniKey", "getCacheUniKey", "setCacheUniKey", "aiCommentKey", "getAiCommentKey", "setAiCommentKey", "isShare", "setShare", "showSharePanel", "getShowSharePanel", "setShowSharePanel", "showQuickComment", "getShowQuickComment", "setShowQuickComment", "showPrivateComment", "getShowPrivateComment", "setShowPrivateComment", "enableEmo", "getEnableEmo", "setEnableEmo", "enableEmoRapidComment", "getEnableEmoRapidComment", "setEnableEmoRapidComment", "enablePicComment", "getEnablePicComment", "setEnablePicComment", "enableAt", "getEnableAt", "setEnableAt", "enableFont", "getEnableFont", "setEnableFont", "enableBarrageEffect", "getEnableBarrageEffect", "setEnableBarrageEffect", "quiThemeMode", "getQuiThemeMode", "setQuiThemeMode", "getQuiThemeMode$annotations", "()V", "isFromDIY", "setFromDIY", "enableSuperFont", "getEnableSuperFont", "setEnableSuperFont", "needShowFavoritesEmo", "getNeedShowFavoritesEmo", "setNeedShowFavoritesEmo", "selectFontId", "getSelectFontId", "setSelectFontId", "fromDtPageId", "getFromDtPageId", "setFromDtPageId", "Lcom/qzone/reborn/comment/bean/CommentReplyParam;", "commentReplyParam", "Lcom/qzone/reborn/comment/bean/CommentReplyParam;", "getCommentReplyParam", "()Lcom/qzone/reborn/comment/bean/CommentReplyParam;", "setCommentReplyParam", "(Lcom/qzone/reborn/comment/bean/CommentReplyParam;)V", "Lcom/qzone/reborn/comment/bean/GroupCommentParam;", "groupCommentParam", "Lcom/qzone/reborn/comment/bean/GroupCommentParam;", "getGroupCommentParam", "()Lcom/qzone/reborn/comment/bean/GroupCommentParam;", "setGroupCommentParam", "(Lcom/qzone/reborn/comment/bean/GroupCommentParam;)V", "<init>", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentPanelParams implements Serializable {
    private CommentReplyParam commentReplyParam;
    private boolean enableBarrageEffect;
    private boolean enableEmoRapidComment;
    private boolean enableFont;
    private boolean enablePicComment;
    private GroupCommentParam groupCommentParam;
    private boolean isAllowEmpty;
    private boolean isFromDIY;
    private boolean isShare;
    private boolean needShowFavoritesEmo;
    private int position;
    private int refer;
    private int selectFontId;
    private int showQuickComment;
    private boolean showSharePanel;
    private int requestCode = -1;
    private int maxInputLength = 600;
    private String hintText = "";
    private String autoFillText = "";
    private String feedsId = "";
    private String cacheFeedsKey = "";
    private String autoSaveUgcKey = "";
    private String cacheUniKey = "";
    private String aiCommentKey = "";
    private int showPrivateComment = -1;
    private boolean enableEmo = true;
    private boolean enableAt = true;
    private int quiThemeMode = 1000;
    private boolean enableSuperFont = true;
    private String fromDtPageId = "";

    public final String getAiCommentKey() {
        return this.aiCommentKey;
    }

    public final String getAutoFillText() {
        return this.autoFillText;
    }

    public final String getAutoSaveUgcKey() {
        return this.autoSaveUgcKey;
    }

    public final String getCacheFeedsKey() {
        return this.cacheFeedsKey;
    }

    public final String getCacheUniKey() {
        return this.cacheUniKey;
    }

    public final CommentReplyParam getCommentReplyParam() {
        return this.commentReplyParam;
    }

    public final boolean getEnableAt() {
        return this.enableAt;
    }

    public final boolean getEnableBarrageEffect() {
        return this.enableBarrageEffect;
    }

    public final boolean getEnableEmo() {
        return this.enableEmo;
    }

    public final boolean getEnableEmoRapidComment() {
        return this.enableEmoRapidComment;
    }

    public final boolean getEnableFont() {
        return this.enableFont;
    }

    public final boolean getEnablePicComment() {
        return this.enablePicComment;
    }

    public final boolean getEnableSuperFont() {
        return this.enableSuperFont;
    }

    public final String getFeedsId() {
        return this.feedsId;
    }

    public final String getFromDtPageId() {
        return this.fromDtPageId;
    }

    public final GroupCommentParam getGroupCommentParam() {
        return this.groupCommentParam;
    }

    public final String getHintText() {
        return this.hintText;
    }

    public final int getMaxInputLength() {
        return this.maxInputLength;
    }

    public final boolean getNeedShowFavoritesEmo() {
        return this.needShowFavoritesEmo;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getQuiThemeMode() {
        return this.quiThemeMode;
    }

    public final int getRefer() {
        return this.refer;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final int getSelectFontId() {
        return this.selectFontId;
    }

    public final int getShowPrivateComment() {
        return this.showPrivateComment;
    }

    public final int getShowQuickComment() {
        return this.showQuickComment;
    }

    public final boolean getShowSharePanel() {
        return this.showSharePanel;
    }

    /* renamed from: isAllowEmpty, reason: from getter */
    public final boolean getIsAllowEmpty() {
        return this.isAllowEmpty;
    }

    /* renamed from: isFromDIY, reason: from getter */
    public final boolean getIsFromDIY() {
        return this.isFromDIY;
    }

    /* renamed from: isShare, reason: from getter */
    public final boolean getIsShare() {
        return this.isShare;
    }

    public final void setAiCommentKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aiCommentKey = str;
    }

    public final void setAllowEmpty(boolean z16) {
        this.isAllowEmpty = z16;
    }

    public final void setAutoFillText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.autoFillText = str;
    }

    public final void setAutoSaveUgcKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.autoSaveUgcKey = str;
    }

    public final void setCacheFeedsKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cacheFeedsKey = str;
    }

    public final void setCacheUniKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cacheUniKey = str;
    }

    public final void setCommentReplyParam(CommentReplyParam commentReplyParam) {
        this.commentReplyParam = commentReplyParam;
    }

    public final void setEnableAt(boolean z16) {
        this.enableAt = z16;
    }

    public final void setEnableBarrageEffect(boolean z16) {
        this.enableBarrageEffect = z16;
    }

    public final void setEnableEmo(boolean z16) {
        this.enableEmo = z16;
    }

    public final void setEnableEmoRapidComment(boolean z16) {
        this.enableEmoRapidComment = z16;
    }

    public final void setEnableFont(boolean z16) {
        this.enableFont = z16;
    }

    public final void setEnablePicComment(boolean z16) {
        this.enablePicComment = z16;
    }

    public final void setEnableSuperFont(boolean z16) {
        this.enableSuperFont = z16;
    }

    public final void setFeedsId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedsId = str;
    }

    public final void setFromDIY(boolean z16) {
        this.isFromDIY = z16;
    }

    public final void setFromDtPageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromDtPageId = str;
    }

    public final void setGroupCommentParam(GroupCommentParam groupCommentParam) {
        this.groupCommentParam = groupCommentParam;
    }

    public final void setHintText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hintText = str;
    }

    public final void setMaxInputLength(int i3) {
        this.maxInputLength = i3;
    }

    public final void setNeedShowFavoritesEmo(boolean z16) {
        this.needShowFavoritesEmo = z16;
    }

    public final void setPosition(int i3) {
        this.position = i3;
    }

    public final void setQuiThemeMode(int i3) {
        this.quiThemeMode = i3;
    }

    public final void setRefer(int i3) {
        this.refer = i3;
    }

    public final void setRequestCode(int i3) {
        this.requestCode = i3;
    }

    public final void setSelectFontId(int i3) {
        this.selectFontId = i3;
    }

    public final void setShare(boolean z16) {
        this.isShare = z16;
    }

    public final void setShowPrivateComment(int i3) {
        this.showPrivateComment = i3;
    }

    public final void setShowQuickComment(int i3) {
        this.showQuickComment = i3;
    }

    public final void setShowSharePanel(boolean z16) {
        this.showSharePanel = z16;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bG\u0010HJ-\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\rJ\u0010\u0010 \u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\rJ\u0010\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0014J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0002J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0002J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0014J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0014J\u000e\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0014J\u000e\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0014J\u000e\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0014J\u000e\u00107\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0014J\u000e\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0002J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0014J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0014J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0002J\u0010\u0010A\u001a\u00020\u00002\b\u0010@\u001a\u0004\u0018\u00010\rJ\u0010\u0010D\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010BR\u0014\u0010F\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010E\u00a8\u0006I"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams$a;", "", "", "appid", "", "uin", "ctime", "c", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams$a;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "a", "refer", HippyTKDListViewAdapter.X, "", "feedsId", "o", "requestCode", "y", "position", "v", "", "isAllowEmpty", "r", "maxInputLength", "t", "hintText", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "autoFillText", "d", "cacheFeedsKey", "f", "autoSaveUgcKey", "e", "cacheUniKey", "g", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "b", "showSharePanel", BdhLogUtil.LogTag.Tag_Conn, "showQuickComment", "B", "showPrivateComment", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "enableEmo", "k", "enableEmoRapidComment", "l", "enablePicComment", DomainData.DOMAIN_NAME, "enableAt", "i", "enableFont", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "enableBarrageEffect", "j", "tokenThemeMode", "w", "isFromDIY", ReportConstant.COSTREPORT_PREFIX, "needShowFavoritesEmo", "u", "selectFontId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "fromDtPageId", "p", "Lcom/qzone/reborn/comment/bean/CommentReplyParam;", "commentReplyParam", h.F, "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "params", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final QZoneCommentPanelParams params = new QZoneCommentPanelParams();

        private final a c(Integer appid, Long uin, Long ctime) {
            String str;
            QZoneCommentPanelParams qZoneCommentPanelParams = this.params;
            if (appid != null && uin != null && ctime != null) {
                str = appid + "_" + uin + "_" + (ctime.longValue() / 1000);
            } else {
                str = "";
            }
            qZoneCommentPanelParams.setAiCommentKey(str);
            return this;
        }

        public final a A(int showPrivateComment) {
            this.params.setShowPrivateComment(showPrivateComment);
            return this;
        }

        public final a B(int showQuickComment) {
            if (d.f54318a.b()) {
                this.params.setShowQuickComment(0);
            } else {
                this.params.setShowQuickComment(showQuickComment);
            }
            return this;
        }

        public final a C(boolean showSharePanel) {
            this.params.setShowSharePanel(showSharePanel);
            return this;
        }

        /* renamed from: a, reason: from getter */
        public final QZoneCommentPanelParams getParams() {
            return this.params;
        }

        public final a d(String autoFillText) {
            QZoneCommentPanelParams qZoneCommentPanelParams = this.params;
            if (autoFillText == null) {
                autoFillText = "";
            }
            qZoneCommentPanelParams.setAutoFillText(autoFillText);
            return this;
        }

        public final a e(String autoSaveUgcKey) {
            QZoneCommentPanelParams qZoneCommentPanelParams = this.params;
            if (autoSaveUgcKey == null) {
                autoSaveUgcKey = "";
            }
            qZoneCommentPanelParams.setAutoSaveUgcKey(autoSaveUgcKey);
            return this;
        }

        public final a f(String cacheFeedsKey) {
            QZoneCommentPanelParams qZoneCommentPanelParams = this.params;
            if (cacheFeedsKey == null) {
                cacheFeedsKey = "";
            }
            qZoneCommentPanelParams.setCacheFeedsKey(cacheFeedsKey);
            return this;
        }

        public final a g(String cacheUniKey) {
            QZoneCommentPanelParams qZoneCommentPanelParams = this.params;
            if (cacheUniKey == null) {
                cacheUniKey = "";
            }
            qZoneCommentPanelParams.setCacheUniKey(cacheUniKey);
            return this;
        }

        public final a h(CommentReplyParam commentReplyParam) {
            this.params.setCommentReplyParam(commentReplyParam);
            return this;
        }

        public final a i(boolean enableAt) {
            this.params.setEnableAt(enableAt);
            return this;
        }

        public final a j(boolean enableBarrageEffect) {
            this.params.setEnableBarrageEffect(enableBarrageEffect);
            return this;
        }

        public final a k(boolean enableEmo) {
            this.params.setEnableEmo(enableEmo);
            return this;
        }

        public final a l(boolean enableEmoRapidComment) {
            this.params.setEnableEmoRapidComment(enableEmoRapidComment);
            return this;
        }

        public final a m(boolean enableFont) {
            this.params.setEnableFont(enableFont);
            return this;
        }

        public final a n(boolean enablePicComment) {
            this.params.setEnablePicComment(enablePicComment);
            return this;
        }

        public final a o(String feedsId) {
            QZoneCommentPanelParams qZoneCommentPanelParams = this.params;
            if (feedsId == null) {
                feedsId = "";
            }
            qZoneCommentPanelParams.setFeedsId(feedsId);
            return this;
        }

        public final a p(String fromDtPageId) {
            QZoneCommentPanelParams qZoneCommentPanelParams = this.params;
            if (fromDtPageId == null) {
                fromDtPageId = "";
            }
            qZoneCommentPanelParams.setFromDtPageId(fromDtPageId);
            return this;
        }

        public final a q(String hintText) {
            QZoneCommentPanelParams qZoneCommentPanelParams = this.params;
            if (hintText == null) {
                hintText = "";
            }
            qZoneCommentPanelParams.setHintText(hintText);
            return this;
        }

        public final a r(boolean isAllowEmpty) {
            this.params.setAllowEmpty(isAllowEmpty);
            return this;
        }

        public final a s(boolean isFromDIY) {
            this.params.setFromDIY(isFromDIY);
            return this;
        }

        public final a t(int maxInputLength) {
            this.params.setMaxInputLength(maxInputLength);
            return this;
        }

        public final a u(boolean needShowFavoritesEmo) {
            this.params.setNeedShowFavoritesEmo(needShowFavoritesEmo);
            return this;
        }

        public final a v(int position) {
            this.params.setPosition(position);
            return this;
        }

        public final a w(int tokenThemeMode) {
            this.params.setQuiThemeMode(tokenThemeMode);
            return this;
        }

        public final a x(int refer) {
            this.params.setRefer(refer);
            return this;
        }

        public final a y(int requestCode) {
            this.params.setRequestCode(requestCode);
            return this;
        }

        public final a z(int selectFontId) {
            this.params.setSelectFontId(selectFontId);
            return this;
        }

        public final a b(BusinessFeedData feedData) {
            User user;
            if ((feedData != null ? feedData.cellFeedCommInfo : null) != null && feedData.cellUserInfo != null) {
                CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
                Integer valueOf = cellFeedCommInfo != null ? Integer.valueOf(cellFeedCommInfo.appid) : null;
                CellUserInfo cellUserInfo = feedData.cellUserInfo;
                Long valueOf2 = (cellUserInfo == null || (user = cellUserInfo.user) == null) ? null : Long.valueOf(user.uin);
                CellFeedCommInfo cellFeedCommInfo2 = feedData.cellFeedCommInfo;
                return c(valueOf, valueOf2, cellFeedCommInfo2 != null ? Long.valueOf(cellFeedCommInfo2.time) : null);
            }
            this.params.setAiCommentKey("");
            return this;
        }
    }

    public String toString() {
        return "QZoneCommentPanelParams(refer=" + this.refer + ", requestCode=" + this.requestCode + ", position=" + this.position + ", isAllowEmpty=" + this.isAllowEmpty + ", maxInputLength=" + this.maxInputLength + ", autoFillText='" + this.autoFillText + "', feedsId='" + this.feedsId + "', cacheFeedsKey='" + this.cacheFeedsKey + "', autoSaveUgcKey='" + this.autoSaveUgcKey + "', cacheUniKey='" + this.cacheUniKey + "', isShare=" + this.isShare + ", showSharePanel=" + this.showSharePanel + ", showQuickComment=" + this.showQuickComment + ", showPrivateComment=" + this.showPrivateComment + ", enableEmo=" + this.enableEmo + ", enableEmoRapidComment=" + this.enableEmoRapidComment + ", enablePicComment=" + this.enablePicComment + ", enableAt=" + this.enableAt + ", enableFont=" + this.enableFont + ", enableBarrageEffect=" + this.enableBarrageEffect + ", quiThemeMode=" + this.quiThemeMode + ", isFromDIY=" + this.isFromDIY + ", enableSuperFont=" + this.enableSuperFont + ", needShowFavoritesEmo=" + this.needShowFavoritesEmo + ", selectFontId=" + this.selectFontId + ", fromDtPageId='" + this.fromDtPageId + "', commentReplyParam=" + this.commentReplyParam + ", groupCommentParam=" + this.groupCommentParam + ")";
    }

    public static /* synthetic */ void getQuiThemeMode$annotations() {
    }
}
