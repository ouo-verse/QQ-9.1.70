package oi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import ci.i;
import com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumDetailLayerFragment;
import com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumFeedLayerFragment;
import com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLimitedLayerFragment;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Loi/b;", "Lho/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lci/i;", "layerLaunchBean", "", "b", "a", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements ho.a {
    public final void a(Activity activity, i layerLaunchBean) {
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_init_data_list", layerLaunchBean.C());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
            bundle.putString("key_feed_id", layerLaunchBean.getFeedId());
            bundle.putString(MiniAppTranRoomIdServlet.KEY_GROUP_ID, layerLaunchBean.getGroupId());
            bundle.putString("key_batch_id", layerLaunchBean.getBatchId());
            if (layerLaunchBean.getAlbumDetailInitBean() != null) {
                bundle.putSerializable("key_album_detail_init_bean", layerLaunchBean.getAlbumDetailInitBean());
            }
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, GroupAlbumDetailLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        RFWLog.d("GroupAlbumGalleryNativeLauncher", RFWLog.USR, "launchAlbumDetailGallery fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }

    public final void b(Activity activity, i layerLaunchBean) {
        Class cls;
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_init_data_list", layerLaunchBean.C());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
            bundle.putString("key_feed_id", layerLaunchBean.getFeedId());
            bundle.putString(MiniAppTranRoomIdServlet.KEY_GROUP_ID, layerLaunchBean.getGroupId());
            bundle.putString("key_batch_id", layerLaunchBean.getBatchId());
            bundle.putBoolean("key_is_limited", layerLaunchBean.getDisallowInteract());
            bundle.putBoolean("key_is_detail_layer", layerLaunchBean.getFromFeedDetail());
            if (layerLaunchBean.getDisallowInteract()) {
                cls = GroupAlbumLimitedLayerFragment.class;
            } else {
                cls = GroupAlbumFeedLayerFragment.class;
            }
            Class cls2 = cls;
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, cls2, bundle, 0, 128, null);
            return;
        }
        RFWLog.d("GroupAlbumGalleryNativeLauncher", RFWLog.USR, "launchFeedGalleryLayer fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }

    public final void c(Activity activity, i layerLaunchBean) {
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_init_data_list", layerLaunchBean.C());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, false);
            bundle.putBoolean("key_is_limited", true);
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, GroupAlbumLimitedLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        RFWLog.d("GroupAlbumGalleryNativeLauncher", RFWLog.USR, "launchReshipItemGallery fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }
}
