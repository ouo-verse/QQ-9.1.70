package com.tencent.mobileqq.wink.preview.viewmodel;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.wink.preview.WinkPhotoWallHandler;
import com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource;
import com.tencent.mobileqq.wink.preview.datasource.WinkPhotoWallShareRepo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ*\u0010\b\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\"\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0014\u001a\u00020\rJ\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/c;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "", "", "photoUrls", "startIndex", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource;", "S1", "", "Z1", "", "onCleared", "type", "isSuccess", "", "data", "onUpdate", "i2", "getLogTag", "Lcom/tencent/mobileqq/wink/preview/WinkPhotoWallHandler;", "L", "Lcom/tencent/mobileqq/wink/preview/WinkPhotoWallHandler;", "photoWallHandler", "Lcom/tencent/common/app/AppInterface;", "M", "Lcom/tencent/common/app/AppInterface;", "appInterface", "<init>", "()V", "N", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends WinkBasePreviewShareViewModel implements BusinessObserver {

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private WinkPhotoWallHandler photoWallHandler;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final AppInterface appInterface;

    public c() {
        AppInterface a16 = com.tencent.mobileqq.wink.b.a();
        Intrinsics.checkNotNullExpressionValue(a16, "getAppInterface()");
        this.appInterface = a16;
        com.tencent.mobileqq.wink.b.a().addDefaultObservers(this);
    }

    private final String h2(Map<Integer, String> photoUrls, int startIndex) {
        String str = null;
        for (int i3 = 1; TextUtils.isEmpty(str) && i3 < 5; i3++) {
            str = photoUrls.get(Integer.valueOf((startIndex + i3) % 5));
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(c this$0, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        WinkPhotoWallHandler winkPhotoWallHandler = this$0.photoWallHandler;
        Intrinsics.checkNotNull(winkPhotoWallHandler);
        winkPhotoWallHandler.getQzonePhotoWall(uin, "");
    }

    @Override // com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel
    @NotNull
    public WinkBasePreviewShareDataSource S1() {
        return WinkPhotoWallShareRepo.f325392c;
    }

    @Override // com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel
    public boolean Z1() {
        return false;
    }

    @Override // com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkPhotoWallSharePreviewViewModel";
    }

    public final void i2() {
        if (this.photoWallHandler == null) {
            this.photoWallHandler = (WinkPhotoWallHandler) this.appInterface.getBusinessHandler(WinkPhotoWallHandler.class.getName());
        }
        final String currentAccountUin = this.appInterface.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appInterface.currentAccountUin");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.wink.preview.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                c.j2(c.this, currentAccountUin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        com.tencent.mobileqq.wink.b.a().removeObserver(this);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        String str;
        if (type != 1) {
            return;
        }
        if (!isSuccess) {
            w53.b.c("WinkPhotoWallSharePreviewViewModel", "[onUpdate] no rsp!");
            return;
        }
        if (data != null) {
            try {
                Object[] objArr = (Object[]) data;
                Object obj = objArr[1];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp");
                mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar = (mobile_sub_get_photo_wall_rsp) obj;
                Object obj2 = objArr[2];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                if (!Intrinsics.areEqual((String) obj2, this.appInterface.getCurrentAccountUin())) {
                    w53.b.c("WinkPhotoWallSharePreviewViewModel", "[onUpdate] invalid uin!");
                    return;
                }
                ArrayList<PhotoWall> arrayList = mobile_sub_get_photo_wall_rspVar.vecUrls;
                if (arrayList != null) {
                    if (arrayList.size() == 0) {
                        w53.b.c("WinkPhotoWallSharePreviewViewModel", "[onUpdate] empty photos urls!");
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (PhotoWall photoWall : arrayList) {
                        Map<Integer, String> map = photoWall.photoUrls;
                        if (map != null) {
                            str = map.get(1);
                        } else {
                            str = null;
                        }
                        if (TextUtils.isEmpty(str)) {
                            Map<Integer, String> map2 = photoWall.photoUrls;
                            Intrinsics.checkNotNullExpressionValue(map2, "it.photoUrls");
                            str = h2(map2, 1);
                        }
                        Intrinsics.checkNotNull(str);
                        arrayList2.add(str);
                    }
                    e2(arrayList2);
                }
            } catch (ClassCastException e16) {
                w53.b.d("WinkPhotoWallSharePreviewViewModel", "invalid rsp", e16);
            }
        }
    }
}
