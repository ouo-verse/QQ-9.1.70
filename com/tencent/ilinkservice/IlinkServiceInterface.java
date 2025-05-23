package com.tencent.ilinkservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.ilinkservice.IlinkServiceProto;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkServiceInterface {
    private static IIlinkLoadDelegate sLoadDelegate = new IIlinkLoadDelegate() { // from class: com.tencent.ilinkservice.IlinkServiceInterface.1
        @Override // com.tencent.ilinkservice.IlinkServiceInterface.IIlinkLoadDelegate
        public void loadLibrary(String str) throws UnsatisfiedLinkError {
            System.loadLibrary(str);
        }
    };
    private final String TAG;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IIlinkLoadDelegate {
        void loadLibrary(String str) throws UnsatisfiedLinkError;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SingletonLoader {
        private static IlinkServiceInterface singletonStatic = new IlinkServiceInterface();

        SingletonLoader() {
        }
    }

    public static IlinkLiveServiceInterface getIlinkLiveInstance() {
        return IlinkLiveServiceImpl.getInstance();
    }

    public static IIlinkLoadDelegate getIlinkLoadDelegate() {
        return sLoadDelegate;
    }

    public static IlinkServiceInterface getInstance() {
        return SingletonLoader.singletonStatic;
    }

    public static void setIlinkLoadDelegate(IIlinkLoadDelegate iIlinkLoadDelegate) {
        if (iIlinkLoadDelegate == null) {
            return;
        }
        sLoadDelegate = iIlinkLoadDelegate;
    }

    public boolean cloneMultiProcessTdiSession(String str, String str2) {
        if (str.isEmpty()) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "appid should not be empty!!!!", new Object[0]);
            return false;
        }
        if (!IlinkServiceImpl.getInstance().isDeviceLoginSuccess()) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "Device not login yet can not create tdi session!!!!", new Object[0]);
            return false;
        }
        if (IlinkServiceImpl.getInstance().isAppidTdiSessionExit(str)) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "tdi session already exit could not recreate destroy first!!!!", new Object[0]);
            return false;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "cloneMultiProcessTdiSession", new Class[]{String.class, String.class}, str, str2);
        return true;
    }

    public IlinkDeviceInterface createDeviceInterface() {
        return IlinkServiceImpl.getInstance().createDeviceInterface();
    }

    public IlinkImSessionInterface createImSession(String str) {
        if (str.isEmpty()) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "appid should not be empty!!!!", new Object[0]);
            return null;
        }
        if (!IlinkServiceImpl.getInstance().isDeviceLoginSuccess()) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "Device not login yet can not create tdi session!!!!", new Object[0]);
            return null;
        }
        if (IlinkServiceImpl.getInstance().isAppidImSessionExit(str)) {
            return IlinkServiceImpl.getInstance().addImSession(str);
        }
        IlinkImSessionImpl addImSession = IlinkServiceImpl.getInstance().addImSession(str);
        byte[] byteArray = AidlProto.createImSession.newBuilder().setAppid(str).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "createImSession", byteArray);
        return addImSession;
    }

    public IlinkTdiSessionInterface createTdiSession(String str) {
        if (str.isEmpty()) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "appid should not be empty!!!!", new Object[0]);
            return null;
        }
        if (!IlinkServiceImpl.getInstance().isDeviceLoginSuccess()) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "Device not login yet can not create tdi session!!!!", new Object[0]);
            return null;
        }
        if (IlinkServiceImpl.getInstance().isAppidTdiSessionExit(str)) {
            return IlinkServiceImpl.getInstance().addTdiSession(str);
        }
        IlinkTdiSessionImpl addTdiSession = IlinkServiceImpl.getInstance().addTdiSession(str);
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "createTdiSession", new Class[]{String.class}, str);
        return addTdiSession;
    }

    public void destroyDeviceInterface(IlinkDeviceInterface ilinkDeviceInterface) {
        if (ilinkDeviceInterface != null && (ilinkDeviceInterface instanceof IlinkDeviceImpl)) {
            IlinkServiceImpl.getInstance().destroyDeviceInterface((IlinkDeviceImpl) ilinkDeviceInterface);
        } else {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "dev should not be null!!!!", new Object[0]);
        }
    }

    public void destroyImSession(IlinkImSessionInterface ilinkImSessionInterface) {
        if (ilinkImSessionInterface != null && (ilinkImSessionInterface instanceof IlinkImSessionImpl)) {
            IlinkImSessionImpl ilinkImSessionImpl = (IlinkImSessionImpl) ilinkImSessionInterface;
            if (IlinkServiceImpl.getInstance().isImSessionValid(ilinkImSessionImpl)) {
                String appid = ilinkImSessionImpl.getAppid();
                IlinkServiceImpl.getInstance().removeImSession(appid);
                byte[] byteArray = AidlProto.destroyImSession.newBuilder().setAppid(appid).build().toByteArray();
                IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "destroyImSession", byteArray);
                return;
            }
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "this im session has already been destroyed!!!!", new Object[0]);
            return;
        }
        IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "imsession should not be null!!!!", new Object[0]);
    }

    public void destroyMultiProcessTdiSession(IlinkTdiCloneSessionInterface ilinkTdiCloneSessionInterface) {
        if (ilinkTdiCloneSessionInterface != null && (ilinkTdiCloneSessionInterface instanceof IlinkTdiSessionImpl)) {
            IlinkTdiSessionImpl ilinkTdiSessionImpl = (IlinkTdiSessionImpl) ilinkTdiCloneSessionInterface;
            if (IlinkServiceImpl.getInstance().isTdiSessionValid(ilinkTdiSessionImpl)) {
                if (!ilinkTdiSessionImpl.isCloneSession()) {
                    IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "could not destroy session use destroyTdiSession instead!!!!", new Object[0]);
                    return;
                }
                String appid = ilinkTdiSessionImpl.getAppid();
                IlinkServiceImpl.getInstance().removeTdiSession(appid);
                IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "destroyMultiProcessTdiSession", new Class[]{String.class}, appid);
                return;
            }
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "this tdi session has already been destroyed!!!!", new Object[0]);
            return;
        }
        IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "tdi should not be null!!!!", new Object[0]);
    }

    public void destroyTdiSession(IlinkTdiSessionInterface ilinkTdiSessionInterface) {
        if (ilinkTdiSessionInterface != null && (ilinkTdiSessionInterface instanceof IlinkTdiSessionImpl)) {
            IlinkTdiSessionImpl ilinkTdiSessionImpl = (IlinkTdiSessionImpl) ilinkTdiSessionInterface;
            if (IlinkServiceImpl.getInstance().isTdiSessionValid(ilinkTdiSessionImpl)) {
                if (ilinkTdiSessionImpl.isCloneSession()) {
                    IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "could not destroy clone session use destroyMultiProcessTdiSession instead!!!!", new Object[0]);
                    return;
                }
                String appid = ilinkTdiSessionImpl.getAppid();
                IlinkServiceImpl.getInstance().removeTdiSession(appid);
                IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "destroyTdiSession", new Class[]{String.class}, appid);
                return;
            }
            IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "this tdi session has already been destroyed!!!!", new Object[0]);
            return;
        }
        IlinkServiceLogImpl.getInstance().e("IlinkServiceInterface", "tdi should not be null!!!!", new Object[0]);
    }

    public void handleAnnounceResult(Intent intent) {
        IlinkServiceImpl.getInstance().handleAnnounceResult(intent);
    }

    public void handleVoteResult(Intent intent, Bundle bundle) {
        IlinkServiceImpl.getInstance().handleVoteResult(intent, bundle);
    }

    public void receiveAnnounceMsg(Intent intent) {
        IlinkServiceImpl.getInstance().receiveAnnounceMsg(intent);
    }

    public void receiveAnswer(String str, String str2, int i3) {
        IlinkServiceImpl.getInstance().receiveAnswer(str, str2, i3);
    }

    public Bundle receiveVoteMsg(Intent intent, Bundle bundle) {
        return IlinkServiceImpl.getInstance().receiveVoteMsg(intent, bundle);
    }

    public void registCallback(IlinkServiceCallback ilinkServiceCallback) {
        IlinkServiceImpl.getInstance().registCallback(ilinkServiceCallback);
    }

    public void setLogCallback(IlinkServiceLogCallback ilinkServiceLogCallback) {
        IlinkServiceLogImpl.getInstance().setCallback(ilinkServiceLogCallback);
    }

    public void start(Context context, IlinkServiceProto.InitParameter initParameter) {
        IlinkServiceImpl.getInstance().start(context, initParameter.toByteArray());
        IlinkApiTaskManager.getInstance().startTaskManager();
    }

    public void stop() {
        IlinkServiceImpl.getInstance().stop();
        IlinkApiTaskManager.getInstance().stopTaskManager();
    }

    public void unregistCallback(IlinkServiceCallback ilinkServiceCallback) {
        IlinkServiceImpl.getInstance().unregistCallback(ilinkServiceCallback);
    }

    IlinkServiceInterface() {
        this.TAG = "IlinkServiceInterface";
        IlinkServiceImpl.getInstance();
        IlinkApiTaskManager.getInstance();
    }
}
