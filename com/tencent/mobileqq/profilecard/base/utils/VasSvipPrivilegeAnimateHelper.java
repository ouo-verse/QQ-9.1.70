package com.tencent.mobileqq.profilecard.base.utils;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.avatar.utils.f;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.SvipPrivilegeShow;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.VoteViewElegant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* loaded from: classes16.dex */
public class VasSvipPrivilegeAnimateHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int ANIMATION_DURATION = 2000;
    public static final float LEVEL_VIEW_DP_VALUE = 100.8f;
    private static final String TAG = "VasSvipPrivilegeAnimateHelper";
    private static final List<WeakReference<View>> sAnimateViews;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74006);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sAnimateViews = new ArrayList();
        }
    }

    public VasSvipPrivilegeAnimateHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addSvipPrivilegeAnimateView(View view) {
        boolean z16;
        Iterator<WeakReference<View>> it = sAnimateViews.iterator();
        while (true) {
            if (it.hasNext()) {
                View view2 = it.next().get();
                if (view2 != null && view2 == view) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            sAnimateViews.add(new WeakReference<>(view));
        }
    }

    private static void playAnimation(View view) {
        QLog.d(TAG, 1, "playAnimation " + view);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.2f, 0.8f, 1.2f, 1.0f);
        long j3 = (long) 2000;
        ofFloat.setDuration(j3);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.2f, 0.8f, 1.2f, 1.0f);
        ofFloat2.setDuration(j3);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public static void playSvipPrivilegeAnimation(ProfileCardInfo profileCardInfo, List<SvipPrivilegeShow> list) {
        Iterator<WeakReference<View>> it = sAnimateViews.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null) {
                for (SvipPrivilegeShow svipPrivilegeShow : list) {
                    int i3 = svipPrivilegeShow.appId;
                    if (i3 != 4) {
                        if (i3 != 41) {
                            if (i3 == 328) {
                                replaceLikeAreaId(view, profileCardInfo, svipPrivilegeShow.itemId);
                            }
                        } else {
                            replaceLevelIcon(view, profileCardInfo, svipPrivilegeShow.itemId);
                        }
                    } else {
                        replacePendant(view, profileCardInfo, svipPrivilegeShow.itemId);
                    }
                }
            }
        }
        Iterator<WeakReference<View>> it5 = sAnimateViews.iterator();
        while (it5.hasNext()) {
            View view2 = it5.next().get();
            if (view2 != null) {
                if (view2 instanceof AvatarLayout) {
                    QQProAvatarView qQProAvatarView = (QQProAvatarView) ((AvatarLayout) view2).c(0);
                    if (qQProAvatarView.getChildCount() > 0) {
                        View childAt = qQProAvatarView.getChildAt(qQProAvatarView.getChildCount() - 1);
                        if (childAt != null) {
                            view2 = childAt;
                        }
                    } else {
                        QLog.d(TAG, 1, "playSvipPrivilegeAnimation pendant not add");
                    }
                }
                playAnimation(view2);
            }
        }
    }

    public static void replaceLevelIcon(View view, ProfileCardInfo profileCardInfo, int i3) {
        if (!(view instanceof AnimationTextView)) {
            return;
        }
        ((AnimationTextView) view).setText(LevelUtil.parseQQLevel(view.getContext(), ViewUtils.dip2px(100.8f), i3, profileCardInfo.card.iQQLevel, true, (int) view.getContext().getResources().getDimension(R.dimen.f159041uo)), TextView.BufferType.SPANNABLE);
        QLog.d(TAG, 1, "replaceLevelIcon " + view + ",id=" + i3);
    }

    public static void replaceLikeAreaId(View view, ProfileCardInfo profileCardInfo, int i3) {
        boolean z16;
        if (!(view instanceof VoteViewElegant)) {
            return;
        }
        Card card = profileCardInfo.card;
        int i16 = (int) card.lVoteCount;
        int i17 = card.iVoteIncrement;
        if (1 == card.bVoted) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((VoteViewElegant) view).r(true, z16, i16, i17, null, false, i3, Boolean.valueOf(card.isLuckyVip()), profileCardInfo.card.uin);
        QLog.d(TAG, 1, "replaceLikeAreaId " + view + ",id=" + i3);
    }

    public static void replacePendant(View view, ProfileCardInfo profileCardInfo, int i3) {
        if (!(view instanceof AvatarLayout)) {
            return;
        }
        boolean z16 = false;
        View c16 = ((AvatarLayout) view).c(0);
        boolean isPaTypeHasUin = ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne);
        e.a m3 = new e.a().e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(profileCardInfo.allInOne.uin)).b(true).j(true).p(7).c(true).m(7);
        if (isPaTypeHasUin && !SimpleUIUtil.isNowSimpleMode()) {
            z16 = true;
        }
        com.tencent.mobileqq.proavatar.e a16 = m3.d(z16).n(1).o(3).g(640).a();
        com.tencent.qqnt.avatar.fetch.c buildResourceFetchRequest = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(1, profileCardInfo.allInOne.uin, a16);
        replacePendantId(i3, a16, buildResourceFetchRequest.d(), profileCardInfo);
        ((QQProAvatarView) c16).z(buildResourceFetchRequest, true);
        QLog.d(TAG, 1, "replacePendant " + view + ",id=" + i3);
    }

    private static void replacePendantId(int i3, com.tencent.mobileqq.proavatar.e eVar, List<com.tencent.qqnt.avatar.bean.a> list, ProfileCardInfo profileCardInfo) {
        if (list != null && !list.isEmpty()) {
            boolean z16 = false;
            for (com.tencent.qqnt.avatar.bean.a aVar : list) {
                if (aVar instanceof f) {
                    ((f) aVar).n(i3);
                    z16 = true;
                }
            }
            if (!z16) {
                list.add(new f(1, profileCardInfo.allInOne.uin, eVar.l(), i3, 0, null, eVar.o(), eVar.k(), eVar.j(), false, 0));
            }
        }
    }
}
