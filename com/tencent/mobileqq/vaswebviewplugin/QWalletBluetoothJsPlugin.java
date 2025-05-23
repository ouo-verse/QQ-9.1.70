package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.UUID;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class QWalletBluetoothJsPlugin extends VasWebviewJsPlugin {
    private static final String BASE_UUID_FORMAT = "%08x-0000-1000-8000-00805F9B34FB";
    private static final String BASE_UUID_SUFFIX = "-0000-1000-8000-00805F9B34FB";
    private static final int BLUETOOTH_CONNECTION_FAIL = 10003;
    private static final int BLUETOOTH_NOT_AVAILABLE = 10001;
    private static final int BLUETOOTH_NOT_INIT = 10000;
    private static final int BLUETOOTH_NO_CHARACTERISTIC = 10005;
    private static final int BLUETOOTH_NO_CONNECTION = 10006;
    private static final int BLUETOOTH_NO_DESCRIPTOR = 10010;
    private static final int BLUETOOTH_NO_DEVICE = 10002;
    private static final int BLUETOOTH_NO_SERVICE = 10004;
    private static final int BLUETOOTH_OK = 0;
    private static final int BLUETOOTH_PROPERTY_NOT_SUPPORT = 10007;
    private static final int BLUETOOTH_SYSTEM_ERROR = 10008;
    private static final int BLUETOOTH_SYS_NOT_SUPPORT = 10009;
    private static final String BROADCAST_ACTION_SCAN_CHANGED = "com.tencent.qwallet.bluetooth.scan.changed";
    private static final String CODE = "code";
    private static final long DISCOVER_SERVICES_TIME_OUT = 15000;
    private static final String ERR_MSG = "errMsg";
    public static final String PLUGIN_NAMESPACE = "qw_bluetooth";
    private static final byte QWALLET_REQUEST_OPEN_BLUETOOTH = 1;
    private static final String QWB_BIND_ADAPTER_STATE_CHANGE = "onBluetoothAdapterStateChange";
    private static final String QWB_BIND_CONN_STATE_CHANGE = "onBLEConnectionStateChange";
    private static final String QWB_BIND_DEVICE_FOUND = "onBluetoothDeviceFound";
    private static final String QWB_BIND_VALUE_CHANGE = "onBLECharacteristicValueChange";
    private static final String QWB_CLOSE_ADAPTER = "closeBluetoothAdapter";
    private static final String QWB_CLOSE_CONN = "closeBLEConnection";
    private static final String QWB_CREATE_CONN = "createBLEConnection";
    private static final String QWB_GET_ADAPTER_STATE = "getBluetoothAdapterState";
    private static final String QWB_GET_CHARACTS = "getBLEDeviceCharacteristics";
    private static final String QWB_GET_CONN_DEVICES = "getConnectedBluetoothDevices";
    private static final String QWB_GET_DEVICES = "getBluetoothDevices";
    private static final String QWB_GET_SERVICES = "getBLEDeviceServices";
    private static final String QWB_NOTIFY_VALUE_CHANGE = "notifyBLECharacteristicValueChange";
    private static final String QWB_OPEN_ADAPTER = "openBluetoothAdapter";
    private static final String QWB_READ_VALUE = "readBLECharacteristicValue";
    private static final String QWB_START_DEVICE_DISCOVERY = "startBluetoothDevicesDiscovery";
    private static final String QWB_STOP_DEVICE_DISCOVERY = "stopBluetoothDevicesDiscovery";
    private static final String QWB_WRITE_VALUE = "writeBLECharacteristicValue";
    private static final long SCAN_PERIOD = 12000;
    static final String TAG = "QWBluetoothJsPlugin";
    private static boolean sAvailable;
    private static boolean sDiscovering;
    private static boolean sIsReceiverRegister;
    private Runnable discoverServicesTimeOut;
    private WeakReference<Activity> mActivityWeak;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGattCallback mBluetoothGattCallback;
    private ArrayMap<String, BluetoothGatt> mBluetoothGatts;
    private BroadcastReceiver mBluetoothStateReceiver;
    private ArrayMap<String, String> mCallbacks;
    private Set<String> mConnectedDevices;
    private Set<String> mConnectingDevices;
    private Context mContext;
    private List<BluetoothDeviceExtend> mDevicesFound;
    private BluetoothGattCallback mGetServicesCallback;
    private Handler mHandler;
    private QWLeScanCallback mLeScanCallback;
    private Runnable stopScan;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class BluetoothDeviceExtend {
        private BluetoothDevice mBluetoothDevice;
        private int mRssi;
        private byte[] mScanRecord;

        BluetoothDeviceExtend(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
            this.mBluetoothDevice = bluetoothDevice;
            this.mRssi = i3;
            this.mScanRecord = bArr;
        }

        public boolean equals(Object obj) {
            return (obj instanceof BluetoothDeviceExtend) && ((BluetoothDeviceExtend) obj).getBluetoothDevice().getAddress().equals(this.mBluetoothDevice.getAddress());
        }

        BluetoothDevice getBluetoothDevice() {
            return this.mBluetoothDevice;
        }

        public int getRssi() {
            return this.mRssi;
        }

        byte[] getScanRecord() {
            return this.mScanRecord;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class ConnServicesCallback extends BluetoothGattCallback {
        private int mCount;
        private Runnable mRunnable;
        private List<UUID> mSearchUuids;
        private List<BluetoothDevice> mDevices = new ArrayList();
        private int cur = 0;

        ConnServicesCallback(List<UUID> list, int i3) {
            this.mSearchUuids = list;
            this.mCount = i3;
            this.mRunnable = new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.ConnServicesCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_GET_CONN_DEVICES, 10006, "get connected devices time out");
                }
            };
            QWalletBluetoothJsPlugin.this.mHandler.postDelayed(this.mRunnable, 15000L);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i3, int i16) {
            super.onConnectionStateChange(bluetoothGatt, i3, i16);
            if (i3 == 0 && i16 == 2) {
                bluetoothGatt.discoverServices();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i3) {
            super.onServicesDiscovered(bluetoothGatt, i3);
            ArrayList arrayList = new ArrayList();
            for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                if (bluetoothGattService.getType() == 0) {
                    arrayList.add(bluetoothGattService.getUuid());
                }
            }
            this.cur++;
            if (arrayList.containsAll(this.mSearchUuids)) {
                this.mDevices.add(bluetoothGatt.getDevice());
            }
            if (this.cur == this.mCount) {
                QWalletBluetoothJsPlugin.this.mHandler.removeCallbacks(this.mRunnable);
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (BluetoothDevice bluetoothDevice : this.mDevices) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("name", bluetoothDevice.getName());
                        jSONObject2.put(Constants.SP_DEVICE_ID, bluetoothDevice.getAddress());
                        jSONArray.mo162put(jSONObject2);
                    }
                    jSONObject.put("devices", jSONArray);
                    jSONObject.put("code", 0);
                    QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_GET_CONN_DEVICES, jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
        }
    }

    private void closeBLEConnection(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
            if (bluetoothGatt == null) {
                jSONObject.put("code", 10002);
                jSONObject.put("errMsg", "DeviceId is not found");
            } else {
                bluetoothGatt.disconnect();
                bluetoothGatt.close();
                this.mConnectedDevices.remove(str);
                this.mBluetoothGatts.remove(str);
                jSONObject.put("code", 0);
            }
            doCallback(QWB_CLOSE_CONN, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    private void closeBluetoothAdapter() {
        unregisterReceiver();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
            this.mBluetoothAdapter.cancelDiscovery();
        }
        QWLeScanCallback qWLeScanCallback = this.mLeScanCallback;
        if (qWLeScanCallback != null) {
            qWLeScanCallback.stopTimer();
        }
        for (BluetoothGatt bluetoothGatt : this.mBluetoothGatts.values()) {
            bluetoothGatt.disconnect();
            bluetoothGatt.close();
        }
        doCallback(QWB_CLOSE_ADAPTER, 0, "");
        this.mCallbacks.clear();
        this.mBluetoothGatts.clear();
        this.mConnectingDevices.clear();
        this.mDevicesFound.clear();
        this.mConnectedDevices.clear();
        this.mBluetoothAdapter = null;
    }

    private void createBLEConnection(String str) {
        if (this.mBluetoothAdapter.getRemoteDevice(str).connectGatt(this.mContext, false, getBluetoothGattCallback()) == null) {
            doCallback(QWB_CREATE_CONN, 10003, "connect failed");
        } else {
            this.mConnectingDevices.add(str);
        }
    }

    private static String createSimpleCallback(int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i3);
            jSONObject.put("errMsg", str);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "{'code':10008,'errMsg':'Parse json error'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(String str, String str2) {
        String str3 = this.mCallbacks.get(str);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return;
        }
        callJs(str3, str2);
        Log.i(TAG, "doCallback: " + str3 + "->" + str2);
    }

    private void getBLEDeviceCharacteristics(String str, UUID uuid) {
        JSONObject jSONObject = new JSONObject();
        try {
            BluetoothGattService service = getService(QWB_GET_CHARACTS, str, uuid);
            if (service == null) {
                return;
            }
            List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
            if (characteristics.size() == 0) {
                jSONObject.put("code", 10005);
                jSONObject.put("errMsg", "No characteristics");
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<BluetoothGattCharacteristic> it = characteristics.iterator();
            while (true) {
                boolean z16 = false;
                if (it.hasNext()) {
                    BluetoothGattCharacteristic next = it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("uuid", next.getUuid().toString());
                    JSONObject jSONObject3 = new JSONObject();
                    int properties = next.getProperties();
                    jSONObject3.put(k.f247491e, (properties & 2) > 0);
                    jSONObject3.put(k.f247492f, (properties & 8) > 0);
                    jSONObject3.put("notify", (properties & 16) > 0);
                    if ((properties & 32) > 0) {
                        z16 = true;
                    }
                    jSONObject3.put("indicate", z16);
                    jSONObject2.put(Constants.Service.PROPERTIES, jSONObject3);
                    jSONArray.mo162put(jSONObject2);
                } else {
                    jSONObject.put("characteristics", jSONArray);
                    jSONObject.put("code", 0);
                    doCallback(QWB_GET_CHARACTS, jSONObject.toString());
                    return;
                }
            }
        } catch (JSONException unused) {
        }
    }

    private void getBLEDeviceServices(String str) {
        Runnable runnable = this.discoverServicesTimeOut;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
        if (bluetoothGatt == null) {
            doCallback(QWB_GET_SERVICES, 10002, "DeviceId is not found");
        } else {
            if (bluetoothGatt.discoverServices()) {
                Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_GET_SERVICES, 10004, "Discover services is time out");
                    }
                };
                this.discoverServicesTimeOut = runnable2;
                this.mHandler.postDelayed(runnable2, 15000L);
                return;
            }
            doCallback(QWB_GET_SERVICES, 10008, "Discover services not start");
        }
    }

    private void getBluetoothAdapterState() {
        sAvailable = this.mBluetoothAdapter.isEnabled();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("discovering", sDiscovering);
            jSONObject.put("available", sAvailable);
        } catch (JSONException unused) {
        }
        doCallback(QWB_GET_ADAPTER_STATE, jSONObject.toString());
    }

    private void getBluetoothDevices() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<BluetoothDeviceExtend> it = this.mDevicesFound.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(parseDevice2Json(it.next()));
            }
            jSONObject.put("devices", jSONArray);
            jSONObject.put("code", 0);
            doCallback(QWB_GET_DEVICES, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    private BluetoothGattCallback getBluetoothGattCallback() {
        if (this.mBluetoothGattCallback == null) {
            this.mBluetoothGattCallback = new BluetoothGattCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.4
                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                    super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, bluetoothGatt.getDevice().getAddress());
                        jSONObject.put("serviceId", bluetoothGattCharacteristic.getService().getUuid().toString());
                        jSONObject.put("characteristicId", bluetoothGattCharacteristic.getUuid().toString());
                        jSONObject.put("value", QWalletBluetoothJsPlugin.bytes2Base64(bluetoothGattCharacteristic.getValue()));
                        QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_BIND_VALUE_CHANGE, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (i3 == 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("uuid", bluetoothGattCharacteristic.getUuid().toString());
                            jSONObject2.put("serviceId", bluetoothGattCharacteristic.getService().getUuid().toString());
                            jSONObject2.put("value", QWalletBluetoothJsPlugin.bytes2Base64(bluetoothGattCharacteristic.getValue()));
                            jSONObject.put("characteristic", jSONObject2);
                            jSONObject.put("code", 0);
                        } else {
                            jSONObject.put("code", 10007);
                            jSONObject.put("errMsg", "Read failed");
                        }
                        QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_READ_VALUE, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (i3 == 0) {
                            jSONObject.put("code", 0);
                        } else {
                            jSONObject.put("code", 10007);
                            jSONObject.put("errMsg", "Write failed");
                        }
                        QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_WRITE_VALUE, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i3, int i16) {
                    super.onConnectionStateChange(bluetoothGatt, i3, i16);
                    String address = bluetoothGatt.getDevice().getAddress();
                    try {
                        if (QWalletBluetoothJsPlugin.this.mConnectingDevices.contains(address)) {
                            QWalletBluetoothJsPlugin.this.mConnectingDevices.remove(address);
                            JSONObject jSONObject = new JSONObject();
                            if (i3 == 0 && i16 == 2) {
                                QWalletBluetoothJsPlugin.this.mBluetoothGatts.put(address, bluetoothGatt);
                                jSONObject.put("code", 0);
                            } else {
                                jSONObject.put("code", 10003);
                                jSONObject.put("errMsg", "connect failed");
                            }
                            QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_CREATE_CONN, jSONObject.toString());
                        }
                        if (i16 == 2) {
                            QWalletBluetoothJsPlugin.this.mConnectedDevices.add(address);
                        } else {
                            QWalletBluetoothJsPlugin.this.mConnectedDevices.remove(address);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, address);
                        jSONObject2.put("connected", i16 == 2);
                        QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_BIND_CONN_STATE_CHANGE, jSONObject2.toString());
                    } catch (JSONException unused) {
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i3) {
                    if (QWalletBluetoothJsPlugin.this.discoverServicesTimeOut != null) {
                        QWalletBluetoothJsPlugin.this.mHandler.removeCallbacks(QWalletBluetoothJsPlugin.this.discoverServicesTimeOut);
                        QWalletBluetoothJsPlugin.this.discoverServicesTimeOut = null;
                    }
                    super.onServicesDiscovered(bluetoothGatt, i3);
                    List<BluetoothGattService> services = bluetoothGatt.getServices();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (services.size() == 0) {
                            jSONObject.put("code", 10004);
                            jSONObject.put("errMsg", "No Service");
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<BluetoothGattService> it = services.iterator();
                            while (true) {
                                boolean z16 = false;
                                if (!it.hasNext()) {
                                    break;
                                }
                                BluetoothGattService next = it.next();
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("uuid", next.getUuid().toString());
                                if (next.getType() == 0) {
                                    z16 = true;
                                }
                                jSONObject2.put("isPrimary", z16);
                                jSONArray.mo162put(jSONObject2);
                            }
                            jSONObject.put("services", jSONArray);
                            jSONObject.put("code", 0);
                        }
                        QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_GET_SERVICES, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }
            };
        }
        return this.mBluetoothGattCallback;
    }

    private BluetoothGattCharacteristic getCharacteristic(String str, String str2, UUID uuid, UUID uuid2) {
        BluetoothGattService service = getService(str, str2, uuid);
        if (service == null) {
            return null;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        if (characteristic != null) {
            return characteristic;
        }
        doCallback(str, 10005, "No characteristics");
        return null;
    }

    private void getConnectedBluetoothDevices(String str) {
        List<BluetoothDevice> connectedDevices = ((BluetoothManager) this.mContext.getSystemService(QQPermissionConstants.Permission.BLUE_TOOTH_GROUP)).getConnectedDevices(7);
        Iterator<BluetoothDevice> it = connectedDevices.iterator();
        while (it.hasNext()) {
            if (it.next().getType() != 2) {
                it.remove();
            }
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("services");
            if (connectedDevices.isEmpty()) {
                doCallback(QWB_GET_CONN_DEVICES, 10002, "No Devices");
            } else if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    UUID parseUuidFromStr = parseUuidFromStr(optJSONArray.getString(i3));
                    if (parseUuidFromStr != null) {
                        arrayList.add(parseUuidFromStr);
                    }
                }
                if (arrayList.size() > 0) {
                    this.mGetServicesCallback = new ConnServicesCallback(arrayList, connectedDevices.size());
                    Iterator<BluetoothDevice> it5 = connectedDevices.iterator();
                    while (it5.hasNext()) {
                        it5.next().connectGatt(this.mContext, false, this.mGetServicesCallback);
                    }
                    return;
                }
            }
            doCallback(QWB_GET_CONN_DEVICES, 10003, "Missing parameters");
        } catch (JSONException unused) {
        }
    }

    private BluetoothGattService getService(String str, String str2, UUID uuid) {
        String createSimpleCallback;
        BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str2);
        if (bluetoothGatt == null) {
            createSimpleCallback = createSimpleCallback(10002, "No device");
        } else {
            BluetoothGattService service = bluetoothGatt.getService(uuid);
            if (service != null) {
                return service;
            }
            createSimpleCallback = createSimpleCallback(10004, "No services");
        }
        doCallback(str, createSimpleCallback);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<UUID> getUuidsFromRecordData(byte[] bArr) {
        byte b16;
        ArrayList arrayList = new ArrayList();
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        while (order.remaining() > 2 && (b16 = order.get()) != 0) {
            byte b17 = order.get();
            if (b17 == 2 || b17 == 3) {
                while (b16 >= 2) {
                    arrayList.add(UUID.fromString(String.format(BASE_UUID_FORMAT, Short.valueOf(order.getShort()))));
                    b16 = (byte) (b16 - 2);
                }
            } else if (b17 == 6 || b17 == 7) {
                while (b16 >= 16) {
                    arrayList.add(new UUID(order.getLong(), order.getLong()));
                    b16 = (byte) (b16 - 16);
                }
            } else {
                order.position((order.position() + b16) - 1);
            }
        }
        return arrayList;
    }

    private void notifyBLECharacteristicValueChange(String str, UUID uuid, UUID uuid2, boolean z16) {
        try {
            BluetoothGattCharacteristic characteristic = getCharacteristic(QWB_READ_VALUE, str, uuid, uuid2);
            if (characteristic != null) {
                BluetoothGatt bluetoothGatt = this.mBluetoothGatts.get(str);
                JSONObject jSONObject = new JSONObject();
                int properties = characteristic.getProperties();
                boolean z17 = (properties & 16) > 0;
                boolean z18 = (properties & 32) > 0;
                if ((z17 || z18) && bluetoothGatt.setCharacteristicNotification(characteristic, z16)) {
                    jSONObject.put("code", 0);
                    BluetoothGattDescriptor descriptor = characteristic.getDescriptor(parseUuidFromStr("2902"));
                    if (descriptor != null) {
                        if (z17) {
                            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        }
                        if (z18) {
                            descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                        }
                        bluetoothGatt.writeDescriptor(descriptor);
                    }
                } else {
                    jSONObject.put("code", 10007);
                    jSONObject.put("errMsg", "Property is not support");
                }
                doCallback(QWB_NOTIFY_VALUE_CHANGE, jSONObject.toString());
            }
        } catch (JSONException unused) {
        }
    }

    private void onBluetoothAdapterStateChange() {
        WeakReference<Activity> weakReference;
        Activity activity;
        sAvailable = this.mBluetoothAdapter.isEnabled();
        if (this.mBluetoothStateReceiver == null) {
            this.mBluetoothStateReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    boolean z16 = true;
                    if (!QWalletBluetoothJsPlugin.BROADCAST_ACTION_SCAN_CHANGED.equals(action)) {
                        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                            if (intExtra == 10) {
                                QWalletBluetoothJsPlugin.sAvailable = false;
                            } else if (intExtra == 12) {
                                QWalletBluetoothJsPlugin.sAvailable = true;
                            }
                        }
                        z16 = false;
                    }
                    if (z16) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("available", QWalletBluetoothJsPlugin.sAvailable);
                            jSONObject.put("discovering", QWalletBluetoothJsPlugin.sDiscovering);
                            QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_BIND_ADAPTER_STATE_CHANGE, jSONObject.toString());
                        } catch (JSONException unused) {
                        }
                    }
                }
            };
        }
        if (sIsReceiverRegister || (weakReference = this.mActivityWeak) == null || (activity = weakReference.get()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction(BROADCAST_ACTION_SCAN_CHANGED);
        activity.registerReceiver(this.mBluetoothStateReceiver, intentFilter);
        sIsReceiverRegister = true;
    }

    private void openBluetoothAdapter() {
        JSONObject jSONObject = new JSONObject();
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            if (!this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                jSONObject.put("code", 10009);
                jSONObject.put("errMsg", "System does not support");
            } else {
                BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
                if (bluetoothAdapter != null) {
                    if (bluetoothAdapter.isEnabled()) {
                        jSONObject.put("code", 0);
                    } else {
                        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), (byte) 1);
                    }
                } else {
                    jSONObject.put("code", 10001);
                    jSONObject.put("errMsg", "Bluetooth is not sAvailable");
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (jSONObject.has("code")) {
            doCallback("openBluetoothAdapter", jSONObject.toString());
        }
    }

    private void parseCallback(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.toLowerCase().indexOf("callback") < 0) {
            return;
        }
        try {
            this.mCallbacks.put(str, new JSONObject(str2).optString("callback"));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject parseDevice2Json(BluetoothDeviceExtend bluetoothDeviceExtend) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", bluetoothDeviceExtend.getBluetoothDevice().getName());
            jSONObject.put(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, bluetoothDeviceExtend.getBluetoothDevice().getAddress());
            jSONObject.put("RSSI", bluetoothDeviceExtend.getRssi());
            jSONObject.put("advertisData", bytes2Base64(bluetoothDeviceExtend.getScanRecord()));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private void readBLECharacteristicValue(String str, UUID uuid, UUID uuid2) {
        BluetoothGattCharacteristic characteristic = getCharacteristic(QWB_READ_VALUE, str, uuid, uuid2);
        if (characteristic == null || this.mBluetoothGatts.get(str).readCharacteristic(characteristic)) {
            return;
        }
        doCallback(QWB_READ_VALUE, 10007, "Initializing read operation was failed");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057 A[Catch: JSONException -> 0x0094, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0094, blocks: (B:11:0x0053, B:13:0x0057, B:16:0x0064, B:17:0x0085, B:20:0x0079), top: B:10:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void startBluetoothDevicesDiscovery(String str) {
        boolean z16;
        int i3;
        BluetoothAdapter bluetoothAdapter;
        if (sDiscovering) {
            doCallback(QWB_START_DEVICE_DISCOVERY, 10008, "Bluetooth is scanning");
            return;
        }
        JSONArray jSONArray = null;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONArray = jSONObject.optJSONArray("services");
                z16 = jSONObject.optBoolean("allowDuplicatesKey", false);
                try {
                    i3 = jSONObject.optInt(WidgetCacheConstellationData.INTERVAL, 0);
                } catch (JSONException unused) {
                    i3 = 0;
                    this.mLeScanCallback = new QWLeScanCallback(jSONArray, z16, i3);
                    this.mDevicesFound.clear();
                    Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QWalletBluetoothJsPlugin.this.mBluetoothAdapter != null) {
                                QWalletBluetoothJsPlugin.this.mBluetoothAdapter.stopLeScan(QWalletBluetoothJsPlugin.this.mLeScanCallback);
                                QWalletBluetoothJsPlugin.sDiscovering = false;
                                QWalletBluetoothJsPlugin.this.mContext.sendBroadcast(new Intent().setAction(QWalletBluetoothJsPlugin.BROADCAST_ACTION_SCAN_CHANGED));
                            }
                        }
                    };
                    this.stopScan = runnable;
                    this.mHandler.postDelayed(runnable, SCAN_PERIOD);
                    JSONObject jSONObject2 = new JSONObject();
                    bluetoothAdapter = this.mBluetoothAdapter;
                    if (bluetoothAdapter == null) {
                    }
                }
            } catch (JSONException unused2) {
                z16 = false;
            }
        } else {
            z16 = false;
            i3 = 0;
        }
        this.mLeScanCallback = new QWLeScanCallback(jSONArray, z16, i3);
        this.mDevicesFound.clear();
        Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (QWalletBluetoothJsPlugin.this.mBluetoothAdapter != null) {
                    QWalletBluetoothJsPlugin.this.mBluetoothAdapter.stopLeScan(QWalletBluetoothJsPlugin.this.mLeScanCallback);
                    QWalletBluetoothJsPlugin.sDiscovering = false;
                    QWalletBluetoothJsPlugin.this.mContext.sendBroadcast(new Intent().setAction(QWalletBluetoothJsPlugin.BROADCAST_ACTION_SCAN_CHANGED));
                }
            }
        };
        this.stopScan = runnable2;
        this.mHandler.postDelayed(runnable2, SCAN_PERIOD);
        JSONObject jSONObject22 = new JSONObject();
        try {
            bluetoothAdapter = this.mBluetoothAdapter;
            if (bluetoothAdapter == null) {
                boolean startLeScan = LocationMonitor.startLeScan(bluetoothAdapter, this.mLeScanCallback);
                sDiscovering = startLeScan;
                if (startLeScan) {
                    jSONObject22.put("code", 0);
                    this.mContext.sendBroadcast(new Intent().setAction(BROADCAST_ACTION_SCAN_CHANGED));
                } else {
                    jSONObject22.put("code", 10008);
                    jSONObject22.put("errMsg", "Start scan failed");
                }
                jSONObject22.put("isDiscovering", sDiscovering);
                doCallback(QWB_START_DEVICE_DISCOVERY, jSONObject22.toString());
            }
        } catch (JSONException unused3) {
        }
    }

    private void stopBluetoothDevicesDiscovery() {
        if (this.mBluetoothAdapter != null) {
            this.mLeScanCallback.stopTimer();
            this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
            sDiscovering = false;
            sAvailable = this.mBluetoothAdapter.isEnabled();
            this.mContext.sendBroadcast(new Intent().setAction(BROADCAST_ACTION_SCAN_CHANGED));
            Runnable runnable = this.stopScan;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("discovering", sDiscovering);
                jSONObject.put("available", sAvailable);
                doCallback(QWB_STOP_DEVICE_DISCOVERY, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    private void unregisterReceiver() {
        Activity activity;
        if (this.mBluetoothStateReceiver == null || !sIsReceiverRegister) {
            return;
        }
        WeakReference<Activity> weakReference = this.mActivityWeak;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            try {
                activity.unregisterReceiver(this.mBluetoothStateReceiver);
            } catch (IllegalArgumentException e16) {
                QLog.w(TAG, 1, "unregisterReceiver catch", e16);
            }
        }
        sIsReceiverRegister = false;
    }

    private void writeBLECharacteristicValue(String str, UUID uuid, UUID uuid2, String str2) {
        BluetoothGattCharacteristic characteristic = getCharacteristic(QWB_READ_VALUE, str, uuid, uuid2);
        if (characteristic != null) {
            characteristic.setValue(base642Bytes(str2));
            if (this.mBluetoothGatts.get(str).writeCharacteristic(characteristic)) {
                return;
            }
            doCallback(QWB_WRITE_VALUE, 10007, "Initializing write operation was failed");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return PLUGIN_NAMESPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || this.mContext == null || !PLUGIN_NAMESPACE.equals(str2)) {
            return false;
        }
        if (strArr.length > 0) {
            parseCallback(str3, strArr[0]);
        }
        if ("openBluetoothAdapter".equals(str3)) {
            openBluetoothAdapter();
        } else if (QWB_CLOSE_ADAPTER.equals(str3)) {
            closeBluetoothAdapter();
        } else if (!QWB_BIND_DEVICE_FOUND.equals(str3) && !QWB_BIND_CONN_STATE_CHANGE.equals(str3) && !QWB_BIND_VALUE_CHANGE.equals(str3)) {
            if (this.mBluetoothAdapter == null) {
                doCallback(str3, 10000, "Initialize first");
            } else if (QWB_GET_ADAPTER_STATE.equals(str3)) {
                getBluetoothAdapterState();
            } else if (QWB_BIND_ADAPTER_STATE_CHANGE.equals(str3)) {
                onBluetoothAdapterStateChange();
            } else if (QWB_START_DEVICE_DISCOVERY.equals(str3)) {
                if (strArr.length > 0) {
                    startBluetoothDevicesDiscovery(strArr[0]);
                } else {
                    startBluetoothDevicesDiscovery(null);
                }
            } else if (QWB_STOP_DEVICE_DISCOVERY.equals(str3)) {
                stopBluetoothDevicesDiscovery();
            } else if (QWB_GET_DEVICES.equals(str3)) {
                getBluetoothDevices();
            } else if (QWB_GET_CONN_DEVICES.equals(str3)) {
                if (strArr.length > 0) {
                    getConnectedBluetoothDevices(strArr[0]);
                } else {
                    doCallback(QWB_GET_CONN_DEVICES, 10003, "Missing parameters");
                }
            } else {
                try {
                    String createSimpleCallback = createSimpleCallback(10003, "Missing parameters");
                    if (strArr.length > 0) {
                        JSONObject jSONObject = new JSONObject(strArr[0]);
                        String upperCase = jSONObject.optString(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID).toUpperCase();
                        if (BluetoothAdapter.checkBluetoothAddress(upperCase)) {
                            if (!this.mConnectedDevices.contains(upperCase) && !QWB_CREATE_CONN.equals(str3)) {
                                doCallback(str3, 10006, "connect the device first");
                                return true;
                            }
                            UUID parseUuidFromStr = parseUuidFromStr(jSONObject.optString("serviceId"));
                            UUID parseUuidFromStr2 = parseUuidFromStr(jSONObject.optString("characteristicId"));
                            String optString = jSONObject.optString("value");
                            boolean optBoolean = jSONObject.optBoolean("state");
                            if (QWB_CREATE_CONN.equals(str3)) {
                                createBLEConnection(upperCase);
                            } else if (QWB_CLOSE_CONN.equals(str3)) {
                                closeBLEConnection(upperCase);
                            } else if (QWB_GET_SERVICES.equals(str3)) {
                                getBLEDeviceServices(upperCase);
                            } else if (QWB_GET_CHARACTS.equals(str3)) {
                                if (parseUuidFromStr == null) {
                                    doCallback(str3, createSimpleCallback);
                                } else {
                                    getBLEDeviceCharacteristics(upperCase, parseUuidFromStr);
                                }
                            } else if (QWB_READ_VALUE.equals(str3)) {
                                if (parseUuidFromStr != null && parseUuidFromStr2 != null) {
                                    readBLECharacteristicValue(upperCase, parseUuidFromStr, parseUuidFromStr2);
                                }
                                doCallback(str3, createSimpleCallback);
                            } else if (QWB_WRITE_VALUE.equals(str3)) {
                                if (parseUuidFromStr != null && parseUuidFromStr2 != null && !optString.isEmpty()) {
                                    writeBLECharacteristicValue(upperCase, parseUuidFromStr, parseUuidFromStr2, optString);
                                }
                                doCallback(str3, createSimpleCallback);
                            } else if (QWB_NOTIFY_VALUE_CHANGE.equals(str3)) {
                                if (parseUuidFromStr != null && parseUuidFromStr2 != null) {
                                    notifyBLECharacteristicValueChange(upperCase, parseUuidFromStr, parseUuidFromStr2, optBoolean);
                                }
                                doCallback(str3, createSimpleCallback);
                            }
                        } else {
                            doCallback(str3, createSimpleCallback);
                            return true;
                        }
                    } else {
                        doCallback(str3, createSimpleCallback);
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (b16 == 1) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (i3 == -1) {
                    jSONObject.put("code", 0);
                } else {
                    jSONObject.put("code", 10000);
                    jSONObject.put("errMsg", "User refused");
                }
                doCallback("openBluetoothAdapter", jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        Activity a16;
        super.onCreate();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (a16 = bVar.a()) != null) {
            this.mActivityWeak = new WeakReference<>(a16);
            this.mContext = a16.getApplicationContext();
        }
        this.mDevicesFound = new LinkedList();
        this.mCallbacks = new ArrayMap<>();
        this.mBluetoothGatts = new ArrayMap<>();
        this.mConnectingDevices = new HashSet();
        this.mConnectedDevices = new HashSet();
        sAvailable = false;
        sDiscovering = false;
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        if (this.mRuntime != null) {
            unregisterReceiver();
        }
        this.mLeScanCallback = null;
        this.mBluetoothGattCallback = null;
        this.mGetServicesCallback = null;
        this.mBluetoothStateReceiver = null;
        this.stopScan = null;
        this.discoverServicesTimeOut = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class QWLeScanCallback implements BluetoothAdapter.LeScanCallback {
        private boolean mAllowDuplicatesKey;
        private int mInterval;
        private ArrayList<UUID> mServices;
        private Timer mTimer;
        private List<BluetoothDeviceExtend> tempDevices;

        QWLeScanCallback(JSONArray jSONArray, boolean z16, int i3) {
            if (jSONArray != null && jSONArray.length() != 0) {
                this.mServices = new ArrayList<>();
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    UUID parseUuidFromStr = QWalletBluetoothJsPlugin.parseUuidFromStr(jSONArray.optString(i16));
                    if (parseUuidFromStr != null) {
                        this.mServices.add(parseUuidFromStr);
                    }
                }
            } else {
                this.mServices = null;
            }
            this.mAllowDuplicatesKey = z16;
            this.mInterval = i3;
            this.tempDevices = new ArrayList();
            if (this.mInterval > 0) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.QWLeScanCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            List<BluetoothDeviceExtend> tempDevices = QWLeScanCallback.this.getTempDevices();
                            if (tempDevices.size() > 0) {
                                JSONObject jSONObject = new JSONObject();
                                JSONArray jSONArray2 = new JSONArray();
                                Iterator<BluetoothDeviceExtend> it = tempDevices.iterator();
                                while (it.hasNext()) {
                                    jSONArray2.mo162put(QWalletBluetoothJsPlugin.parseDevice2Json(it.next()));
                                }
                                jSONObject.put("devices", jSONArray2);
                                QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_BIND_DEVICE_FOUND, jSONObject.toString());
                                ThreadManager.getUIHandler().postDelayed(this, QWLeScanCallback.this.mInterval * 1000);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                }, this.mInterval * 1000);
            }
        }

        synchronized void addTempDevices(BluetoothDeviceExtend bluetoothDeviceExtend) {
            this.tempDevices.add(bluetoothDeviceExtend);
        }

        synchronized List<BluetoothDeviceExtend> getTempDevices() {
            ArrayList arrayList;
            arrayList = new ArrayList();
            arrayList.addAll(this.tempDevices);
            this.tempDevices.clear();
            return arrayList;
        }

        public void stopTimer() {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
            if (bluetoothDevice != null) {
                List uuidsFromRecordData = QWalletBluetoothJsPlugin.getUuidsFromRecordData(bArr);
                ArrayList<UUID> arrayList = this.mServices;
                if (arrayList == null || arrayList.size() <= 0 || uuidsFromRecordData.containsAll(this.mServices)) {
                    BluetoothDeviceExtend bluetoothDeviceExtend = new BluetoothDeviceExtend(bluetoothDevice, i3, bArr);
                    boolean z16 = !QWalletBluetoothJsPlugin.this.mDevicesFound.contains(bluetoothDeviceExtend);
                    if (z16) {
                        QWalletBluetoothJsPlugin.this.mDevicesFound.add(bluetoothDeviceExtend);
                    }
                    if (z16 || this.mAllowDuplicatesKey) {
                        if (this.mInterval == 0) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.mo162put(QWalletBluetoothJsPlugin.parseDevice2Json(bluetoothDeviceExtend));
                                jSONObject.put("devices", jSONArray);
                                QWalletBluetoothJsPlugin.this.doCallback(QWalletBluetoothJsPlugin.QWB_BIND_DEVICE_FOUND, jSONObject.toString());
                                return;
                            } catch (JSONException unused) {
                                return;
                            }
                        }
                        addTempDevices(bluetoothDeviceExtend);
                    }
                }
            }
        }
    }

    private static byte[] base642Bytes(String str) {
        return Base64.decode(str, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String bytes2Base64(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static UUID parseUuidFromStr(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                int length = str.length();
                if (length == 4) {
                    return UUID.fromString("0000" + str + BASE_UUID_SUFFIX);
                }
                if (length != 8) {
                    return UUID.fromString(str);
                }
                return UUID.fromString(str + BASE_UUID_SUFFIX);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(String str, int i3, String str2) {
        doCallback(str, createSimpleCallback(i3, str2));
    }
}
