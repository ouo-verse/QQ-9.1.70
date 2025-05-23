package com.qzone.common.activities.base;

import com.qzone.album.business.editalbum.QZoneNewAlbumActivity;
import com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity;
import com.qzone.album.ui.activity.QZonePersonalAlbumAnswerActivity;
import com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity;
import com.qzone.album.ui.activity.QzDynamicVideoEditActivity;
import com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation;
import com.qzone.business.plusunion.ui.QZoneAppIntroActivity;
import com.qzone.common.activities.QzoneDialogActivity;
import com.qzone.cover.ui.activity.QZoneBrowserActivity;
import com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity;
import com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity;
import com.qzone.feed.ui.activity.QZoneMyFeedActivity;
import com.qzone.homepage.ui.activity.ApplyAccessActivity;
import com.qzone.misc.web.QZoneTranslucentActivity;
import com.qzone.misc.web.QZoneTranslucentActivity2;
import com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity;
import com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting;
import com.qzone.preview.QZoneEncourageAdvActivity;
import com.qzone.publish.ui.activity.QZonePublishQueueAcitvity;
import com.qzone.publish.ui.activity.QZoneUploadQualityActivity;
import com.qzone.publish.ui.activity.QzonePublishTimeSettingActivity;
import com.qzone.reborn.albumx.qzone.fragment.QZoneAlbumxLocalPhotoRecommendMediaListFragment;
import com.qzone.reborn.albumx.qzone.fragment.QZoneLocalPhotoRecommendStandaloneFragment;
import com.qzone.report.QZonePerfReporter;
import com.qzone.video.activity.VideoViewActivity;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class bw {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, a> f45467a;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        BaseFragment a();
    }

    public static BaseFragment a(String str) {
        if (f45467a == null) {
            b();
        }
        a aVar = f45467a.get(str);
        if (aVar == null) {
            w5.b.g("QzoneFragmentCreator", 1, "QzoneFragmentCreator is null, ensure fragment name" + str);
            return null;
        }
        QZonePerfReporter.f59697a.j("page", "[Fragment]" + str);
        return aVar.a();
    }

    private static void b() {
        HashMap hashMap = new HashMap();
        f45467a = hashMap;
        hashMap.put("com.qzone.publish.ui.activity.QZoneUploadQualityActivity", new a() { // from class: com.qzone.common.activities.base.ay
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneUploadQualityActivity();
            }
        });
        f45467a.put(QZoneHelper.PERSONAL_ALBUM_SELECT, new a() { // from class: com.qzone.common.activities.base.ba
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZonePersonalAlbumSelectActivity();
            }
        });
        f45467a.put("com.qzone.album.business.editalbum.QZoneNewAlbumActivity", new a() { // from class: com.qzone.common.activities.base.bf
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneNewAlbumActivity();
            }
        });
        f45467a.put(QZoneHelper.MOOD_SELECT_LOCATION, new a() { // from class: com.qzone.common.activities.base.bg
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneMoodSelectLocation();
            }
        });
        f45467a.put(QZoneHelper.PAGE_MY_FEED, new a() { // from class: com.qzone.common.activities.base.bh
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneMyFeedActivity();
            }
        });
        f45467a.put(QZoneHelper.PAGE_DYNAMIC_VIDEO_EDIT, new a() { // from class: com.qzone.common.activities.base.bi
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QzDynamicVideoEditActivity();
            }
        });
        f45467a.put("com.qzone.business.plusunion.ui.QZoneAppIntroActivity", new a() { // from class: com.qzone.common.activities.base.bk
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneAppIntroActivity();
            }
        });
        f45467a.put(QZoneHelper.PAGE_ENCOURAGE_ADV, new a() { // from class: com.qzone.common.activities.base.bl
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneEncourageAdvActivity();
            }
        });
        f45467a.put(QZoneHelper.PAGE_VIDEO_VIEW, new a() { // from class: com.qzone.common.activities.base.bm
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new VideoViewActivity();
            }
        });
        f45467a.put("com.qzone.homepage.ui.activity.ApplyAccessActivity", new a() { // from class: com.qzone.common.activities.base.bn
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new ApplyAccessActivity();
            }
        });
        f45467a.put(QZoneHelper.PAGE_FLASH_NICK_NAME_SETTING, new a() { // from class: com.qzone.common.activities.base.bj
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneFlashNickNameSetting();
            }
        });
        f45467a.put("com.qzone.publish.ui.activity.QZonePublishQueueAcitvity", new a() { // from class: com.qzone.common.activities.base.bo
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZonePublishQueueAcitvity();
            }
        });
        f45467a.put("com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity", new a() { // from class: com.qzone.common.activities.base.bp
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneSharingOwnersListActivity();
            }
        });
        f45467a.put(QZoneHelper.SINGLE_PERMISSION_SETTING, new a() { // from class: com.qzone.common.activities.base.bq
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneSinglePermissionSettingActivity();
            }
        });
        f45467a.put("com.qzone.publish.ui.activity.QzonePublishTimeSettingActivity", new a() { // from class: com.qzone.common.activities.base.br
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QzonePublishTimeSettingActivity();
            }
        });
        f45467a.put("com.qzone.album.ui.activity.QZonePersonalAlbumAnswerActivity", new a() { // from class: com.qzone.common.activities.base.bs
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZonePersonalAlbumAnswerActivity();
            }
        });
        f45467a.put(QZoneHelper.VIDEO_COVER_PREVIEW_ACTVITY, new a() { // from class: com.qzone.common.activities.base.bt
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QzoneVideoCoverPreviewActivity();
            }
        });
        f45467a.put(QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY, new a() { // from class: com.qzone.common.activities.base.bu
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneTranslucentActivity();
            }
        });
        f45467a.put(QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY2, new a() { // from class: com.qzone.common.activities.base.bv
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneTranslucentActivity2();
            }
        });
        f45467a.put(QZoneHelper.PAGE_DIALOG, new a() { // from class: com.qzone.common.activities.base.az
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QzoneDialogActivity();
            }
        });
        f45467a.put(QZoneHelper.PAGE_BROWSER, new a() { // from class: com.qzone.common.activities.base.bb
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneBrowserActivity();
            }
        });
        f45467a.put("com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity", new a() { // from class: com.qzone.common.activities.base.bc
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneCoverSetCustomActivity();
            }
        });
        f45467a.put("com.qzone.reborn.albumx.qzone.fragment.QZoneAlbumxLocalPhotoRecommendMediaListFragment", new a() { // from class: com.qzone.common.activities.base.bd
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneAlbumxLocalPhotoRecommendMediaListFragment();
            }
        });
        f45467a.put("com.qzone.reborn.albumx.qzone.fragment.QZoneLocalPhotoRecommendStandaloneFragment", new a() { // from class: com.qzone.common.activities.base.be
            @Override // com.qzone.common.activities.base.bw.a
            public final BaseFragment a() {
                return new QZoneLocalPhotoRecommendStandaloneFragment();
            }
        });
        f45467a.putAll(at.a());
    }

    public static boolean c(String str) {
        if (f45467a == null) {
            b();
        }
        return f45467a.containsKey(str);
    }
}
