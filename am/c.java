package am;

import FileUpload.MarkUinInfoBeforeUpload;
import android.app.Activity;
import android.os.Bundle;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.reborn.base.k;
import com.qzone.reborn.layer.event.QZoneUploadDeleteMediaEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.model.FaceData;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e`\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lam/c;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/layer/event/QZoneUploadDeleteMediaEvent;", "event", "", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "", com.tencent.luggage.wxa.c8.c.G, "", "path", "F9", "Lcom/qzone/common/activities/base/PhotoActivity;", "d", "Lcom/qzone/common/activities/base/PhotoActivity;", "photoActivity", "<init>", "(Lcom/qzone/common/activities/base/PhotoActivity;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public abstract class c extends k implements SimpleEventReceiver<QZoneUploadDeleteMediaEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final PhotoActivity photoActivity;

    public c(PhotoActivity photoActivity) {
        Intrinsics.checkNotNullParameter(photoActivity, "photoActivity");
        this.photoActivity = photoActivity;
    }

    private final void D9(QZoneUploadDeleteMediaEvent event) {
        PhotoActivity photoActivity = this.photoActivity;
        final String localPath = event.getLocalPath();
        final int position = event.getPosition();
        photoActivity.Yk(event.getPosition());
        if (localPath.length() > 0) {
            HashMap<String, ShuoshuoVideoInfo> hashMap = photoActivity.Z;
            if (hashMap != null && hashMap.size() > 0) {
                photoActivity.Z.remove(localPath);
            }
            HashMap<String, MarkUinInfoBeforeUpload> hashMap2 = photoActivity.U1;
            if (hashMap2 != null && hashMap2.containsKey(localPath)) {
                photoActivity.U1.remove(localPath);
            }
            HashMap<String, Boolean> hashMap3 = photoActivity.V1;
            if (hashMap3 != null && hashMap3.containsKey(localPath)) {
                photoActivity.V1.remove(localPath);
            }
            HashMap<String, ArrayList<FaceData>> hashMap4 = photoActivity.X1;
            if (hashMap4 != null && hashMap4.containsKey(localPath)) {
                photoActivity.X1.remove(localPath);
            }
            HashMap<String, Boolean> hashMap5 = photoActivity.W1;
            if (hashMap5 != null && hashMap5.containsKey(localPath)) {
                photoActivity.W1.remove(localPath);
            }
        }
        photoActivity.P.n1(position, new Runnable() { // from class: am.b
            @Override // java.lang.Runnable
            public final void run() {
                c.E9(c.this, position, localPath);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(c this$0, int i3, String path) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        this$0.F9(i3, path);
    }

    public abstract void F9(int pos, String path);

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneUploadDeleteMediaEvent>> getEventClass() {
        ArrayList<Class<QZoneUploadDeleteMediaEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneUploadDeleteMediaEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneUploadDeleteMediaEvent) {
            D9((QZoneUploadDeleteMediaEvent) event);
        }
    }
}
