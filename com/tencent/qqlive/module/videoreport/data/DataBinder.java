package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DataBinder {
    private static final IDataBinder DEFAULT_BINDER;
    private static final IDataBinder VIEW_BINDER;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class CommonDataBinder implements IDataBinder {
        CommonDataBinder() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.DataBinder.IDataBinder
        @Nullable
        public DataEntity getDataEntity(Object obj) {
            return GlobalDataStorage.getData(obj);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.DataBinder.IDataBinder
        public void setDataEntity(Object obj, DataEntity dataEntity) {
            GlobalDataStorage.setData(obj, dataEntity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface IDataBinder {
        @Nullable
        DataEntity getDataEntity(Object obj);

        void setDataEntity(Object obj, DataEntity dataEntity);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class ViewDataBinder implements IDataBinder {
        ViewDataBinder() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.DataBinder.IDataBinder
        @Nullable
        public DataEntity getDataEntity(Object obj) {
            if (!(obj instanceof View)) {
                return null;
            }
            try {
                Object tag = ((View) obj).getTag(R.id.ybh);
                if (tag instanceof DataEntity) {
                    return (DataEntity) tag;
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.DataBinder.IDataBinder
        public void setDataEntity(Object obj, DataEntity dataEntity) {
            if (!(obj instanceof View)) {
                return;
            }
            try {
                ((View) obj).setTag(R.id.ybh, dataEntity);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        VIEW_BINDER = new ViewDataBinder();
        DEFAULT_BINDER = new CommonDataBinder();
    }

    @Nullable
    public static DataEntity getDataEntity(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return with(obj).getDataEntity(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setDataEntity(@Nullable Object obj, @Nullable DataEntity dataEntity) {
        if (obj == null) {
            return;
        }
        with(obj).setDataEntity(obj, dataEntity);
    }

    @NonNull
    private static IDataBinder with(Object obj) {
        if (obj instanceof View) {
            return VIEW_BINDER;
        }
        return DEFAULT_BINDER;
    }
}
