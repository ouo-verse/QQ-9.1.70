package com.tencent.mobileqq.flock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import b55.g;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.feeddetail.FlockFeedDetailFragment;
import com.tencent.mobileqq.flock.feeddetail.bean.FlockFeedDetailInitBean;
import com.tencent.mobileqq.flock.feedlist.FlockFeedListFragment;
import com.tencent.mobileqq.flock.homepage.FlockHomePageFragment;
import com.tencent.mobileqq.flock.layer.FlockFeedLayerFragment;
import com.tencent.mobileqq.flock.layer.bean.FlockLayerInitBean;
import com.tencent.mobileqq.flock.member.fragment.FlockMemberListFragment;
import com.tencent.mobileqq.flock.publish.FlockPublishFragment;
import com.tencent.mobileqq.flock.repeat.FlockRepeatSelectFragment;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.flock.topic.FlockTopicListFragment;
import com.tencent.mobileqq.flock.topic.FlockTopicSearchFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.topicaggregation.FlockTopicAggregationFragment;
import com.tencent.mobileqq.topicaggregation.bean.FlockTopicAggregationInitBean;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import y45.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJC\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ,\u0010 \u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J&\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\"2\u0006\u0010%\u001a\u00020$J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(J\u0016\u0010,\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/flock/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/flock/feeddetail/bean/FlockFeedDetailInitBean;", "initBean", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/flock/layer/bean/FlockLayerInitBean;", "c", "Ly45/b;", "feed", "b", "", "requestCode", "l", "k", "from", "", "groupId", "feedDetail", "Lb55/g;", "tagInfo", "d", "(Landroid/content/Context;ILjava/lang/Long;Ly45/b;Lb55/g;)V", "Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType;", "type", "Ljava/util/Date;", "endTimeDate", "activityStartTimeDate", "f", "g", "", "feedDatas", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "scene", "i", h.F, "", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/topicaggregation/bean/FlockTopicAggregationInitBean;", "j", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f209993a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f209993a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void e(a aVar, Context context, int i3, Long l3, b bVar, g gVar, int i16, Object obj) {
        b bVar2;
        g gVar2;
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            l3 = 0L;
        }
        Long l16 = l3;
        if ((i16 & 8) != 0) {
            bVar2 = null;
        } else {
            bVar2 = bVar;
        }
        if ((i16 & 16) != 0) {
            gVar2 = null;
        } else {
            gVar2 = gVar;
        }
        aVar.d(context, i17, l16, bVar2, gVar2);
    }

    public final void a(@NotNull Context context, @NotNull FlockFeedDetailInitBean initBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) initBean);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intent intent = new Intent();
        intent.setClass(context, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", FlockFeedDetailFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", initBean);
        context.startActivity(intent);
    }

    public final void b(@NotNull Context context, @NotNull b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        FlockMemberListFragment flockMemberListFragment = new FlockMemberListFragment();
        Bundle bundle = new Bundle();
        bundle.putByteArray("key_feed", MessageNano.toByteArray(feed));
        flockMemberListFragment.setArguments(bundle);
        flockMemberListFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "flock_member");
    }

    public final void c(@NotNull Activity activity, @NotNull FlockLayerInitBean initBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) initBean);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        ImageView clickView = initBean.getClickView();
        List<RFWLayerItemMediaInfo> mediaInfoList = initBean.getMediaInfoList();
        int curPos = initBean.getCurPos();
        Bundle bundle = new Bundle();
        bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
        Unit unit = Unit.INSTANCE;
        RFWLayerLaunchUtil.jumpToGallery$default(activity, clickView, mediaInfoList, curPos, FlockFeedGalleryActivity.class, FlockFeedLayerFragment.class, bundle, 0, 128, null);
    }

    public final void d(@NotNull Context context, int from, @Nullable Long groupId, @Nullable b feedDetail, @Nullable g tagInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, Integer.valueOf(from), groupId, feedDetail, tagInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setClass(context, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", FlockPublishFragment.class.getName());
        intent.putExtra("key_flock_from", from);
        intent.putExtra("key_flock_group_id", groupId);
        if (feedDetail != null) {
            intent.putExtra("key_flock_detail_feed", MessageNano.toByteArray(feedDetail));
        }
        if (tagInfo != null) {
            intent.putExtra("key_flock_feed_tag", MessageNano.toByteArray(tagInfo));
        }
        context.startActivity(intent);
    }

    public final void f(@NotNull Activity activity, @Nullable FlockRepeatType type, @Nullable Date endTimeDate, @Nullable Date activityStartTimeDate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, type, endTimeDate, activityStartTimeDate);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent();
        intent.putExtra("public_fragment_class", FlockRepeatSelectFragment.class.getName());
        intent.putExtra("key_flock_repeat_type", type);
        intent.putExtra("key_flock_repeat_end_time", endTimeDate);
        intent.putExtra("key_flock_activity_start_time", activityStartTimeDate);
        CompatPublicActivity.startForResult(activity, intent, (Class<? extends CompatPublicFragment>) FlockRepeatSelectFragment.class, 100);
    }

    public final void g(@NotNull Context context, long groupId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, Long.valueOf(groupId));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setClass(context, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", FlockFeedListFragment.class.getName());
        intent.putExtra("flock_feedlist_scene", FlockConstants$FlockListScene.TROOP);
        intent.putExtra("from_group_id", groupId);
        context.startActivity(intent);
    }

    public final void h(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setClass(context, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", FlockHomePageFragment.class.getName());
        context.startActivity(intent);
    }

    public final void i(@NotNull Context context, @Nullable List<b> feedDatas, @NotNull FlockConstants$FlockListScene scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, feedDatas, scene);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intent intent = new Intent();
        intent.setClass(context, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", FlockFeedListFragment.class.getName());
        intent.putExtra("flock_feedlist_scene", scene);
        if (scene == FlockConstants$FlockListScene.RECOM && feedDatas != null) {
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = feedDatas.iterator();
                while (it.hasNext()) {
                    byte[] byteArray = MessageNano.toByteArray((b) it.next());
                    if (byteArray != null) {
                        arrayList2.add(byteArray);
                    }
                }
                arrayList.addAll(arrayList2);
                Unit unit = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(intent.putExtra("key_flock_feeds", arrayList), "{\n                      \u2026 })\n                    }");
            } catch (Exception e16) {
                QLog.e("FlockLauncher", 1, e16, new Object[0]);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        context.startActivity(intent);
    }

    public final void j(@NotNull Context context, @NotNull FlockTopicAggregationInitBean initBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) initBean);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intent intent = new Intent();
        intent.setClass(context, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", FlockTopicAggregationFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", initBean);
        context.startActivity(intent);
    }

    public final void k(@NotNull Activity activity, int requestCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, requestCode);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent();
        intent.setClass(activity, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", FlockTopicListFragment.class.getName());
        activity.startActivityForResult(intent, requestCode);
    }

    public final void l(@NotNull Activity activity, int requestCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, requestCode);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent();
        intent.setClass(activity, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", FlockTopicSearchFragment.class.getName());
        activity.startActivityForResult(intent, requestCode);
    }

    public final void m(@NotNull Context context, @NotNull String url) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            return;
        }
        context.startActivity(new Intent(context, (Class<?>) QQBrowserActivity.class).putExtra("url", url));
    }
}
