package ck;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import com.qzone.reborn.intimate.layer.fragment.QZIntimateAlbumDetailLayerFragment;
import com.qzone.reborn.intimate.layer.fragment.QZIntimateAlbumFeedLayerFragment;
import com.qzone.reborn.intimate.layer.fragment.QZIntimateFeedLayerFragment;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Lck/a;", "Lho/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lsj/d;", "layerLaunchBean", "", "c", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements ho.a {
    public final void a(Activity activity, sj.d layerLaunchBean) {
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_init_data_list", layerLaunchBean.A());
            if (layerLaunchBean.getAlbumDetailInitBean() != null) {
                bundle.putSerializable("key_album_detail_init_bean", layerLaunchBean.getAlbumDetailInitBean());
            }
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
            bundle.putString("key_attach_info", layerLaunchBean.getRightAttachInfo());
            bundle.putString("key_space_id", layerLaunchBean.getSpaceId());
            bundle.putInt("key_space_type", layerLaunchBean.getSpaceType());
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QZIntimateAlbumDetailLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        RFWLog.d("QZoneIntimateGalleryNativeLauncher", RFWLog.USR, "launchFeedGalleryLayer fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }

    public final void b(Activity activity, sj.d layerLaunchBean) {
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_init_data_list", layerLaunchBean.A());
            bundle.putString("key_space_id", layerLaunchBean.getSpaceId());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
            bundle.putString("key_feed_id", layerLaunchBean.getFeedId());
            bundle.putInt("key_space_type", layerLaunchBean.getSpaceType());
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QZIntimateAlbumFeedLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        RFWLog.d("QZoneIntimateGalleryNativeLauncher", RFWLog.USR, "launchFeedGalleryLayer fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }

    public final void c(Activity activity, sj.d layerLaunchBean) {
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_init_data_list", layerLaunchBean.A());
            bundle.putString("key_space_id", layerLaunchBean.getSpaceId());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
            bundle.putString("key_feed_id", layerLaunchBean.getFeedId());
            bundle.putInt("key_space_type", layerLaunchBean.getSpaceType());
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QZIntimateFeedLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        RFWLog.d("QZoneIntimateGalleryNativeLauncher", RFWLog.USR, "launchFeedGalleryLayer fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }
}
