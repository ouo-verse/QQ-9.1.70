package cooperation.qqcircle.ipc;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.ipc.IBitmapBinder;
import cooperation.qqcircle.ipc.action.FollowPublishAccountAction;
import cooperation.qqcircle.ipc.action.IQCircleIPCAction;
import cooperation.qqcircle.ipc.action.PreLoadHippyJsBundleAction;
import cooperation.qqcircle.ipc.action.SchemaJumpToQQECommercePageWithCallBackAction;
import cooperation.qqcircle.utils.QFSGalleryEntranceRedPointInfoUtil;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import uq3.c;

/* loaded from: classes28.dex */
public class QCircleIPCModule extends QIPCModule {
    private static final String TAG = "QCircleIPCModule";
    private Map<String, Class<? extends IQCircleIPCAction>> actionMap;

    /* loaded from: classes28.dex */
    public static class BitmapBinder extends Binder {
        private Bitmap mBitmap;

        public BitmapBinder(Bitmap bitmap) {
            this.mBitmap = bitmap;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static class InstanceHolder {
        static final QCircleIPCModule INSTANCE = new QCircleIPCModule(IQCircleIPCApi.MODULE_NAME);

        InstanceHolder() {
        }
    }

    public QCircleIPCModule(String str) {
        super(str);
        this.actionMap = new HashMap();
        initActionMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String friendsToJson(List<Friends> list, List<Friends> list2) {
        if (list == null && list2 == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        JsonArray jsonArray = new JsonArray();
        if (list != null) {
            for (Friends friends : list) {
                if (friends != null && !TextUtils.isEmpty(friends.uin)) {
                    hashSet.add(friends.uin);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("uin", friends.uin);
                    jsonObject.addProperty("remark", friends.remark);
                    jsonObject.addProperty("name", friends.name);
                    jsonArray.add(jsonObject);
                }
            }
        }
        if (list2 != null) {
            for (Friends friends2 : list2) {
                if (friends2 != null && !TextUtils.isEmpty(friends2.uin) && !hashSet.contains(friends2.uin)) {
                    hashSet.add(friends2.uin);
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("uin", friends2.uin);
                    jsonObject2.addProperty("remark", friends2.remark);
                    jsonObject2.addProperty("name", friends2.name);
                    jsonArray.add(jsonObject2);
                    if (hashSet.size() == 10) {
                        return jsonArray.toString();
                    }
                }
            }
        }
        return jsonArray.toString();
    }

    public static QCircleIPCModule getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void handleGetFriends(final int i3) {
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getRecentFriendsAsync(10, true, null, new Consumer<List<Friends>>() { // from class: cooperation.qqcircle.ipc.QCircleIPCModule.3
            @Override // androidx.core.util.Consumer
            public void accept(final List<Friends> list) {
                if (list != null && list.size() == 10) {
                    Bundle bundle = new Bundle();
                    bundle.putString(QQWinkConstants.PUBLISH_KEY_FRIENDSLIST, QCircleIPCModule.this.friendsToJson(list, null));
                    QCircleIPCModule.getInstance().callbackResult(i3, EIPCResult.createSuccessResult(bundle));
                    return;
                }
                ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getGroupFriendsMapAsync(10, true, null, new Consumer<Map<Groups, List<Friends>>>() { // from class: cooperation.qqcircle.ipc.QCircleIPCModule.3.1
                    @Override // androidx.core.util.Consumer
                    public void accept(Map<Groups, List<Friends>> map) {
                        ArrayList arrayList = new ArrayList();
                        if (!RFSafeMapUtils.isEmpty(map)) {
                            for (List<Friends> list2 : map.values()) {
                                if (!RFSafeListUtils.isEmpty(list2)) {
                                    arrayList.addAll(list2);
                                }
                            }
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(QQWinkConstants.PUBLISH_KEY_FRIENDSLIST, QCircleIPCModule.this.friendsToJson(list, arrayList));
                        QCircleIPCModule.getInstance().callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
                    }
                });
            }
        });
    }

    private void initActionMap() {
        this.actionMap.put(IQCircleIPCApi.ACTION_SCHEMA_JUMP_TO_EC_PAGE, SchemaJumpToQQECommercePageWithCallBackAction.class);
        this.actionMap.put(IQCircleIPCApi.ACTION_PRELOAD_HIPPY_JS_BUNDLE, PreLoadHippyJsBundleAction.class);
        this.actionMap.put(IQCircleIPCApi.ACTION_FOLLOW_PUBLISH_ACCOUNT, FollowPublishAccountAction.class);
    }

    private void updateGalleryRedPointInfo() {
        QFSGalleryEntranceRedPointInfoUtil.updateGalleryEntranceRedPointInfo(QCircleHostRedPointHelper.getGalleryRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE, 116001));
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, final int i3) {
        final Bitmap bitmap = null;
        if (IQCircleIPCApi.ACTION_GET_AVATAR.equals(str)) {
            bundle.setClassLoader(ToServiceMsg.class.getClassLoader());
            QCircleHandler.getQCircleHandler().sendIPCHeadRequest((ToServiceMsg) bundle.getParcelable(IQCircleIPCApi.BUNDLE_KEY_AVATAR_REQUEST), new QCircleHandler.IPCAvatarListener() { // from class: cooperation.qqcircle.ipc.QCircleIPCModule.1
                @Override // com.tencent.biz.qcircleshadow.handler.QCircleHandler.IPCAvatarListener
                public void handlerAvatarReceive(Bundle bundle2) {
                    QCircleIPCModule.getInstance().callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
                }
            });
        } else {
            if (IQCircleIPCApi.ACTION_GET_HEAD_BITMAP.equals(str)) {
                Bundle bundle2 = new Bundle();
                bundle2.setClassLoader(getClass().getClassLoader());
                String string = bundle.getString(IQCircleIPCApi.BUNDLE_KEY_TARGET_UIN);
                Drawable headDrawable = HostFaceUtils.getHeadDrawable(string, bundle.getInt(IQCircleIPCApi.BUNDLE_KEY_TARGET_HEAD_TYPE));
                QLog.i(TAG, 1, "HostFaceUtils.getHeadDrawable uin:" + string + " faceDrawable:" + headDrawable);
                if (headDrawable instanceof FaceDrawable) {
                    bitmap = ((FaceDrawable) headDrawable).getLoadedBitmap();
                    QLog.i(TAG, 1, "HostFaceUtils.getHeadDrawable uin:" + string + " FaceDrawable:" + bitmap);
                } else if (headDrawable instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) headDrawable).getBitmap();
                    QLog.i(TAG, 1, "HostFaceUtils.getHeadDrawable uin:" + string + " BitmapDrawable:" + bitmap);
                } else {
                    QLog.i(TAG, 1, "HostFaceUtils.getHeadDrawable uin:" + string + " Drawable:null");
                }
                bundle2.putBinder(IQCircleIPCApi.BUNDLE_KEY_IMAGE_BITMAP, new IBitmapBinder.Stub() { // from class: cooperation.qqcircle.ipc.QCircleIPCModule.2
                    @Override // cooperation.qqcircle.ipc.IBitmapBinder
                    public Bitmap getBitmap() throws RemoteException {
                        return bitmap;
                    }
                });
                return EIPCResult.createSuccessResult(bundle2);
            }
            if (IQCircleIPCApi.ACTION_SETUP_QCIRCLE_BOTTOM_TAB_MODE.equals(str)) {
                QCircleHostUtil.setQCircleToBottomTab();
            } else if (IQCircleIPCApi.ACTION_OPEN_QCIRCLE_FOR_QZONE.equals(str)) {
                if (!c.t6()) {
                    ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).preloadTabInfo();
                }
            } else if (IQCircleIPCApi.ACTION_SET_WINK_EXPORT_SCENES_FOR_QZONE.equals(str)) {
                ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).setScene("QZONE");
            } else if (IQCircleIPCApi.ACTION_READ_GALLERY_RED_POINT_INFO.equals(str)) {
                updateGalleryRedPointInfo();
            } else if (IQCircleIPCApi.ACTION_GET_FRIENDS.equals(str)) {
                handleGetFriends(i3);
            } else if (this.actionMap.containsKey(str)) {
                try {
                    return this.actionMap.get(str).newInstance().doAction(bundle, i3);
                } catch (IllegalAccessException | InstantiationException e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                }
            } else if (IQCircleIPCApi.ACTION_ADD_PUBLISH_TASK.equals(str)) {
                getInstance().callbackResult(i3, EIPCResult.createSuccessResult(new Bundle()));
                WinkPublishHelper2.INSTANCE.addTask(bundle);
            } else if (IQCircleIPCApi.ACTION_ADD_EXPORT_TASK.equals(str)) {
                getInstance().callbackResult(i3, EIPCResult.createSuccessResult(new Bundle()));
                WinkPublishHelper2.INSTANCE.addExportTask(null);
            } else if (IQCircleIPCApi.ACTION_DOWNLOAD_WINK_NEW_ALBUM_RES.equals(str)) {
                ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).fetchWinkNewAlbumRes(bundle);
            } else if (IQCircleIPCApi.ACTION_GET_WINK_NEW_ALBUM_RES.equals(str)) {
                ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).asyncGetWinkNewAlbumRes(this, i3);
            } else if (IQCircleIPCApi.ACTION_DOWNLOAD_WINK_NEW_ALBUM_TEXT_RES.equals(str)) {
                ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).fetchWinkNewAlbumTextRes(bundle);
            } else if (IQCircleIPCApi.ACTION_GET_WINK_NEW_ALBUM_TEXT_RES.equals(str)) {
                ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).asyncGetWinkNewAlbumTextRes(this, i3);
            }
        }
        return null;
    }
}
