package com.tencent.mobileqq.share.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.share.api.IShareActionSheetApi;
import com.tencent.mobileqq.share.api.QCircleActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShareActionSheetApiImpl implements IShareActionSheetApi {
    static IPatchRedirector $redirector_;
    private QCircleActionSheetClickListener mQCircleClickListener;
    private ShareActionSheet mShareActionSheet;
    private ShareActionSheetClickListener mShareActionSheetClickListener;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionSheetApiImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ShareActionSheetApiImpl.this.handleClickMenuItem(actionSheetItem);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements ShareActionSheet.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f287082d;

        b(View view) {
            this.f287082d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionSheetApiImpl.this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.b
        public View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f287082d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements ShareActionSheet.a {
        static IPatchRedirector $redirector_;

        c(com.tencent.mobileqq.share.api.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionSheetApiImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.a
        public void a(List<ResultRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            throw null;
        }
    }

    public ShareActionSheetApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> getLines(List<ShareConfig> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (ShareConfig shareConfig : list) {
            if (shareConfig != null) {
                arrayList.addAll(getPathsLines(shareConfig));
                arrayList.addAll(getOperationsLines(shareConfig));
            }
        }
        return arrayList;
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> getOperationsLines(ShareConfig shareConfig) {
        ArrayList arrayList = new ArrayList();
        if (shareConfig == null) {
            return arrayList;
        }
        if (shareConfig.isShowQrcodeSave) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(210, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowQrcode) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(123, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowStick) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(186, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowUnStick) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(187, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDelete) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDataAnalyze) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(209, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowFeedBindQQGroup) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(214, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDeleteAndEditAlbum) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(191, shareConfig.isForceNightTheme));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(190, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowSave) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowSetQQProfileCover) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(231, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowSetToPublicPermission) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(188, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowSetToPrivatePermission) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(189, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowBarrageOpen) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(142, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowBarrageClose) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(143, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowCollect) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(6, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowUnCollect) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(84, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowQCircleEnterFloatingWindow) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(216, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowBackgroundMusic) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(217, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDisLike) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(44, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowHideThisWork) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(141, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowCopyContent) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(221, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowReport) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowFeedback) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(151, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDebug) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(74, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDeletePush) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(140, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDeletePushDisable) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(167, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowCopySchemaLink) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowContentPromotion) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(211, shareConfig.isForceNightTheme));
        }
        return arrayList;
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> getPathsLines(ShareConfig shareConfig) {
        ArrayList arrayList = new ArrayList();
        if (shareConfig == null) {
            return arrayList;
        }
        if (shareConfig.isShowShareToFriend) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowShareToChannel) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowShareToQZone) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowShareToWechat) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowShareToWechatCircle) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10, shareConfig.isForceNightTheme));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickMenuItem(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        QCircleActionSheetClickListener qCircleActionSheetClickListener;
        int i3 = actionSheetItem.action;
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 39) {
                        if (i3 != 40) {
                            if (i3 != 216) {
                                if (i3 != 217) {
                                    switch (i3) {
                                        case 6:
                                            ShareActionSheetClickListener shareActionSheetClickListener = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener != null) {
                                                shareActionSheetClickListener.collect();
                                                break;
                                            }
                                            break;
                                        case 44:
                                            ShareActionSheetClickListener shareActionSheetClickListener2 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener2 != null) {
                                                shareActionSheetClickListener2.showReportDisLike();
                                            }
                                            z16 = false;
                                            break;
                                        case 84:
                                            ShareActionSheetClickListener shareActionSheetClickListener3 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener3 != null) {
                                                shareActionSheetClickListener3.unCollect();
                                                break;
                                            }
                                            break;
                                        case 86:
                                            ShareActionSheetClickListener shareActionSheetClickListener4 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener4 != null) {
                                                shareActionSheetClickListener4.hideHim();
                                                break;
                                            }
                                            break;
                                        case 123:
                                            ShareActionSheetClickListener shareActionSheetClickListener5 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener5 != null) {
                                                shareActionSheetClickListener5.createQrcode();
                                                break;
                                            }
                                            break;
                                        case 151:
                                            ShareActionSheetClickListener shareActionSheetClickListener6 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener6 != null) {
                                                shareActionSheetClickListener6.feedback();
                                                break;
                                            }
                                            break;
                                        case 162:
                                            ShareActionSheetClickListener shareActionSheetClickListener7 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener7 != null) {
                                                shareActionSheetClickListener7.jumpQcirclePrivateMessage();
                                                break;
                                            }
                                            break;
                                        case 167:
                                            ShareActionSheetClickListener shareActionSheetClickListener8 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener8 != null) {
                                                shareActionSheetClickListener8.cancelPushDisable();
                                                break;
                                            }
                                            break;
                                        case 171:
                                            ShareActionSheetClickListener shareActionSheetClickListener9 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener9 != null) {
                                                shareActionSheetClickListener9.shareToChannel(i3);
                                                break;
                                            }
                                            break;
                                        case 214:
                                            ShareActionSheetClickListener shareActionSheetClickListener10 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener10 != null) {
                                                shareActionSheetClickListener10.openFeedBindQQGroupPage();
                                                break;
                                            }
                                            break;
                                        case 221:
                                            ShareActionSheetClickListener shareActionSheetClickListener11 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener11 != null) {
                                                shareActionSheetClickListener11.copyContent();
                                                break;
                                            }
                                            break;
                                        case 231:
                                            ShareActionSheetClickListener shareActionSheetClickListener12 = this.mShareActionSheetClickListener;
                                            if (shareActionSheetClickListener12 != null) {
                                                shareActionSheetClickListener12.setQQProfileCover();
                                                break;
                                            }
                                            break;
                                        default:
                                            switch (i3) {
                                                case 9:
                                                    ShareActionSheetClickListener shareActionSheetClickListener13 = this.mShareActionSheetClickListener;
                                                    if (shareActionSheetClickListener13 != null) {
                                                        shareActionSheetClickListener13.shareToWeChat(i3);
                                                        break;
                                                    }
                                                    break;
                                                case 10:
                                                    ShareActionSheetClickListener shareActionSheetClickListener14 = this.mShareActionSheetClickListener;
                                                    if (shareActionSheetClickListener14 != null) {
                                                        shareActionSheetClickListener14.shareToWeChatCircle(i3);
                                                        break;
                                                    }
                                                    break;
                                                case 11:
                                                    ShareActionSheetClickListener shareActionSheetClickListener15 = this.mShareActionSheetClickListener;
                                                    if (shareActionSheetClickListener15 != null) {
                                                        shareActionSheetClickListener15.report();
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 72:
                                                            ShareActionSheetClickListener shareActionSheetClickListener16 = this.mShareActionSheetClickListener;
                                                            if (shareActionSheetClickListener16 != null) {
                                                                shareActionSheetClickListener16.shareToSpecifiedFriend(actionSheetItem.label, actionSheetItem.uin, actionSheetItem.uinType);
                                                                break;
                                                            }
                                                            break;
                                                        case 73:
                                                            break;
                                                        case 74:
                                                            ShareActionSheetClickListener shareActionSheetClickListener17 = this.mShareActionSheetClickListener;
                                                            if (shareActionSheetClickListener17 != null) {
                                                                shareActionSheetClickListener17.miniAppDebugOn();
                                                                break;
                                                            }
                                                            break;
                                                        default:
                                                            switch (i3) {
                                                                case 140:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener18 = this.mShareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener18 != null) {
                                                                        shareActionSheetClickListener18.deleteHasPush();
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 141:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener19 = this.mShareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener19 != null) {
                                                                        shareActionSheetClickListener19.hideThisWork();
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 142:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener20 = this.mShareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener20 != null) {
                                                                        shareActionSheetClickListener20.switchBarrageOpen();
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 143:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener21 = this.mShareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener21 != null) {
                                                                        shareActionSheetClickListener21.switchBarrageClose();
                                                                        break;
                                                                    }
                                                                    break;
                                                                default:
                                                                    switch (i3) {
                                                                        case 186:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener22 = this.mShareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener22 != null) {
                                                                                shareActionSheetClickListener22.stick();
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 187:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener23 = this.mShareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener23 != null) {
                                                                                shareActionSheetClickListener23.unStick();
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 188:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener24 = this.mShareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener24 != null) {
                                                                                shareActionSheetClickListener24.changeFeedPermission(true);
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 189:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener25 = this.mShareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener25 != null) {
                                                                                shareActionSheetClickListener25.changeFeedPermission(false);
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 190:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener26 = this.mShareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener26 != null) {
                                                                                shareActionSheetClickListener26.deleteAlbum();
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 191:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener27 = this.mShareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener27 != null) {
                                                                                shareActionSheetClickListener27.editAlbum();
                                                                                break;
                                                                            }
                                                                            break;
                                                                        default:
                                                                            switch (i3) {
                                                                                case 209:
                                                                                    ShareActionSheetClickListener shareActionSheetClickListener28 = this.mShareActionSheetClickListener;
                                                                                    if (shareActionSheetClickListener28 != null) {
                                                                                        shareActionSheetClickListener28.dataAnalyze();
                                                                                        break;
                                                                                    }
                                                                                    break;
                                                                                case 210:
                                                                                    ShareActionSheetClickListener shareActionSheetClickListener29 = this.mShareActionSheetClickListener;
                                                                                    if (shareActionSheetClickListener29 != null) {
                                                                                        shareActionSheetClickListener29.saveQrcode();
                                                                                        break;
                                                                                    }
                                                                                    break;
                                                                                case 211:
                                                                                    ShareActionSheetClickListener shareActionSheetClickListener30 = this.mShareActionSheetClickListener;
                                                                                    if (shareActionSheetClickListener30 != null) {
                                                                                        shareActionSheetClickListener30.promotion();
                                                                                        break;
                                                                                    }
                                                                                    break;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                } else {
                                    ShareActionSheetClickListener shareActionSheetClickListener31 = this.mShareActionSheetClickListener;
                                    if (shareActionSheetClickListener31 != null) {
                                        shareActionSheetClickListener31.openMusicAggregationPage();
                                    }
                                }
                            } else {
                                ShareActionSheetClickListener shareActionSheetClickListener32 = this.mShareActionSheetClickListener;
                                if (shareActionSheetClickListener32 != null) {
                                    shareActionSheetClickListener32.enterQCircleFloatingWindow();
                                }
                            }
                        } else {
                            ShareActionSheetClickListener shareActionSheetClickListener33 = this.mShareActionSheetClickListener;
                            if (shareActionSheetClickListener33 != null) {
                                shareActionSheetClickListener33.delete();
                            }
                        }
                    } else {
                        ShareActionSheetClickListener shareActionSheetClickListener34 = this.mShareActionSheetClickListener;
                        if (shareActionSheetClickListener34 != null) {
                            shareActionSheetClickListener34.save();
                        }
                    }
                } else {
                    ShareActionSheetClickListener shareActionSheetClickListener35 = this.mShareActionSheetClickListener;
                    if (shareActionSheetClickListener35 != null) {
                        shareActionSheetClickListener35.shareToQZone();
                    }
                }
            }
            ShareActionSheetClickListener shareActionSheetClickListener36 = this.mShareActionSheetClickListener;
            if (shareActionSheetClickListener36 != null) {
                shareActionSheetClickListener36.shareToQQ();
            }
        } else {
            ShareActionSheetClickListener shareActionSheetClickListener37 = this.mShareActionSheetClickListener;
            if (shareActionSheetClickListener37 != null) {
                shareActionSheetClickListener37.copyLink();
            }
        }
        if ((i3 == 3 || i3 == 9 || i3 == 10 || i3 == 72 || i3 == 73 || i3 == 2 || i3 == 171 || i3 == 142 || i3 == 143) && (qCircleActionSheetClickListener = this.mQCircleClickListener) != null) {
            qCircleActionSheetClickListener.dispatchEvent();
        }
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.dismiss();
        }
        QCircleActionSheetClickListener qCircleActionSheetClickListener2 = this.mQCircleClickListener;
        if (qCircleActionSheetClickListener2 != null) {
            qCircleActionSheetClickListener2.afterHandleClick(z16);
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public Window getWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Window) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null) {
            return shareActionSheet.getWindow();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        param.dimAmount = -1.0f;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        this.mShareActionSheet = create;
        create.setItemClickListenerV2(new a());
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null && shareActionSheet.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setActionSheetClickListener(ShareActionSheetClickListener shareActionSheetClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) shareActionSheetClickListener);
        } else {
            this.mShareActionSheetClickListener = shareActionSheetClickListener;
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setActionSheetItems(ShareConfig shareConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) shareConfig);
            return;
        }
        this.mShareActionSheet.setActionSheetItems(getPathsLines(shareConfig), getOperationsLines(shareConfig));
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setBottomView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.setBottomBarInterface(new b(view));
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onCancelListener);
        } else {
            this.mShareActionSheet.setCancelListener(onCancelListener);
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setExtras(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.setExtras(bundle);
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setIntentForStartForwardRecentActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
        } else {
            this.mShareActionSheet.setIntentForStartForwardRecentActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onDismissListener);
        } else {
            this.mShareActionSheet.setOnDismissListener(onDismissListener);
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onShowListener);
            return;
        }
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.setOnShowListener(onShowListener);
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setQCircleActionSheetClickListener(QCircleActionSheetClickListener qCircleActionSheetClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qCircleActionSheetClickListener);
        } else {
            this.mQCircleClickListener = qCircleActionSheetClickListener;
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setRecentlyUserSorter(com.tencent.mobileqq.share.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
            return;
        }
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.setRecentlyUserSorter(new c(aVar));
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setRowVisibility(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.mShareActionSheet.setRowVisibility(i3, i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mShareActionSheet.show();
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActionSheetApi
    public void setActionSheetItems(List<ShareConfig> list, List<ShareConfig> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            this.mShareActionSheet.setActionSheetItems(getLines(list), getLines(list2));
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list, (Object) list2);
        }
    }
}
