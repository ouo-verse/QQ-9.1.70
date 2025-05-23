package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import com.qzone.reborn.groupalbum.event.GroupAlbumFeedExposureEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000b\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00140\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0014`\bH\u0016R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/t;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "D9", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "feedId", "groupId", "E9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "waitExposureSet", "e", "hasExposuredSet", "f", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class t extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private HashSet<String> waitExposureSet = new HashSet<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HashSet<String> hasExposuredSet = new HashSet<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    private final void D9() {
        if (this.waitExposureSet.isEmpty()) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.waitExposureSet) {
            arrayList.add(str);
            this.hasExposuredSet.add(str);
        }
        this.waitExposureSet.clear();
        String str2 = this.groupId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupId");
            str2 = null;
        }
        E9(arrayList, str2);
    }

    private final void E9(ArrayList<String> feedId, String groupId) {
        ki.p.f412499a.b(groupId, feedId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(t this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        Bundle extras;
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.waitExposureSet.clear();
        this.hasExposuredSet.clear();
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        if (serializable instanceof GroupAlbumInitBean) {
            this.groupId = ((GroupAlbumInitBean) serializable).getGroupId();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.feed.s
            @Override // java.lang.Runnable
            public final void run() {
                t.F9(t.this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof GroupAlbumFeedExposureEvent) {
            GroupAlbumFeedExposureEvent groupAlbumFeedExposureEvent = (GroupAlbumFeedExposureEvent) event;
            Iterator<T> it = groupAlbumFeedExposureEvent.getData().iterator();
            while (it.hasNext()) {
                String str = ((BusinessFeedData) it.next()).cellLikeInfo.likeKey;
                if (!this.hasExposuredSet.contains(str)) {
                    this.waitExposureSet.add(str);
                }
            }
            if (groupAlbumFeedExposureEvent.getFrom() == 2) {
                D9();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumFeedExposureEvent.class);
        return arrayListOf;
    }
}
