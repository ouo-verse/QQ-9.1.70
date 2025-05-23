package com.tencent.mobileqq.winkpublish.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* loaded from: classes21.dex */
public interface IWinkPublishService extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.winkpublish.api.IWinkPublishService";

    void addExportTask(WinkExportTask winkExportTask) throws RemoteException;

    TaskInfo addTask(WinkPublishParams winkPublishParams) throws RemoteException;

    void addTaskListener(ITaskListener iTaskListener, int i3) throws RemoteException;

    void addTaskListener2(ITaskListener iTaskListener, int i3) throws RemoteException;

    void cancelExportTask(String str) throws RemoteException;

    void cancelTaskWithId(long j3, int i3) throws RemoteException;

    void dc5507Report(WinkDc5507ReportData winkDc5507ReportData, int i3) throws RemoteException;

    List<TaskInfo> getRunningTasks(int i3) throws RemoteException;

    boolean hasRunningTask(int i3) throws RemoteException;

    void init(int i3) throws RemoteException;

    void qualityReport(WinkPublishQualityReportData winkPublishQualityReportData, int i3) throws RemoteException;

    void removeTaskListener(ITaskListener iTaskListener, int i3) throws RemoteException;

    void resumeTaskWithId(long j3, int i3) throws RemoteException;

    boolean updateTaskWithId(long j3, WinkPublishParams winkPublishParams) throws RemoteException;

    /* loaded from: classes21.dex */
    public static abstract class Stub extends Binder implements IWinkPublishService {
        static final int TRANSACTION_addExportTask = 12;
        static final int TRANSACTION_addTask = 5;
        static final int TRANSACTION_addTaskListener = 9;
        static final int TRANSACTION_addTaskListener2 = 10;
        static final int TRANSACTION_cancelExportTask = 13;
        static final int TRANSACTION_cancelTaskWithId = 7;
        static final int TRANSACTION_dc5507Report = 14;
        static final int TRANSACTION_getRunningTasks = 4;
        static final int TRANSACTION_hasRunningTask = 2;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_qualityReport = 3;
        static final int TRANSACTION_removeTaskListener = 11;
        static final int TRANSACTION_resumeTaskWithId = 8;
        static final int TRANSACTION_updateTaskWithId = 6;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes21.dex */
        public static class Proxy implements IWinkPublishService {
            public static IWinkPublishService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void addExportTask(WinkExportTask winkExportTask) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    if (winkExportTask != null) {
                        obtain.writeInt(1);
                        winkExportTask.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addExportTask(winkExportTask);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public TaskInfo addTask(WinkPublishParams winkPublishParams) throws RemoteException {
                TaskInfo taskInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    if (winkPublishParams != null) {
                        obtain.writeInt(1);
                        winkPublishParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().addTask(winkPublishParams);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        taskInfo = TaskInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        taskInfo = null;
                    }
                    return taskInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void addTaskListener(ITaskListener iTaskListener, int i3) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    if (iTaskListener != null) {
                        iBinder = iTaskListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addTaskListener(iTaskListener, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void addTaskListener2(ITaskListener iTaskListener, int i3) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    if (iTaskListener != null) {
                        iBinder = iTaskListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addTaskListener2(iTaskListener, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void cancelExportTask(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelExportTask(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void cancelTaskWithId(long j3, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    obtain.writeLong(j3);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelTaskWithId(j3, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void dc5507Report(WinkDc5507ReportData winkDc5507ReportData, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    if (winkDc5507ReportData != null) {
                        obtain.writeInt(1);
                        winkDc5507ReportData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().dc5507Report(winkDc5507ReportData, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return IWinkPublishService.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public List<TaskInfo> getRunningTasks(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRunningTasks(i3);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(TaskInfo.CREATOR);
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public boolean hasRunningTask(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasRunningTask(i3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void init(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().init(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void qualityReport(WinkPublishQualityReportData winkPublishQualityReportData, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    if (winkPublishQualityReportData != null) {
                        obtain.writeInt(1);
                        winkPublishQualityReportData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().qualityReport(winkPublishQualityReportData, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void removeTaskListener(ITaskListener iTaskListener, int i3) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    if (iTaskListener != null) {
                        iBinder = iTaskListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeTaskListener(iTaskListener, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public void resumeTaskWithId(long j3, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    obtain.writeLong(j3);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resumeTaskWithId(j3, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
            public boolean updateTaskWithId(long j3, WinkPublishParams winkPublishParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWinkPublishService.DESCRIPTOR);
                    obtain.writeLong(j3);
                    boolean z16 = true;
                    if (winkPublishParams != null) {
                        obtain.writeInt(1);
                        winkPublishParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateTaskWithId(j3, winkPublishParams);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z16 = false;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IWinkPublishService.DESCRIPTOR);
        }

        public static IWinkPublishService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWinkPublishService.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IWinkPublishService)) {
                return (IWinkPublishService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IWinkPublishService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IWinkPublishService iWinkPublishService) {
            if (Proxy.sDefaultImpl == null) {
                if (iWinkPublishService != null) {
                    Proxy.sDefaultImpl = iWinkPublishService;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                WinkPublishQualityReportData winkPublishQualityReportData = null;
                WinkDc5507ReportData winkDc5507ReportData = null;
                WinkExportTask winkExportTask = null;
                WinkPublishParams winkPublishParams = null;
                WinkPublishParams winkPublishParams2 = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        init(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        boolean hasRunningTask = hasRunningTask(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(hasRunningTask ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            winkPublishQualityReportData = WinkPublishQualityReportData.INSTANCE.createFromParcel(parcel);
                        }
                        qualityReport(winkPublishQualityReportData, parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        List<TaskInfo> runningTasks = getRunningTasks(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(runningTasks);
                        return true;
                    case 5:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            winkPublishParams2 = WinkPublishParams.CREATOR.createFromParcel(parcel);
                        }
                        TaskInfo addTask = addTask(winkPublishParams2);
                        parcel2.writeNoException();
                        if (addTask != null) {
                            parcel2.writeInt(1);
                            addTask.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        long readLong = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            winkPublishParams = WinkPublishParams.CREATOR.createFromParcel(parcel);
                        }
                        boolean updateTaskWithId = updateTaskWithId(readLong, winkPublishParams);
                        parcel2.writeNoException();
                        parcel2.writeInt(updateTaskWithId ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        cancelTaskWithId(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        resumeTaskWithId(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        addTaskListener(ITaskListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        addTaskListener2(ITaskListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        removeTaskListener(ITaskListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            winkExportTask = WinkExportTask.CREATOR.createFromParcel(parcel);
                        }
                        addExportTask(winkExportTask);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        cancelExportTask(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(IWinkPublishService.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            winkDc5507ReportData = WinkDc5507ReportData.INSTANCE.createFromParcel(parcel);
                        }
                        dc5507Report(winkDc5507ReportData, parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(IWinkPublishService.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes21.dex */
    public static class Default implements IWinkPublishService {
        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public TaskInfo addTask(WinkPublishParams winkPublishParams) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public List<TaskInfo> getRunningTasks(int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public boolean hasRunningTask(int i3) throws RemoteException {
            return false;
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public boolean updateTaskWithId(long j3, WinkPublishParams winkPublishParams) throws RemoteException {
            return false;
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void addExportTask(WinkExportTask winkExportTask) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void cancelExportTask(String str) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void init(int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void addTaskListener(ITaskListener iTaskListener, int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void addTaskListener2(ITaskListener iTaskListener, int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void cancelTaskWithId(long j3, int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void dc5507Report(WinkDc5507ReportData winkDc5507ReportData, int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void qualityReport(WinkPublishQualityReportData winkPublishQualityReportData, int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void removeTaskListener(ITaskListener iTaskListener, int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
        public void resumeTaskWithId(long j3, int i3) throws RemoteException {
        }
    }
}
