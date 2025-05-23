package mk;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceMedal$MainPageMedalDetail;
import qzone.QZIntimateSpaceMedal$MedalInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\rH\u0007J(\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0007J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0007J(\u0010 \u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0007J \u0010!\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J,\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\"2\u0006\u0010\u000b\u001a\u00020\nJ$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\"J$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020'0\u0004j\b\u0012\u0004\u0012\u00020'`\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\"J$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020'0\u0004j\b\u0012\u0004\u0012\u00020'`\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\"J$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020'0\u0004j\b\u0012\u0004\u0012\u00020'`\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\"\u00a8\u0006-"}, d2 = {"Lmk/b;", "", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "spaceBean", "Ljava/util/ArrayList;", "Lij/a;", "Lkotlin/collections/ArrayList;", "d", "Lqzone/QZIntimateSpaceMedal$MainPageMedalDetail;", "medalDetail", "", "type", "b", "Landroid/view/View;", "badgeImg", "Landroid/animation/AnimatorListenerAdapter;", "listener", "", "o", "haloImg", "l", "Landroid/view/animation/RotateAnimation;", "k", "badgeCountTv", "badgeListTv", "j", "shareBtn", "closeBtn", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "badgeShareBtn", "badgeCloseBtn", tl.h.F, "i", "", "medalDetailList", "c", "animViewBeanList", "a", "", "e", "g", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f416873a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"mk/b$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[endHaloRotateAnim]");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startHaloRotateAnim]");
        }
    }

    b() {
    }

    private final ij.a b(QZIntimateSpaceMedal$MainPageMedalDetail medalDetail, int type) {
        ij.a aVar = new ij.a();
        String str = medalDetail.alert_medal.name.get();
        Intrinsics.checkNotNullExpressionValue(str, "medalDetail.alert_medal.name.get()");
        aVar.j(str);
        String str2 = medalDetail.alert_medal.icon.get();
        Intrinsics.checkNotNullExpressionValue(str2, "medalDetail.alert_medal.icon.get()");
        aVar.k(str2);
        String str3 = medalDetail.num_content.get();
        Intrinsics.checkNotNullExpressionValue(str3, "medalDetail.num_content.get()");
        aVar.n(str3);
        String str4 = medalDetail.list_content.get();
        Intrinsics.checkNotNullExpressionValue(str4, "medalDetail.list_content.get()");
        aVar.l(str4);
        aVar.i(type);
        List<QZIntimateSpaceMedal$MedalInfo> list = medalDetail.new_medals.get();
        Intrinsics.checkNotNullExpressionValue(list, "medalDetail.new_medals.get()");
        aVar.m(list);
        aVar.h(medalDetail.alert_medal.f430331id.get());
        return aVar;
    }

    @JvmStatic
    public static final void h(View badgeCountTv, View badgeListTv, View badgeShareBtn, View badgeCloseBtn) {
        Intrinsics.checkNotNullParameter(badgeCountTv, "badgeCountTv");
        Intrinsics.checkNotNullParameter(badgeListTv, "badgeListTv");
        Intrinsics.checkNotNullParameter(badgeShareBtn, "badgeShareBtn");
        Intrinsics.checkNotNullParameter(badgeCloseBtn, "badgeCloseBtn");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(badgeCountTv, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(10L), ObjectAnimator.ofFloat(badgeListTv, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(10L), ObjectAnimator.ofFloat(badgeShareBtn, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(10L), ObjectAnimator.ofFloat(badgeCloseBtn, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(10L));
        animatorSet.start();
    }

    @JvmStatic
    public static final void i(View badgeImg, View badgeCountTv, AnimatorListenerAdapter listener) {
        Intrinsics.checkNotNullParameter(badgeImg, "badgeImg");
        Intrinsics.checkNotNullParameter(badgeCountTv, "badgeCountTv");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Rect rect = new Rect();
        badgeImg.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        badgeCountTv.getGlobalVisibleRect(rect2);
        int i3 = rect2.top;
        int i16 = rect.bottom;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(badgeImg, "translationY", 0.0f, i3 - i16, i16 * (-1));
        he0.b.m(ofFloat, R.anim.f154973ug, 7.3f);
        ofFloat.addListener(listener);
        ofFloat.start();
    }

    @JvmStatic
    public static final void j(View haloImg, View badgeCountTv, View badgeListTv, AnimatorListenerAdapter listener) {
        Intrinsics.checkNotNullParameter(haloImg, "haloImg");
        Intrinsics.checkNotNullParameter(badgeCountTv, "badgeCountTv");
        Intrinsics.checkNotNullParameter(badgeListTv, "badgeListTv");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(haloImg, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(100L), ObjectAnimator.ofFloat(badgeCountTv, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(400L), ObjectAnimator.ofFloat(badgeListTv, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(400L));
        animatorSet.addListener(listener);
        animatorSet.start();
    }

    @JvmStatic
    public static final RotateAnimation k(View haloImg) {
        Intrinsics.checkNotNullParameter(haloImg, "haloImg");
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setDuration(3000L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setAnimationListener(new a());
        haloImg.startAnimation(rotateAnimation);
        return rotateAnimation;
    }

    @JvmStatic
    public static final void l(View haloImg, AnimatorListenerAdapter listener) {
        Intrinsics.checkNotNullParameter(haloImg, "haloImg");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(haloImg, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f).setDuration(100L), ObjectAnimator.ofFloat(haloImg, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f).setDuration(100L));
        animatorSet.addListener(listener);
        animatorSet.start();
    }

    @JvmStatic
    public static final void m(View shareBtn, View closeBtn) {
        Intrinsics.checkNotNullParameter(shareBtn, "shareBtn");
        Intrinsics.checkNotNullParameter(closeBtn, "closeBtn");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(shareBtn, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(400L), ObjectAnimator.ofFloat(closeBtn, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(400L));
        animatorSet.start();
    }

    @JvmStatic
    public static final void n(View shareBtn, View closeBtn) {
        Intrinsics.checkNotNullParameter(shareBtn, "shareBtn");
        Intrinsics.checkNotNullParameter(closeBtn, "closeBtn");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(shareBtn, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(400L), ObjectAnimator.ofFloat(closeBtn, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(400L));
        animatorSet.start();
    }

    @JvmStatic
    public static final void o(View badgeImg, AnimatorListenerAdapter listener) {
        Intrinsics.checkNotNullParameter(badgeImg, "badgeImg");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(badgeImg, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(140L);
        ofFloat.addListener(listener);
        ofFloat.start();
    }

    public final ArrayList<ij.a> a(List<ij.a> animViewBeanList) {
        Intrinsics.checkNotNullParameter(animViewBeanList, "animViewBeanList");
        ArrayList<ij.a> arrayList = new ArrayList<>();
        if (animViewBeanList.isEmpty()) {
            return arrayList;
        }
        for (ij.a aVar : animViewBeanList) {
            if (TextUtils.isEmpty(aVar.getBadgeUrl())) {
                QLog.e("QZoneIntimateBadgeAnimUtil", 1, "badge url is empty");
            } else if (TextUtils.isEmpty(aVar.getNumContent())) {
                QLog.e("QZoneIntimateBadgeAnimUtil", 1, "numContent is empty");
            } else if (TextUtils.isEmpty(aVar.getListContent())) {
                QLog.e("QZoneIntimateBadgeAnimUtil", 1, "listContent is empty");
            } else {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public final ArrayList<ij.a> c(List<QZIntimateSpaceMedal$MainPageMedalDetail> medalDetailList, int type) {
        Intrinsics.checkNotNullParameter(medalDetailList, "medalDetailList");
        ArrayList<ij.a> arrayList = new ArrayList<>();
        if (medalDetailList.isEmpty()) {
            return arrayList;
        }
        for (QZIntimateSpaceMedal$MainPageMedalDetail qZIntimateSpaceMedal$MainPageMedalDetail : medalDetailList) {
            if (qZIntimateSpaceMedal$MainPageMedalDetail.has()) {
                arrayList.add(b(qZIntimateSpaceMedal$MainPageMedalDetail, type));
            }
        }
        return arrayList;
    }

    public final ArrayList<String> e(List<ij.a> animViewBeanList) {
        Intrinsics.checkNotNullParameter(animViewBeanList, "animViewBeanList");
        ArrayList<String> arrayList = new ArrayList<>();
        if (animViewBeanList.isEmpty()) {
            return arrayList;
        }
        Iterator<ij.a> it = animViewBeanList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getBadgeUrl());
        }
        return arrayList;
    }

    public final ArrayList<String> f(List<ij.a> animViewBeanList) {
        Intrinsics.checkNotNullParameter(animViewBeanList, "animViewBeanList");
        ArrayList<String> arrayList = new ArrayList<>();
        if (animViewBeanList.isEmpty()) {
            return arrayList;
        }
        Iterator<ij.a> it = animViewBeanList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getListContent());
        }
        return arrayList;
    }

    public final ArrayList<String> g(List<ij.a> animViewBeanList) {
        Intrinsics.checkNotNullParameter(animViewBeanList, "animViewBeanList");
        ArrayList<String> arrayList = new ArrayList<>();
        if (animViewBeanList.isEmpty()) {
            return arrayList;
        }
        Iterator<ij.a> it = animViewBeanList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getNumContent());
        }
        return arrayList;
    }

    @JvmStatic
    public static final ArrayList<ij.a> d(QZoneIntimateSpaceBean spaceBean) {
        QZIntimateSpaceMedal$MainPageMedalDetail medalInfo = spaceBean != null ? spaceBean.getMedalInfo() : null;
        if (medalInfo == null) {
            QLog.e("QZoneIntimateBadgeAnimUtil", 1, "[hasBadgeAnimData] medalInfo is null");
            return new ArrayList<>();
        }
        if (!spaceBean.isFromRefreshSpace()) {
            QLog.e("QZoneIntimateBadgeAnimUtil", 1, "[hasBadgeAnimData] not from refresh space");
            return new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(medalInfo);
        List<QZIntimateSpaceMedal$MainPageMedalDetail> animInfoList = spaceBean.getAnimInfoList();
        b bVar = f416873a;
        ArrayList<ij.a> c16 = bVar.c(arrayList, 1);
        ArrayList<ij.a> c17 = bVar.c(animInfoList, 2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(c17);
        arrayList2.addAll(c16);
        ArrayList<ij.a> a16 = bVar.a(arrayList2);
        if (!ArrayUtils.isOutOfArrayIndex(0, a16)) {
            return a16;
        }
        QLog.e("QZoneIntimateBadgeAnimUtil", 1, "[hasBadgeAnimData] BadgeAnim");
        return new ArrayList<>();
    }
}
