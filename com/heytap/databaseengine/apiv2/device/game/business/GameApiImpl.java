package com.heytap.databaseengine.apiv2.device.game.business;

import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.heytap.databaseengine.HeytapHealthApi;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.apiv2.common.HRemoteService;
import com.heytap.databaseengine.apiv2.common.HRunnable;
import com.heytap.databaseengine.apiv2.common.PermissionCheckException;
import com.heytap.databaseengine.apiv2.common.callback.HCallBack;
import com.heytap.databaseengine.apiv2.device.game.IDeviceGame;
import com.heytap.databaseengine.apiv2.device.game.IGameApi;
import com.heytap.databaseengine.apiv2.device.game.callback.OnRemoteResponseListener;
import com.heytap.databaseengine.apiv2.device.game.callback.OnRequestGameStatusListener;
import com.heytap.databaseengine.apiv2.device.game.model.GameData;
import com.heytap.databaseengine.apiv2.device.game.model.GameDataWrapper;
import com.heytap.databaseengine.apiv2.device.game.model.GameHealthData;
import com.heytap.databaseengine.apiv2.device.game.model.GameInfo;
import com.heytap.databaseengine.utils.HExecutorService;
import com.heytap.databaseengine.utils.HLog;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class GameApiImpl implements IGameApi {
    private static final String TAG = "GameApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public void exceptionCheck(Exception exc, HCallBack hCallBack) {
        HLog.e(TAG, exc.toString());
        if (exc instanceof PermissionCheckException) {
            hCallBack.onResponse(100006);
        } else {
            hCallBack.onResponse(100003);
        }
        HeytapHealthApi.getInstance().deviceApi().gameApi();
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void end(final GameInfo gameInfo, final HCallBack hCallBack) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.6
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                GameApiImpl.this.exceptionCheck(exc, hCallBack);
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                int end = ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).end(gameInfo);
                HCallBack hCallBack2 = hCallBack;
                if (hCallBack2 != null) {
                    hCallBack2.onResponse(end);
                }
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void endRound(final GameInfo gameInfo) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.4
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                HLog.e(GameApiImpl.TAG, exc.toString());
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).endRound(gameInfo);
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void isConnectGameDevice(final HCallBack hCallBack) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.11
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                GameApiImpl.this.exceptionCheck(exc, hCallBack);
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                int i3;
                if (((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).isConnectGameDevice()) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
                HCallBack hCallBack2 = hCallBack;
                if (hCallBack2 != null) {
                    hCallBack2.onResponse(i3);
                }
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void isPlaying(final HCallBack hCallBack) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.9
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                GameApiImpl.this.exceptionCheck(exc, hCallBack);
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                int i3;
                if (((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).isPlaying()) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
                HCallBack hCallBack2 = hCallBack;
                if (hCallBack2 != null) {
                    hCallBack2.onResponse(i3);
                }
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void isWearing(final HCallBack hCallBack) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.10
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                GameApiImpl.this.exceptionCheck(exc, hCallBack);
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                int i3;
                if (((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).isWearing()) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
                HCallBack hCallBack2 = hCallBack;
                if (hCallBack2 != null) {
                    hCallBack2.onResponse(i3);
                }
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void onPermissionChanged(final boolean z16) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.14
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                HLog.e(GameApiImpl.TAG, exc.toString());
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).onPermissionChanged(z16);
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void pause(final GameInfo gameInfo) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.8
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                HLog.e(GameApiImpl.TAG, exc.toString());
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).pause(gameInfo);
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void resume(final GameInfo gameInfo) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.7
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                HLog.e(GameApiImpl.TAG, exc.toString());
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).resume(gameInfo);
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void setOnRequestStatusListener(final OnRequestStatusListener onRequestStatusListener) {
        if (onRequestStatusListener == null) {
            HLog.e(TAG, "onRequestStatusListener is null");
        } else {
            HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.15
                @Override // com.heytap.databaseengine.apiv2.common.HRunnable
                public void onException(Exception exc) {
                    HLog.e(GameApiImpl.TAG, exc.toString());
                }

                @Override // com.heytap.databaseengine.apiv2.common.HRunnable
                public void realRun() throws Exception {
                    ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).setOnRequestGameStatusListener(new OnRequestGameStatusListener.Stub() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.15.1
                        @Override // com.heytap.databaseengine.apiv2.device.game.callback.OnRequestGameStatusListener
                        public GameInfo onRequestGameStatus() throws RemoteException {
                            return onRequestStatusListener.onRequestStatus();
                        }
                    });
                }
            });
        }
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void setOnResponseListener(final OnResponseListener onResponseListener) {
        if (onResponseListener == null) {
            return;
        }
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.3
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                HLog.e(GameApiImpl.TAG, exc.toString());
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).setOnResponseListener(new OnRemoteResponseListener.Stub() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.3.1
                    @Override // com.heytap.databaseengine.apiv2.device.game.callback.OnRemoteResponseListener
                    public void onResponse(int i3, GameHealthData gameHealthData) throws RemoteException {
                        onResponseListener.onResponse(i3, gameHealthData);
                    }
                });
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void setSendConfig(final boolean z16) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.12
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).setSendConfig(z16);
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void setVerifyGameSwitch(final boolean z16) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.13
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).setVerifyGameSwitch(z16);
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r0 == null) goto L21;
     */
    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldCallForwarding() {
        Cursor cursor = null;
        boolean z16 = false;
        try {
            try {
                cursor = ContactsMonitor.query(_HeytapHealth.getContext().getContentResolver(), Uri.parse("content://com.heytap.health.sporthealthprovider/telecom/forward"), null, null, null, null);
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToNext()) {
                    if (cursor.getInt(cursor.getColumnIndex("forwardState")) == 1) {
                        z16 = true;
                    }
                }
            } catch (Exception e16) {
                HLog.e(TAG, e16.toString());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void start(final GameInfo gameInfo, final HCallBack hCallBack) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.1
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                GameApiImpl.this.exceptionCheck(exc, hCallBack);
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                int start = ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).start(gameInfo);
                HCallBack hCallBack2 = hCallBack;
                if (hCallBack2 != null) {
                    hCallBack2.onResponse(start);
                }
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void startRound(final GameInfo gameInfo, final HCallBack hCallBack) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.2
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                GameApiImpl.this.exceptionCheck(exc, hCallBack);
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                int startRound = ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).startRound(gameInfo);
                HCallBack hCallBack2 = hCallBack;
                if (hCallBack2 != null) {
                    hCallBack2.onResponse(startRound);
                }
            }
        });
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void updateData(final GameInfo gameInfo, final GameData gameData) {
        HExecutorService.create().execute(new HRunnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl.5
            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void onException(Exception exc) {
                HLog.e(GameApiImpl.TAG, exc.toString());
            }

            @Override // com.heytap.databaseengine.apiv2.common.HRunnable
            public void realRun() throws Exception {
                GameDataWrapper gameDataWrapper = new GameDataWrapper();
                gameDataWrapper.setKillType(gameData.getKillType());
                gameDataWrapper.setCountDown(gameData.getCountDown());
                ((IDeviceGame) HRemoteService.getInstance().remoteApi(IDeviceGame.class)).updateData(gameInfo, gameDataWrapper);
            }
        });
    }
}
