package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.ads.data.AdParam;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes27.dex */
public final class AdPlatformInfo extends Message<AdPlatformInfo, a> {
    public static final ProtoAdapter<AdPlatformInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.ADBaseExtraInfo#ADAPTER", jsonName = "adBaseExtraInfo", label = WireField.Label.OMIT_IDENTITY, tag = 41)
    public final ADBaseExtraInfo ad_base_extra_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "androidId", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final String android_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "appChannel", label = WireField.Label.OMIT_IDENTITY, tag = 14)
    public final String app_channel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "appId", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String app_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "bluetoothMac", label = WireField.Label.OMIT_IDENTITY, tag = 22)
    public final String bluetooth_mac;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 27)
    public final String boottime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final String brands;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 25)
    public final String bssid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 46)
    public final String chid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 12)
    public final String city;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 28)
    public final String country;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 30)
    public final String deviceName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "deviceBrandAndModel", label = WireField.Label.OMIT_IDENTITY, tag = 17)
    public final String device_brand_and_model;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdDeviceInfo#ADAPTER", jsonName = "deviceInfoList", label = WireField.Label.REPEATED, tag = 21)
    public final List<AdDeviceInfo> device_info_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 32)
    public final String disk;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "encryptCachedIdfa", label = WireField.Label.OMIT_IDENTITY, tag = 37)
    public final String encrypt_cached_idfa;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "encryptedOaid", label = WireField.Label.OMIT_IDENTITY, tag = 19)
    public final String encrypted_oaid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "harmonyOsVersion", label = WireField.Label.OMIT_IDENTITY, tag = 38)
    public final String harmony_os_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "harmonyPureMode", label = WireField.Label.OMIT_IDENTITY, tag = 39)
    public final int harmony_pure_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "hwMachine", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String hw_machine;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "hwModel", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String hw_model;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 35)
    public final String idfv;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 29)
    public final String language;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "macAddress", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final String mac_address;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 16)
    public final String manufacturer;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 31)
    public final String memory;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 11)
    public final String mid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = AdParam.SIMOPERATOR, label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String mobile_network_code;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.NetType#ADAPTER", jsonName = "netType", label = WireField.Label.OMIT_IDENTITY, tag = 45)
    public final NetType net_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "openUdid", label = WireField.Label.OMIT_IDENTITY, tag = 15)
    public final String open_udid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 33)
    public final String osUpgradeTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "osType", label = WireField.Label.OMIT_IDENTITY, tag = 40)
    public final int os_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "osVersion", label = WireField.Label.OMIT_IDENTITY, tag = 26)
    public final String os_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 20)
    public final String qadid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = AdParam.ROUTERMACADDRESS, label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String router_mac_address;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "screenHeight", label = WireField.Label.OMIT_IDENTITY, tag = 44)
    public final String screen_height;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = AdParam.SCREENSIZE, label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String screen_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "screenWidth", label = WireField.Label.OMIT_IDENTITY, tag = 43)
    public final String screen_width;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 13)
    public final String street;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "subscriberId", label = WireField.Label.OMIT_IDENTITY, tag = 23)
    public final String subscriber_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "systemVersion", label = WireField.Label.OMIT_IDENTITY, tag = 42)
    public final String system_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "taidTicket", label = WireField.Label.OMIT_IDENTITY, tag = 18)
    public final String taid_ticket;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 34)
    public final String timeZone;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "userAgent", label = WireField.Label.OMIT_IDENTITY, tag = 36)
    public final String user_agent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 24)
    public final String uuid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = AdParam.WIFINAME, label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String wifi_name;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdPlatformInfo, a> {
        public ADBaseExtraInfo S;

        /* renamed from: a, reason: collision with root package name */
        public String f383658a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383659b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383660c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383661d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f383662e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383663f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f383664g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f383665h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f383666i = "";

        /* renamed from: j, reason: collision with root package name */
        public String f383667j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f383668k = "";

        /* renamed from: l, reason: collision with root package name */
        public String f383669l = "";

        /* renamed from: m, reason: collision with root package name */
        public String f383670m = "";

        /* renamed from: n, reason: collision with root package name */
        public String f383671n = "";

        /* renamed from: o, reason: collision with root package name */
        public String f383672o = "";

        /* renamed from: p, reason: collision with root package name */
        public String f383673p = "";

        /* renamed from: q, reason: collision with root package name */
        public String f383674q = "";

        /* renamed from: r, reason: collision with root package name */
        public String f383675r = "";

        /* renamed from: s, reason: collision with root package name */
        public String f383676s = "";

        /* renamed from: t, reason: collision with root package name */
        public String f383677t = "";

        /* renamed from: u, reason: collision with root package name */
        public List<AdDeviceInfo> f383678u = Internal.newMutableList();

        /* renamed from: v, reason: collision with root package name */
        public String f383679v = "";
        public String A = "";
        public String B = "";
        public String C = "";
        public String D = "";
        public String E = "";
        public String F = "";
        public String G = "";
        public String H = "";
        public String I = "";
        public String J = "";
        public String K = "";
        public String L = "";
        public String M = "";
        public String N = "";
        public String O = "";
        public String P = "";
        public int Q = 0;
        public int R = 0;
        public String T = "";
        public String U = "";
        public String V = "";
        public NetType W = NetType.NET_INVALID;
        public String X = "";

        public a A(String str) {
            this.f383668k = str;
            return this;
        }

        public a B(String str) {
            this.f383662e = str;
            return this;
        }

        public a C(NetType netType) {
            this.W = netType;
            return this;
        }

        public a D(String str) {
            this.f383672o = str;
            return this;
        }

        public a E(String str) {
            this.K = str;
            return this;
        }

        public a F(int i3) {
            this.R = i3;
            return this;
        }

        public a G(String str) {
            this.D = str;
            return this;
        }

        public a H(String str) {
            this.f383677t = str;
            return this;
        }

        public a I(String str) {
            this.f383663f = str;
            return this;
        }

        public a J(String str) {
            this.V = str;
            return this;
        }

        public a K(String str) {
            this.f383660c = str;
            return this;
        }

        public a L(String str) {
            this.U = str;
            return this;
        }

        public a M(String str) {
            this.f383670m = str;
            return this;
        }

        public a N(String str) {
            this.A = str;
            return this;
        }

        public a O(String str) {
            this.T = str;
            return this;
        }

        public a P(String str) {
            this.f383675r = str;
            return this;
        }

        public a Q(String str) {
            this.L = str;
            return this;
        }

        public a R(String str) {
            this.N = str;
            return this;
        }

        public a S(String str) {
            this.B = str;
            return this;
        }

        public a T(String str) {
            this.f383664g = str;
            return this;
        }

        public a a(ADBaseExtraInfo aDBaseExtraInfo) {
            this.S = aDBaseExtraInfo;
            return this;
        }

        public a b(String str) {
            this.f383667j = str;
            return this;
        }

        public a c(String str) {
            this.f383671n = str;
            return this;
        }

        public a d(String str) {
            this.f383661d = str;
            return this;
        }

        public a e(String str) {
            this.f383679v = str;
            return this;
        }

        public a f(String str) {
            this.E = str;
            return this;
        }

        public a g(String str) {
            this.f383665h = str;
            return this;
        }

        public a h(String str) {
            this.C = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public AdPlatformInfo build() {
            return new AdPlatformInfo(this, super.buildUnknownFields());
        }

        public a j(String str) {
            this.X = str;
            return this;
        }

        public a k(String str) {
            this.f383669l = str;
            return this;
        }

        public a l(String str) {
            this.F = str;
            return this;
        }

        public a m(String str) {
            this.H = str;
            return this;
        }

        public a n(String str) {
            this.f383674q = str;
            return this;
        }

        public a o(String str) {
            this.J = str;
            return this;
        }

        public a p(String str) {
            this.O = str;
            return this;
        }

        public a q(String str) {
            this.f383676s = str;
            return this;
        }

        public a r(String str) {
            this.P = str;
            return this;
        }

        public a s(int i3) {
            this.Q = i3;
            return this;
        }

        public a t(String str) {
            this.f383659b = str;
            return this;
        }

        public a u(String str) {
            this.f383658a = str;
            return this;
        }

        public a v(String str) {
            this.M = str;
            return this;
        }

        public a w(String str) {
            this.G = str;
            return this;
        }

        public a x(String str) {
            this.f383666i = str;
            return this;
        }

        public a y(String str) {
            this.f383673p = str;
            return this;
        }

        public a z(String str) {
            this.I = str;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdPlatformInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdPlatformInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdPlatformInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdPlatformInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.u(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.t(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.K(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.B(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.I(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.T(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            aVar.x(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            aVar.A(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 12:
                            aVar.k(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            aVar.M(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 14:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 15:
                            aVar.D(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            aVar.y(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            aVar.n(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 18:
                            aVar.P(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 19:
                            aVar.q(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 20:
                            aVar.H(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 21:
                            aVar.f383678u.add(AdDeviceInfo.ADAPTER.decode(protoReader));
                            break;
                        case 22:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 23:
                            aVar.N(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 24:
                            aVar.S(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 25:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 26:
                            aVar.G(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 27:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 28:
                            aVar.l(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 29:
                            aVar.w(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 30:
                            aVar.m(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 31:
                            aVar.z(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 32:
                            aVar.o(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 33:
                            aVar.E(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 34:
                            aVar.Q(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 35:
                            aVar.v(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 36:
                            aVar.R(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 37:
                            aVar.p(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 38:
                            aVar.r(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 39:
                            aVar.s(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 40:
                            aVar.F(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 41:
                            aVar.a(ADBaseExtraInfo.ADAPTER.decode(protoReader));
                            break;
                        case 42:
                            aVar.O(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 43:
                            aVar.L(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 44:
                            aVar.J(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 45:
                            try {
                                aVar.C(NetType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 46:
                            aVar.j(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            protoReader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdPlatformInfo adPlatformInfo) throws IOException {
            if (!Objects.equals(adPlatformInfo.hw_model, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adPlatformInfo.hw_model);
            }
            if (!Objects.equals(adPlatformInfo.hw_machine, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adPlatformInfo.hw_machine);
            }
            if (!Objects.equals(adPlatformInfo.screen_size, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adPlatformInfo.screen_size);
            }
            if (!Objects.equals(adPlatformInfo.app_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adPlatformInfo.app_id);
            }
            if (!Objects.equals(adPlatformInfo.mobile_network_code, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, adPlatformInfo.mobile_network_code);
            }
            if (!Objects.equals(adPlatformInfo.router_mac_address, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adPlatformInfo.router_mac_address);
            }
            if (!Objects.equals(adPlatformInfo.wifi_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, adPlatformInfo.wifi_name);
            }
            if (!Objects.equals(adPlatformInfo.brands, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, adPlatformInfo.brands);
            }
            if (!Objects.equals(adPlatformInfo.mac_address, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, adPlatformInfo.mac_address);
            }
            if (!Objects.equals(adPlatformInfo.android_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, adPlatformInfo.android_id);
            }
            if (!Objects.equals(adPlatformInfo.mid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, adPlatformInfo.mid);
            }
            if (!Objects.equals(adPlatformInfo.city, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, adPlatformInfo.city);
            }
            if (!Objects.equals(adPlatformInfo.street, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, adPlatformInfo.street);
            }
            if (!Objects.equals(adPlatformInfo.app_channel, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, adPlatformInfo.app_channel);
            }
            if (!Objects.equals(adPlatformInfo.open_udid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, adPlatformInfo.open_udid);
            }
            if (!Objects.equals(adPlatformInfo.manufacturer, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, adPlatformInfo.manufacturer);
            }
            if (!Objects.equals(adPlatformInfo.device_brand_and_model, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 17, adPlatformInfo.device_brand_and_model);
            }
            if (!Objects.equals(adPlatformInfo.taid_ticket, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, adPlatformInfo.taid_ticket);
            }
            if (!Objects.equals(adPlatformInfo.encrypted_oaid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 19, adPlatformInfo.encrypted_oaid);
            }
            if (!Objects.equals(adPlatformInfo.qadid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 20, adPlatformInfo.qadid);
            }
            AdDeviceInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 21, adPlatformInfo.device_info_list);
            if (!Objects.equals(adPlatformInfo.bluetooth_mac, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 22, adPlatformInfo.bluetooth_mac);
            }
            if (!Objects.equals(adPlatformInfo.subscriber_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 23, adPlatformInfo.subscriber_id);
            }
            if (!Objects.equals(adPlatformInfo.uuid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 24, adPlatformInfo.uuid);
            }
            if (!Objects.equals(adPlatformInfo.bssid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 25, adPlatformInfo.bssid);
            }
            if (!Objects.equals(adPlatformInfo.os_version, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 26, adPlatformInfo.os_version);
            }
            if (!Objects.equals(adPlatformInfo.boottime, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 27, adPlatformInfo.boottime);
            }
            if (!Objects.equals(adPlatformInfo.country, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 28, adPlatformInfo.country);
            }
            if (!Objects.equals(adPlatformInfo.language, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 29, adPlatformInfo.language);
            }
            if (!Objects.equals(adPlatformInfo.deviceName, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 30, adPlatformInfo.deviceName);
            }
            if (!Objects.equals(adPlatformInfo.memory, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 31, adPlatformInfo.memory);
            }
            if (!Objects.equals(adPlatformInfo.disk, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 32, adPlatformInfo.disk);
            }
            if (!Objects.equals(adPlatformInfo.osUpgradeTime, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 33, adPlatformInfo.osUpgradeTime);
            }
            if (!Objects.equals(adPlatformInfo.timeZone, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 34, adPlatformInfo.timeZone);
            }
            if (!Objects.equals(adPlatformInfo.idfv, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 35, adPlatformInfo.idfv);
            }
            if (!Objects.equals(adPlatformInfo.user_agent, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 36, adPlatformInfo.user_agent);
            }
            if (!Objects.equals(adPlatformInfo.encrypt_cached_idfa, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 37, adPlatformInfo.encrypt_cached_idfa);
            }
            if (!Objects.equals(adPlatformInfo.harmony_os_version, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 38, adPlatformInfo.harmony_os_version);
            }
            if (!Objects.equals(Integer.valueOf(adPlatformInfo.harmony_pure_mode), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 39, Integer.valueOf(adPlatformInfo.harmony_pure_mode));
            }
            if (!Objects.equals(Integer.valueOf(adPlatformInfo.os_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 40, Integer.valueOf(adPlatformInfo.os_type));
            }
            if (!Objects.equals(adPlatformInfo.ad_base_extra_info, null)) {
                ADBaseExtraInfo.ADAPTER.encodeWithTag(protoWriter, 41, adPlatformInfo.ad_base_extra_info);
            }
            if (!Objects.equals(adPlatformInfo.system_version, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 42, adPlatformInfo.system_version);
            }
            if (!Objects.equals(adPlatformInfo.screen_width, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 43, adPlatformInfo.screen_width);
            }
            if (!Objects.equals(adPlatformInfo.screen_height, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 44, adPlatformInfo.screen_height);
            }
            if (!Objects.equals(adPlatformInfo.net_type, NetType.NET_INVALID)) {
                NetType.ADAPTER.encodeWithTag(protoWriter, 45, adPlatformInfo.net_type);
            }
            if (!Objects.equals(adPlatformInfo.chid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 46, adPlatformInfo.chid);
            }
            protoWriter.writeBytes(adPlatformInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdPlatformInfo adPlatformInfo) {
            int i3 = 0;
            if (!Objects.equals(adPlatformInfo.hw_model, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adPlatformInfo.hw_model);
            }
            if (!Objects.equals(adPlatformInfo.hw_machine, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adPlatformInfo.hw_machine);
            }
            if (!Objects.equals(adPlatformInfo.screen_size, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adPlatformInfo.screen_size);
            }
            if (!Objects.equals(adPlatformInfo.app_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adPlatformInfo.app_id);
            }
            if (!Objects.equals(adPlatformInfo.mobile_network_code, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, adPlatformInfo.mobile_network_code);
            }
            if (!Objects.equals(adPlatformInfo.router_mac_address, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, adPlatformInfo.router_mac_address);
            }
            if (!Objects.equals(adPlatformInfo.wifi_name, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, adPlatformInfo.wifi_name);
            }
            if (!Objects.equals(adPlatformInfo.brands, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(8, adPlatformInfo.brands);
            }
            if (!Objects.equals(adPlatformInfo.mac_address, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(9, adPlatformInfo.mac_address);
            }
            if (!Objects.equals(adPlatformInfo.android_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(10, adPlatformInfo.android_id);
            }
            if (!Objects.equals(adPlatformInfo.mid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(11, adPlatformInfo.mid);
            }
            if (!Objects.equals(adPlatformInfo.city, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(12, adPlatformInfo.city);
            }
            if (!Objects.equals(adPlatformInfo.street, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(13, adPlatformInfo.street);
            }
            if (!Objects.equals(adPlatformInfo.app_channel, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(14, adPlatformInfo.app_channel);
            }
            if (!Objects.equals(adPlatformInfo.open_udid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(15, adPlatformInfo.open_udid);
            }
            if (!Objects.equals(adPlatformInfo.manufacturer, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(16, adPlatformInfo.manufacturer);
            }
            if (!Objects.equals(adPlatformInfo.device_brand_and_model, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(17, adPlatformInfo.device_brand_and_model);
            }
            if (!Objects.equals(adPlatformInfo.taid_ticket, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(18, adPlatformInfo.taid_ticket);
            }
            if (!Objects.equals(adPlatformInfo.encrypted_oaid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(19, adPlatformInfo.encrypted_oaid);
            }
            if (!Objects.equals(adPlatformInfo.qadid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(20, adPlatformInfo.qadid);
            }
            int encodedSizeWithTag = i3 + AdDeviceInfo.ADAPTER.asRepeated().encodedSizeWithTag(21, adPlatformInfo.device_info_list);
            if (!Objects.equals(adPlatformInfo.bluetooth_mac, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(22, adPlatformInfo.bluetooth_mac);
            }
            if (!Objects.equals(adPlatformInfo.subscriber_id, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(23, adPlatformInfo.subscriber_id);
            }
            if (!Objects.equals(adPlatformInfo.uuid, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(24, adPlatformInfo.uuid);
            }
            if (!Objects.equals(adPlatformInfo.bssid, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(25, adPlatformInfo.bssid);
            }
            if (!Objects.equals(adPlatformInfo.os_version, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(26, adPlatformInfo.os_version);
            }
            if (!Objects.equals(adPlatformInfo.boottime, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(27, adPlatformInfo.boottime);
            }
            if (!Objects.equals(adPlatformInfo.country, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(28, adPlatformInfo.country);
            }
            if (!Objects.equals(adPlatformInfo.language, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(29, adPlatformInfo.language);
            }
            if (!Objects.equals(adPlatformInfo.deviceName, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(30, adPlatformInfo.deviceName);
            }
            if (!Objects.equals(adPlatformInfo.memory, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(31, adPlatformInfo.memory);
            }
            if (!Objects.equals(adPlatformInfo.disk, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(32, adPlatformInfo.disk);
            }
            if (!Objects.equals(adPlatformInfo.osUpgradeTime, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(33, adPlatformInfo.osUpgradeTime);
            }
            if (!Objects.equals(adPlatformInfo.timeZone, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(34, adPlatformInfo.timeZone);
            }
            if (!Objects.equals(adPlatformInfo.idfv, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(35, adPlatformInfo.idfv);
            }
            if (!Objects.equals(adPlatformInfo.user_agent, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(36, adPlatformInfo.user_agent);
            }
            if (!Objects.equals(adPlatformInfo.encrypt_cached_idfa, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(37, adPlatformInfo.encrypt_cached_idfa);
            }
            if (!Objects.equals(adPlatformInfo.harmony_os_version, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(38, adPlatformInfo.harmony_os_version);
            }
            if (!Objects.equals(Integer.valueOf(adPlatformInfo.harmony_pure_mode), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(39, Integer.valueOf(adPlatformInfo.harmony_pure_mode));
            }
            if (!Objects.equals(Integer.valueOf(adPlatformInfo.os_type), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(40, Integer.valueOf(adPlatformInfo.os_type));
            }
            if (!Objects.equals(adPlatformInfo.ad_base_extra_info, null)) {
                encodedSizeWithTag += ADBaseExtraInfo.ADAPTER.encodedSizeWithTag(41, adPlatformInfo.ad_base_extra_info);
            }
            if (!Objects.equals(adPlatformInfo.system_version, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(42, adPlatformInfo.system_version);
            }
            if (!Objects.equals(adPlatformInfo.screen_width, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(43, adPlatformInfo.screen_width);
            }
            if (!Objects.equals(adPlatformInfo.screen_height, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(44, adPlatformInfo.screen_height);
            }
            if (!Objects.equals(adPlatformInfo.net_type, NetType.NET_INVALID)) {
                encodedSizeWithTag += NetType.ADAPTER.encodedSizeWithTag(45, adPlatformInfo.net_type);
            }
            if (!Objects.equals(adPlatformInfo.chid, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(46, adPlatformInfo.chid);
            }
            return encodedSizeWithTag + adPlatformInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdPlatformInfo redact(AdPlatformInfo adPlatformInfo) {
            a newBuilder = adPlatformInfo.newBuilder();
            Internal.redactElements(newBuilder.f383678u, AdDeviceInfo.ADAPTER);
            ADBaseExtraInfo aDBaseExtraInfo = newBuilder.S;
            if (aDBaseExtraInfo != null) {
                newBuilder.S = ADBaseExtraInfo.ADAPTER.redact(aDBaseExtraInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdPlatformInfo(a aVar, ByteString byteString) {
        super(ADAPTER, byteString);
        String str = aVar.f383658a;
        if (str != null) {
            this.hw_model = str;
            String str2 = aVar.f383659b;
            if (str2 != null) {
                this.hw_machine = str2;
                String str3 = aVar.f383660c;
                if (str3 != null) {
                    this.screen_size = str3;
                    String str4 = aVar.f383661d;
                    if (str4 != null) {
                        this.app_id = str4;
                        String str5 = aVar.f383662e;
                        if (str5 != null) {
                            this.mobile_network_code = str5;
                            String str6 = aVar.f383663f;
                            if (str6 != null) {
                                this.router_mac_address = str6;
                                String str7 = aVar.f383664g;
                                if (str7 != null) {
                                    this.wifi_name = str7;
                                    String str8 = aVar.f383665h;
                                    if (str8 != null) {
                                        this.brands = str8;
                                        String str9 = aVar.f383666i;
                                        if (str9 != null) {
                                            this.mac_address = str9;
                                            String str10 = aVar.f383667j;
                                            if (str10 != null) {
                                                this.android_id = str10;
                                                String str11 = aVar.f383668k;
                                                if (str11 != null) {
                                                    this.mid = str11;
                                                    String str12 = aVar.f383669l;
                                                    if (str12 != null) {
                                                        this.city = str12;
                                                        String str13 = aVar.f383670m;
                                                        if (str13 != null) {
                                                            this.street = str13;
                                                            String str14 = aVar.f383671n;
                                                            if (str14 != null) {
                                                                this.app_channel = str14;
                                                                String str15 = aVar.f383672o;
                                                                if (str15 != null) {
                                                                    this.open_udid = str15;
                                                                    String str16 = aVar.f383673p;
                                                                    if (str16 != null) {
                                                                        this.manufacturer = str16;
                                                                        String str17 = aVar.f383674q;
                                                                        if (str17 != null) {
                                                                            this.device_brand_and_model = str17;
                                                                            String str18 = aVar.f383675r;
                                                                            if (str18 != null) {
                                                                                this.taid_ticket = str18;
                                                                                String str19 = aVar.f383676s;
                                                                                if (str19 != null) {
                                                                                    this.encrypted_oaid = str19;
                                                                                    String str20 = aVar.f383677t;
                                                                                    if (str20 != null) {
                                                                                        this.qadid = str20;
                                                                                        this.device_info_list = Internal.immutableCopyOf("device_info_list", aVar.f383678u);
                                                                                        String str21 = aVar.f383679v;
                                                                                        if (str21 != null) {
                                                                                            this.bluetooth_mac = str21;
                                                                                            String str22 = aVar.A;
                                                                                            if (str22 != null) {
                                                                                                this.subscriber_id = str22;
                                                                                                String str23 = aVar.B;
                                                                                                if (str23 != null) {
                                                                                                    this.uuid = str23;
                                                                                                    String str24 = aVar.C;
                                                                                                    if (str24 != null) {
                                                                                                        this.bssid = str24;
                                                                                                        String str25 = aVar.D;
                                                                                                        if (str25 != null) {
                                                                                                            this.os_version = str25;
                                                                                                            String str26 = aVar.E;
                                                                                                            if (str26 != null) {
                                                                                                                this.boottime = str26;
                                                                                                                String str27 = aVar.F;
                                                                                                                if (str27 != null) {
                                                                                                                    this.country = str27;
                                                                                                                    String str28 = aVar.G;
                                                                                                                    if (str28 != null) {
                                                                                                                        this.language = str28;
                                                                                                                        String str29 = aVar.H;
                                                                                                                        if (str29 != null) {
                                                                                                                            this.deviceName = str29;
                                                                                                                            String str30 = aVar.I;
                                                                                                                            if (str30 != null) {
                                                                                                                                this.memory = str30;
                                                                                                                                String str31 = aVar.J;
                                                                                                                                if (str31 != null) {
                                                                                                                                    this.disk = str31;
                                                                                                                                    String str32 = aVar.K;
                                                                                                                                    if (str32 != null) {
                                                                                                                                        this.osUpgradeTime = str32;
                                                                                                                                        String str33 = aVar.L;
                                                                                                                                        if (str33 != null) {
                                                                                                                                            this.timeZone = str33;
                                                                                                                                            String str34 = aVar.M;
                                                                                                                                            if (str34 != null) {
                                                                                                                                                this.idfv = str34;
                                                                                                                                                String str35 = aVar.N;
                                                                                                                                                if (str35 != null) {
                                                                                                                                                    this.user_agent = str35;
                                                                                                                                                    String str36 = aVar.O;
                                                                                                                                                    if (str36 != null) {
                                                                                                                                                        this.encrypt_cached_idfa = str36;
                                                                                                                                                        String str37 = aVar.P;
                                                                                                                                                        if (str37 != null) {
                                                                                                                                                            this.harmony_os_version = str37;
                                                                                                                                                            this.harmony_pure_mode = aVar.Q;
                                                                                                                                                            this.os_type = aVar.R;
                                                                                                                                                            this.ad_base_extra_info = aVar.S;
                                                                                                                                                            String str38 = aVar.T;
                                                                                                                                                            if (str38 != null) {
                                                                                                                                                                this.system_version = str38;
                                                                                                                                                                String str39 = aVar.U;
                                                                                                                                                                if (str39 != null) {
                                                                                                                                                                    this.screen_width = str39;
                                                                                                                                                                    String str40 = aVar.V;
                                                                                                                                                                    if (str40 != null) {
                                                                                                                                                                        this.screen_height = str40;
                                                                                                                                                                        NetType netType = aVar.W;
                                                                                                                                                                        if (netType != null) {
                                                                                                                                                                            this.net_type = netType;
                                                                                                                                                                            String str41 = aVar.X;
                                                                                                                                                                            if (str41 != null) {
                                                                                                                                                                                this.chid = str41;
                                                                                                                                                                                return;
                                                                                                                                                                            }
                                                                                                                                                                            throw new IllegalArgumentException("builder.chid == null");
                                                                                                                                                                        }
                                                                                                                                                                        throw new IllegalArgumentException("builder.net_type == null");
                                                                                                                                                                    }
                                                                                                                                                                    throw new IllegalArgumentException("builder.screen_height == null");
                                                                                                                                                                }
                                                                                                                                                                throw new IllegalArgumentException("builder.screen_width == null");
                                                                                                                                                            }
                                                                                                                                                            throw new IllegalArgumentException("builder.system_version == null");
                                                                                                                                                        }
                                                                                                                                                        throw new IllegalArgumentException("builder.harmony_os_version == null");
                                                                                                                                                    }
                                                                                                                                                    throw new IllegalArgumentException("builder.encrypt_cached_idfa == null");
                                                                                                                                                }
                                                                                                                                                throw new IllegalArgumentException("builder.user_agent == null");
                                                                                                                                            }
                                                                                                                                            throw new IllegalArgumentException("builder.idfv == null");
                                                                                                                                        }
                                                                                                                                        throw new IllegalArgumentException("builder.timeZone == null");
                                                                                                                                    }
                                                                                                                                    throw new IllegalArgumentException("builder.osUpgradeTime == null");
                                                                                                                                }
                                                                                                                                throw new IllegalArgumentException("builder.disk == null");
                                                                                                                            }
                                                                                                                            throw new IllegalArgumentException("builder.memory == null");
                                                                                                                        }
                                                                                                                        throw new IllegalArgumentException("builder.deviceName == null");
                                                                                                                    }
                                                                                                                    throw new IllegalArgumentException("builder.language == null");
                                                                                                                }
                                                                                                                throw new IllegalArgumentException("builder.country == null");
                                                                                                            }
                                                                                                            throw new IllegalArgumentException("builder.boottime == null");
                                                                                                        }
                                                                                                        throw new IllegalArgumentException("builder.os_version == null");
                                                                                                    }
                                                                                                    throw new IllegalArgumentException("builder.bssid == null");
                                                                                                }
                                                                                                throw new IllegalArgumentException("builder.uuid == null");
                                                                                            }
                                                                                            throw new IllegalArgumentException("builder.subscriber_id == null");
                                                                                        }
                                                                                        throw new IllegalArgumentException("builder.bluetooth_mac == null");
                                                                                    }
                                                                                    throw new IllegalArgumentException("builder.qadid == null");
                                                                                }
                                                                                throw new IllegalArgumentException("builder.encrypted_oaid == null");
                                                                            }
                                                                            throw new IllegalArgumentException("builder.taid_ticket == null");
                                                                        }
                                                                        throw new IllegalArgumentException("builder.device_brand_and_model == null");
                                                                    }
                                                                    throw new IllegalArgumentException("builder.manufacturer == null");
                                                                }
                                                                throw new IllegalArgumentException("builder.open_udid == null");
                                                            }
                                                            throw new IllegalArgumentException("builder.app_channel == null");
                                                        }
                                                        throw new IllegalArgumentException("builder.street == null");
                                                    }
                                                    throw new IllegalArgumentException("builder.city == null");
                                                }
                                                throw new IllegalArgumentException("builder.mid == null");
                                            }
                                            throw new IllegalArgumentException("builder.android_id == null");
                                        }
                                        throw new IllegalArgumentException("builder.mac_address == null");
                                    }
                                    throw new IllegalArgumentException("builder.brands == null");
                                }
                                throw new IllegalArgumentException("builder.wifi_name == null");
                            }
                            throw new IllegalArgumentException("builder.router_mac_address == null");
                        }
                        throw new IllegalArgumentException("builder.mobile_network_code == null");
                    }
                    throw new IllegalArgumentException("builder.app_id == null");
                }
                throw new IllegalArgumentException("builder.screen_size == null");
            }
            throw new IllegalArgumentException("builder.hw_machine == null");
        }
        throw new IllegalArgumentException("builder.hw_model == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdPlatformInfo)) {
            return false;
        }
        AdPlatformInfo adPlatformInfo = (AdPlatformInfo) obj;
        if (unknownFields().equals(adPlatformInfo.unknownFields()) && Internal.equals(this.hw_model, adPlatformInfo.hw_model) && Internal.equals(this.hw_machine, adPlatformInfo.hw_machine) && Internal.equals(this.screen_size, adPlatformInfo.screen_size) && Internal.equals(this.app_id, adPlatformInfo.app_id) && Internal.equals(this.mobile_network_code, adPlatformInfo.mobile_network_code) && Internal.equals(this.router_mac_address, adPlatformInfo.router_mac_address) && Internal.equals(this.wifi_name, adPlatformInfo.wifi_name) && Internal.equals(this.brands, adPlatformInfo.brands) && Internal.equals(this.mac_address, adPlatformInfo.mac_address) && Internal.equals(this.android_id, adPlatformInfo.android_id) && Internal.equals(this.mid, adPlatformInfo.mid) && Internal.equals(this.city, adPlatformInfo.city) && Internal.equals(this.street, adPlatformInfo.street) && Internal.equals(this.app_channel, adPlatformInfo.app_channel) && Internal.equals(this.open_udid, adPlatformInfo.open_udid) && Internal.equals(this.manufacturer, adPlatformInfo.manufacturer) && Internal.equals(this.device_brand_and_model, adPlatformInfo.device_brand_and_model) && Internal.equals(this.taid_ticket, adPlatformInfo.taid_ticket) && Internal.equals(this.encrypted_oaid, adPlatformInfo.encrypted_oaid) && Internal.equals(this.qadid, adPlatformInfo.qadid) && this.device_info_list.equals(adPlatformInfo.device_info_list) && Internal.equals(this.bluetooth_mac, adPlatformInfo.bluetooth_mac) && Internal.equals(this.subscriber_id, adPlatformInfo.subscriber_id) && Internal.equals(this.uuid, adPlatformInfo.uuid) && Internal.equals(this.bssid, adPlatformInfo.bssid) && Internal.equals(this.os_version, adPlatformInfo.os_version) && Internal.equals(this.boottime, adPlatformInfo.boottime) && Internal.equals(this.country, adPlatformInfo.country) && Internal.equals(this.language, adPlatformInfo.language) && Internal.equals(this.deviceName, adPlatformInfo.deviceName) && Internal.equals(this.memory, adPlatformInfo.memory) && Internal.equals(this.disk, adPlatformInfo.disk) && Internal.equals(this.osUpgradeTime, adPlatformInfo.osUpgradeTime) && Internal.equals(this.timeZone, adPlatformInfo.timeZone) && Internal.equals(this.idfv, adPlatformInfo.idfv) && Internal.equals(this.user_agent, adPlatformInfo.user_agent) && Internal.equals(this.encrypt_cached_idfa, adPlatformInfo.encrypt_cached_idfa) && Internal.equals(this.harmony_os_version, adPlatformInfo.harmony_os_version) && Internal.equals(Integer.valueOf(this.harmony_pure_mode), Integer.valueOf(adPlatformInfo.harmony_pure_mode)) && Internal.equals(Integer.valueOf(this.os_type), Integer.valueOf(adPlatformInfo.os_type)) && Internal.equals(this.ad_base_extra_info, adPlatformInfo.ad_base_extra_info) && Internal.equals(this.system_version, adPlatformInfo.system_version) && Internal.equals(this.screen_width, adPlatformInfo.screen_width) && Internal.equals(this.screen_height, adPlatformInfo.screen_height) && Internal.equals(this.net_type, adPlatformInfo.net_type) && Internal.equals(this.chid, adPlatformInfo.chid)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        int i67;
        int i68;
        int i69;
        int i75;
        int i76;
        int i77;
        int i78;
        int i79;
        int i85;
        int i86;
        int i87;
        int i88;
        int i89;
        int i95;
        int i96;
        int i97;
        int i98;
        int i99;
        int i100;
        int i101 = this.hashCode;
        if (i101 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.hw_model;
            int i102 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i103 = (hashCode + i3) * 37;
            String str2 = this.hw_machine;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i104 = (i103 + i16) * 37;
            String str3 = this.screen_size;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i105 = (i104 + i17) * 37;
            String str4 = this.app_id;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i106 = (i105 + i18) * 37;
            String str5 = this.mobile_network_code;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i107 = (i106 + i19) * 37;
            String str6 = this.router_mac_address;
            if (str6 != null) {
                i26 = str6.hashCode();
            } else {
                i26 = 0;
            }
            int i108 = (i107 + i26) * 37;
            String str7 = this.wifi_name;
            if (str7 != null) {
                i27 = str7.hashCode();
            } else {
                i27 = 0;
            }
            int i109 = (i108 + i27) * 37;
            String str8 = this.brands;
            if (str8 != null) {
                i28 = str8.hashCode();
            } else {
                i28 = 0;
            }
            int i110 = (i109 + i28) * 37;
            String str9 = this.mac_address;
            if (str9 != null) {
                i29 = str9.hashCode();
            } else {
                i29 = 0;
            }
            int i111 = (i110 + i29) * 37;
            String str10 = this.android_id;
            if (str10 != null) {
                i36 = str10.hashCode();
            } else {
                i36 = 0;
            }
            int i112 = (i111 + i36) * 37;
            String str11 = this.mid;
            if (str11 != null) {
                i37 = str11.hashCode();
            } else {
                i37 = 0;
            }
            int i113 = (i112 + i37) * 37;
            String str12 = this.city;
            if (str12 != null) {
                i38 = str12.hashCode();
            } else {
                i38 = 0;
            }
            int i114 = (i113 + i38) * 37;
            String str13 = this.street;
            if (str13 != null) {
                i39 = str13.hashCode();
            } else {
                i39 = 0;
            }
            int i115 = (i114 + i39) * 37;
            String str14 = this.app_channel;
            if (str14 != null) {
                i46 = str14.hashCode();
            } else {
                i46 = 0;
            }
            int i116 = (i115 + i46) * 37;
            String str15 = this.open_udid;
            if (str15 != null) {
                i47 = str15.hashCode();
            } else {
                i47 = 0;
            }
            int i117 = (i116 + i47) * 37;
            String str16 = this.manufacturer;
            if (str16 != null) {
                i48 = str16.hashCode();
            } else {
                i48 = 0;
            }
            int i118 = (i117 + i48) * 37;
            String str17 = this.device_brand_and_model;
            if (str17 != null) {
                i49 = str17.hashCode();
            } else {
                i49 = 0;
            }
            int i119 = (i118 + i49) * 37;
            String str18 = this.taid_ticket;
            if (str18 != null) {
                i56 = str18.hashCode();
            } else {
                i56 = 0;
            }
            int i120 = (i119 + i56) * 37;
            String str19 = this.encrypted_oaid;
            if (str19 != null) {
                i57 = str19.hashCode();
            } else {
                i57 = 0;
            }
            int i121 = (i120 + i57) * 37;
            String str20 = this.qadid;
            if (str20 != null) {
                i58 = str20.hashCode();
            } else {
                i58 = 0;
            }
            int hashCode2 = (((i121 + i58) * 37) + this.device_info_list.hashCode()) * 37;
            String str21 = this.bluetooth_mac;
            if (str21 != null) {
                i59 = str21.hashCode();
            } else {
                i59 = 0;
            }
            int i122 = (hashCode2 + i59) * 37;
            String str22 = this.subscriber_id;
            if (str22 != null) {
                i65 = str22.hashCode();
            } else {
                i65 = 0;
            }
            int i123 = (i122 + i65) * 37;
            String str23 = this.uuid;
            if (str23 != null) {
                i66 = str23.hashCode();
            } else {
                i66 = 0;
            }
            int i124 = (i123 + i66) * 37;
            String str24 = this.bssid;
            if (str24 != null) {
                i67 = str24.hashCode();
            } else {
                i67 = 0;
            }
            int i125 = (i124 + i67) * 37;
            String str25 = this.os_version;
            if (str25 != null) {
                i68 = str25.hashCode();
            } else {
                i68 = 0;
            }
            int i126 = (i125 + i68) * 37;
            String str26 = this.boottime;
            if (str26 != null) {
                i69 = str26.hashCode();
            } else {
                i69 = 0;
            }
            int i127 = (i126 + i69) * 37;
            String str27 = this.country;
            if (str27 != null) {
                i75 = str27.hashCode();
            } else {
                i75 = 0;
            }
            int i128 = (i127 + i75) * 37;
            String str28 = this.language;
            if (str28 != null) {
                i76 = str28.hashCode();
            } else {
                i76 = 0;
            }
            int i129 = (i128 + i76) * 37;
            String str29 = this.deviceName;
            if (str29 != null) {
                i77 = str29.hashCode();
            } else {
                i77 = 0;
            }
            int i130 = (i129 + i77) * 37;
            String str30 = this.memory;
            if (str30 != null) {
                i78 = str30.hashCode();
            } else {
                i78 = 0;
            }
            int i131 = (i130 + i78) * 37;
            String str31 = this.disk;
            if (str31 != null) {
                i79 = str31.hashCode();
            } else {
                i79 = 0;
            }
            int i132 = (i131 + i79) * 37;
            String str32 = this.osUpgradeTime;
            if (str32 != null) {
                i85 = str32.hashCode();
            } else {
                i85 = 0;
            }
            int i133 = (i132 + i85) * 37;
            String str33 = this.timeZone;
            if (str33 != null) {
                i86 = str33.hashCode();
            } else {
                i86 = 0;
            }
            int i134 = (i133 + i86) * 37;
            String str34 = this.idfv;
            if (str34 != null) {
                i87 = str34.hashCode();
            } else {
                i87 = 0;
            }
            int i135 = (i134 + i87) * 37;
            String str35 = this.user_agent;
            if (str35 != null) {
                i88 = str35.hashCode();
            } else {
                i88 = 0;
            }
            int i136 = (i135 + i88) * 37;
            String str36 = this.encrypt_cached_idfa;
            if (str36 != null) {
                i89 = str36.hashCode();
            } else {
                i89 = 0;
            }
            int i137 = (i136 + i89) * 37;
            String str37 = this.harmony_os_version;
            if (str37 != null) {
                i95 = str37.hashCode();
            } else {
                i95 = 0;
            }
            int i138 = (((((i137 + i95) * 37) + this.harmony_pure_mode) * 37) + this.os_type) * 37;
            ADBaseExtraInfo aDBaseExtraInfo = this.ad_base_extra_info;
            if (aDBaseExtraInfo != null) {
                i96 = aDBaseExtraInfo.hashCode();
            } else {
                i96 = 0;
            }
            int i139 = (i138 + i96) * 37;
            String str38 = this.system_version;
            if (str38 != null) {
                i97 = str38.hashCode();
            } else {
                i97 = 0;
            }
            int i140 = (i139 + i97) * 37;
            String str39 = this.screen_width;
            if (str39 != null) {
                i98 = str39.hashCode();
            } else {
                i98 = 0;
            }
            int i141 = (i140 + i98) * 37;
            String str40 = this.screen_height;
            if (str40 != null) {
                i99 = str40.hashCode();
            } else {
                i99 = 0;
            }
            int i142 = (i141 + i99) * 37;
            NetType netType = this.net_type;
            if (netType != null) {
                i100 = netType.hashCode();
            } else {
                i100 = 0;
            }
            int i143 = (i142 + i100) * 37;
            String str41 = this.chid;
            if (str41 != null) {
                i102 = str41.hashCode();
            }
            int i144 = i143 + i102;
            this.hashCode = i144;
            return i144;
        }
        return i101;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.hw_model != null) {
            sb5.append(", hw_model=");
            sb5.append(Internal.sanitize(this.hw_model));
        }
        if (this.hw_machine != null) {
            sb5.append(", hw_machine=");
            sb5.append(Internal.sanitize(this.hw_machine));
        }
        if (this.screen_size != null) {
            sb5.append(", screen_size=");
            sb5.append(Internal.sanitize(this.screen_size));
        }
        if (this.app_id != null) {
            sb5.append(", app_id=");
            sb5.append(Internal.sanitize(this.app_id));
        }
        if (this.mobile_network_code != null) {
            sb5.append(", mobile_network_code=");
            sb5.append(Internal.sanitize(this.mobile_network_code));
        }
        if (this.router_mac_address != null) {
            sb5.append(", router_mac_address=");
            sb5.append(Internal.sanitize(this.router_mac_address));
        }
        if (this.wifi_name != null) {
            sb5.append(", wifi_name=");
            sb5.append(Internal.sanitize(this.wifi_name));
        }
        if (this.brands != null) {
            sb5.append(", brands=");
            sb5.append(Internal.sanitize(this.brands));
        }
        if (this.mac_address != null) {
            sb5.append(", mac_address=");
            sb5.append(Internal.sanitize(this.mac_address));
        }
        if (this.android_id != null) {
            sb5.append(", android_id=");
            sb5.append(Internal.sanitize(this.android_id));
        }
        if (this.mid != null) {
            sb5.append(", mid=");
            sb5.append(Internal.sanitize(this.mid));
        }
        if (this.city != null) {
            sb5.append(", city=");
            sb5.append(Internal.sanitize(this.city));
        }
        if (this.street != null) {
            sb5.append(", street=");
            sb5.append(Internal.sanitize(this.street));
        }
        if (this.app_channel != null) {
            sb5.append(", app_channel=");
            sb5.append(Internal.sanitize(this.app_channel));
        }
        if (this.open_udid != null) {
            sb5.append(", open_udid=");
            sb5.append(Internal.sanitize(this.open_udid));
        }
        if (this.manufacturer != null) {
            sb5.append(", manufacturer=");
            sb5.append(Internal.sanitize(this.manufacturer));
        }
        if (this.device_brand_and_model != null) {
            sb5.append(", device_brand_and_model=");
            sb5.append(Internal.sanitize(this.device_brand_and_model));
        }
        if (this.taid_ticket != null) {
            sb5.append(", taid_ticket=");
            sb5.append(Internal.sanitize(this.taid_ticket));
        }
        if (this.encrypted_oaid != null) {
            sb5.append(", encrypted_oaid=");
            sb5.append(Internal.sanitize(this.encrypted_oaid));
        }
        if (this.qadid != null) {
            sb5.append(", qadid=");
            sb5.append(Internal.sanitize(this.qadid));
        }
        if (!this.device_info_list.isEmpty()) {
            sb5.append(", device_info_list=");
            sb5.append(this.device_info_list);
        }
        if (this.bluetooth_mac != null) {
            sb5.append(", bluetooth_mac=");
            sb5.append(Internal.sanitize(this.bluetooth_mac));
        }
        if (this.subscriber_id != null) {
            sb5.append(", subscriber_id=");
            sb5.append(Internal.sanitize(this.subscriber_id));
        }
        if (this.uuid != null) {
            sb5.append(", uuid=");
            sb5.append(Internal.sanitize(this.uuid));
        }
        if (this.bssid != null) {
            sb5.append(", bssid=");
            sb5.append(Internal.sanitize(this.bssid));
        }
        if (this.os_version != null) {
            sb5.append(", os_version=");
            sb5.append(Internal.sanitize(this.os_version));
        }
        if (this.boottime != null) {
            sb5.append(", boottime=");
            sb5.append(Internal.sanitize(this.boottime));
        }
        if (this.country != null) {
            sb5.append(", country=");
            sb5.append(Internal.sanitize(this.country));
        }
        if (this.language != null) {
            sb5.append(", language=");
            sb5.append(Internal.sanitize(this.language));
        }
        if (this.deviceName != null) {
            sb5.append(", deviceName=");
            sb5.append(Internal.sanitize(this.deviceName));
        }
        if (this.memory != null) {
            sb5.append(", memory=");
            sb5.append(Internal.sanitize(this.memory));
        }
        if (this.disk != null) {
            sb5.append(", disk=");
            sb5.append(Internal.sanitize(this.disk));
        }
        if (this.osUpgradeTime != null) {
            sb5.append(", osUpgradeTime=");
            sb5.append(Internal.sanitize(this.osUpgradeTime));
        }
        if (this.timeZone != null) {
            sb5.append(", timeZone=");
            sb5.append(Internal.sanitize(this.timeZone));
        }
        if (this.idfv != null) {
            sb5.append(", idfv=");
            sb5.append(Internal.sanitize(this.idfv));
        }
        if (this.user_agent != null) {
            sb5.append(", user_agent=");
            sb5.append(Internal.sanitize(this.user_agent));
        }
        if (this.encrypt_cached_idfa != null) {
            sb5.append(", encrypt_cached_idfa=");
            sb5.append(Internal.sanitize(this.encrypt_cached_idfa));
        }
        if (this.harmony_os_version != null) {
            sb5.append(", harmony_os_version=");
            sb5.append(Internal.sanitize(this.harmony_os_version));
        }
        sb5.append(", harmony_pure_mode=");
        sb5.append(this.harmony_pure_mode);
        sb5.append(", os_type=");
        sb5.append(this.os_type);
        if (this.ad_base_extra_info != null) {
            sb5.append(", ad_base_extra_info=");
            sb5.append(this.ad_base_extra_info);
        }
        if (this.system_version != null) {
            sb5.append(", system_version=");
            sb5.append(Internal.sanitize(this.system_version));
        }
        if (this.screen_width != null) {
            sb5.append(", screen_width=");
            sb5.append(Internal.sanitize(this.screen_width));
        }
        if (this.screen_height != null) {
            sb5.append(", screen_height=");
            sb5.append(Internal.sanitize(this.screen_height));
        }
        if (this.net_type != null) {
            sb5.append(", net_type=");
            sb5.append(this.net_type);
        }
        if (this.chid != null) {
            sb5.append(", chid=");
            sb5.append(Internal.sanitize(this.chid));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdPlatformInfo{");
        replace.append('}');
        return replace.toString();
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383658a = this.hw_model;
        aVar.f383659b = this.hw_machine;
        aVar.f383660c = this.screen_size;
        aVar.f383661d = this.app_id;
        aVar.f383662e = this.mobile_network_code;
        aVar.f383663f = this.router_mac_address;
        aVar.f383664g = this.wifi_name;
        aVar.f383665h = this.brands;
        aVar.f383666i = this.mac_address;
        aVar.f383667j = this.android_id;
        aVar.f383668k = this.mid;
        aVar.f383669l = this.city;
        aVar.f383670m = this.street;
        aVar.f383671n = this.app_channel;
        aVar.f383672o = this.open_udid;
        aVar.f383673p = this.manufacturer;
        aVar.f383674q = this.device_brand_and_model;
        aVar.f383675r = this.taid_ticket;
        aVar.f383676s = this.encrypted_oaid;
        aVar.f383677t = this.qadid;
        aVar.f383678u = Internal.copyOf(this.device_info_list);
        aVar.f383679v = this.bluetooth_mac;
        aVar.A = this.subscriber_id;
        aVar.B = this.uuid;
        aVar.C = this.bssid;
        aVar.D = this.os_version;
        aVar.E = this.boottime;
        aVar.F = this.country;
        aVar.G = this.language;
        aVar.H = this.deviceName;
        aVar.I = this.memory;
        aVar.J = this.disk;
        aVar.K = this.osUpgradeTime;
        aVar.L = this.timeZone;
        aVar.M = this.idfv;
        aVar.N = this.user_agent;
        aVar.O = this.encrypt_cached_idfa;
        aVar.P = this.harmony_os_version;
        aVar.Q = this.harmony_pure_mode;
        aVar.R = this.os_type;
        aVar.S = this.ad_base_extra_info;
        aVar.T = this.system_version;
        aVar.U = this.screen_width;
        aVar.V = this.screen_height;
        aVar.W = this.net_type;
        aVar.X = this.chid;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
