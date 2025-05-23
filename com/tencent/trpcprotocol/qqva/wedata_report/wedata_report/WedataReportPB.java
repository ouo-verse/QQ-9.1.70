package com.tencent.trpcprotocol.qqva.wedata_report.wedata_report;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.al;
import com.google.protobuf.ar;
import com.google.protobuf.ax;
import com.google.protobuf.bg;
import com.google.protobuf.bp;
import com.google.protobuf.c;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.t;
import com.tencent.luggage.wxa.gg.e;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes27.dex */
public final class WedataReportPB {

    /* renamed from: a, reason: collision with root package name */
    private static final Descriptors.b f381647a;

    /* renamed from: b, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381648b;

    /* renamed from: c, reason: collision with root package name */
    private static final Descriptors.b f381649c;

    /* renamed from: d, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381650d;

    /* renamed from: e, reason: collision with root package name */
    private static final Descriptors.b f381651e;

    /* renamed from: f, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381652f;

    /* renamed from: g, reason: collision with root package name */
    private static final Descriptors.b f381653g;

    /* renamed from: h, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381654h;

    /* renamed from: i, reason: collision with root package name */
    private static Descriptors.FileDescriptor f381655i = Descriptors.FileDescriptor.u(new String[]{"\n%negative-feedback/wedata_report.proto\u0012\u0017trpc.qqva.wedata_report\"R\n\tReportReq\u0012\u0013\n\u000breport_type\u0018\u0001 \u0001(\t\u00120\n\titem_list\u0018\u0002 \u0003(\u000b2\u001d.trpc.qqva.wedata_report.Item\"g\n\u0004Item\u00123\n\u0003kvs\u0018\u0001 \u0003(\u000b2&.trpc.qqva.wedata_report.Item.KvsEntry\u001a*\n\bKvsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"\u000b\n\tReportRsp2`\n\fWedataReport\u0012P\n\u0006Report\u0012\".trpc.qqva.wedata_report.ReportReq\u001a\".trpc.qqva.wedata_report.ReportRspBz\n9com.tencent.trpcprotocol.qqva.wedata_report.wedata_reportB\u000eWedataReportPBP\u0000Z+git.woa.com/trpcprotocol/qqva/wedata_reportb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: classes27.dex */
    public static final class Item extends GeneratedMessageV3 implements b {
        public static final int KVS_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final Item f381656d = new Item();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<Item> f381657e = new a();
        private static final long serialVersionUID = 0;
        private MapField<String, String> kvs_;
        private byte memoizedIsInitialized;

        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<Item> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public Item g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new Item(kVar, tVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes27.dex */
        public static final class c {

            /* renamed from: a, reason: collision with root package name */
            static final al<String, String> f381659a;

            static {
                Descriptors.b bVar = WedataReportPB.f381651e;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                f381659a = al.v(bVar, fieldType, "", fieldType, "");
            }
        }

        public static Item getDefaultInstance() {
            return f381656d;
        }

        public static final Descriptors.b getDescriptor() {
            return WedataReportPB.f381649c;
        }

        public static b newBuilder() {
            return f381656d.toBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, String> p() {
            MapField<String, String> mapField = this.kvs_;
            if (mapField == null) {
                return MapField.h(c.f381659a);
            }
            return mapField;
        }

        public static Item parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Item) GeneratedMessageV3.parseDelimitedWithIOException(f381657e, inputStream);
        }

        public static Item parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381657e.d(byteBuffer);
        }

        public static bg<Item> parser() {
            return f381657e;
        }

        public boolean containsKvs(String str) {
            str.getClass();
            return p().j().containsKey(str);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return super.equals(obj);
            }
            Item item = (Item) obj;
            if (p().equals(item.p()) && this.unknownFields.equals(item.unknownFields)) {
                return true;
            }
            return false;
        }

        @Deprecated
        public Map<String, String> getKvs() {
            return getKvsMap();
        }

        public int getKvsCount() {
            return p().j().size();
        }

        public Map<String, String> getKvsMap() {
            return p().j();
        }

        public String getKvsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> j3 = p().j();
            if (j3.containsKey(str)) {
                return j3.get(str);
            }
            return str2;
        }

        public String getKvsOrThrow(String str) {
            str.getClass();
            Map<String, String> j3 = p().j();
            if (j3.containsKey(str)) {
                return j3.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<Item> getParserForType() {
            return f381657e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (Map.Entry<String, String> entry : p().j().entrySet()) {
                i16 += CodedOutputStream.G(1, c.f381659a.newBuilderForType().n(entry.getKey()).p(entry.getValue()).build());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = e.CTRL_INDEX + getDescriptor().hashCode();
            if (!p().j().isEmpty()) {
                hashCode = (((hashCode * 37) + 1) * 53) + p().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return WedataReportPB.f381650d.e(Item.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected MapField internalGetMapField(int i3) {
            if (i3 == 1) {
                return p();
            }
            throw new RuntimeException("Invalid map field number: " + i3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new Item();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, p(), c.f381659a, 1);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements b {

            /* renamed from: i, reason: collision with root package name */
            private MapField<String, String> f381658i;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            private MapField<String, String> v() {
                MapField<String, String> mapField = this.f381658i;
                if (mapField == null) {
                    return MapField.h(c.f381659a);
                }
                return mapField;
            }

            private MapField<String, String> w() {
                onChanged();
                if (this.f381658i == null) {
                    this.f381658i = MapField.q(c.f381659a);
                }
                if (!this.f381658i.n()) {
                    this.f381658i = this.f381658i.g();
                }
                return this.f381658i;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b B(Map<String, String> map) {
                w().m().putAll(map);
                return this;
            }

            public b C(String str, String str2) {
                str.getClass();
                str2.getClass();
                w().m().put(str, str2);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return WedataReportPB.f381649c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return WedataReportPB.f381650d.e(Item.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected MapField internalGetMapField(int i3) {
                if (i3 == 1) {
                    return v();
                }
                throw new RuntimeException("Invalid map field number: " + i3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected MapField internalGetMutableMapField(int i3) {
                if (i3 == 1) {
                    return w();
                }
                throw new RuntimeException("Invalid map field number: " + i3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public Item build() {
                Item buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public Item buildPartial() {
                Item item = new Item(this);
                item.kvs_ = v();
                item.kvs_.o();
                onBuilt();
                return item;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                w().b();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public Item getDefaultInstanceForType() {
                return Item.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                Item item = null;
                try {
                    try {
                        Item item2 = (Item) Item.f381657e.g(kVar, tVar);
                        if (item2 != null) {
                            z(item2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        Item item3 = (Item) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            item = item3;
                            if (item != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (item != null) {
                        z(item);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof Item) {
                    return z((Item) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b z(Item item) {
                if (item == Item.getDefaultInstance()) {
                    return this;
                }
                w().p(item.p());
                mo52mergeUnknownFields(((GeneratedMessageV3) item).unknownFields);
                onChanged();
                return this;
            }

            b() {
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(Item item) {
            return f381656d.toBuilder().z(item);
        }

        public static Item parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381657e.m(byteBuffer, tVar);
        }

        Item(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Item parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (Item) GeneratedMessageV3.parseDelimitedWithIOException(f381657e, inputStream, tVar);
        }

        public static Item parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381657e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public Item getDefaultInstanceForType() {
            return f381656d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381656d ? new b() : new b().z(this);
        }

        public static Item parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381657e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        Item() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Item parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381657e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static Item parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381657e.i(bArr, tVar);
        }

        Item(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J != 10) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    if (!(z17 & true)) {
                                        this.kvs_ = MapField.q(c.f381659a);
                                        z17 |= true;
                                    }
                                    al alVar = (al) kVar.z(c.f381659a.getParserForType(), tVar);
                                    this.kvs_.m().put((String) alVar.q(), (String) alVar.s());
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        }
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static Item parseFrom(InputStream inputStream) throws IOException {
            return (Item) GeneratedMessageV3.parseWithIOException(f381657e, inputStream);
        }

        public static Item parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (Item) GeneratedMessageV3.parseWithIOException(f381657e, inputStream, tVar);
        }

        public static Item parseFrom(k kVar) throws IOException {
            return (Item) GeneratedMessageV3.parseWithIOException(f381657e, kVar);
        }

        public static Item parseFrom(k kVar, t tVar) throws IOException {
            return (Item) GeneratedMessageV3.parseWithIOException(f381657e, kVar, tVar);
        }
    }

    /* loaded from: classes27.dex */
    public static final class ReportReq extends GeneratedMessageV3 implements ax {
        public static final int ITEM_LIST_FIELD_NUMBER = 2;
        public static final int REPORT_TYPE_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final ReportReq f381660d = new ReportReq();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ReportReq> f381661e = new a();
        private static final long serialVersionUID = 0;
        private List<Item> itemList_;
        private byte memoizedIsInitialized;
        private volatile Object reportType_;

        /* loaded from: classes27.dex */
        class a extends c<ReportReq> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ReportReq g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ReportReq(kVar, tVar);
            }
        }

        public static ReportReq getDefaultInstance() {
            return f381660d;
        }

        public static final Descriptors.b getDescriptor() {
            return WedataReportPB.f381647a;
        }

        public static b newBuilder() {
            return f381660d.toBuilder();
        }

        public static ReportReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReportReq) GeneratedMessageV3.parseDelimitedWithIOException(f381661e, inputStream);
        }

        public static ReportReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381661e.d(byteBuffer);
        }

        public static bg<ReportReq> parser() {
            return f381661e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ReportReq)) {
                return super.equals(obj);
            }
            ReportReq reportReq = (ReportReq) obj;
            if (getReportType().equals(reportReq.getReportType()) && getItemListList().equals(reportReq.getItemListList()) && this.unknownFields.equals(reportReq.unknownFields)) {
                return true;
            }
            return false;
        }

        public Item getItemList(int i3) {
            return this.itemList_.get(i3);
        }

        public int getItemListCount() {
            return this.itemList_.size();
        }

        public List<Item> getItemListList() {
            return this.itemList_;
        }

        public b getItemListOrBuilder(int i3) {
            return this.itemList_.get(i3);
        }

        public List<? extends b> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ReportReq> getParserForType() {
            return f381661e;
        }

        public String getReportType() {
            Object obj = this.reportType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reportType_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getReportTypeBytes() {
            Object obj = this.reportType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reportType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if (!getReportTypeBytes().isEmpty()) {
                i3 = GeneratedMessageV3.computeStringSize(1, this.reportType_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.itemList_.size(); i17++) {
                i3 += CodedOutputStream.G(2, this.itemList_.get(i17));
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = ((((e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getReportType().hashCode();
            if (getItemListCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getItemListList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return WedataReportPB.f381648b.e(ReportReq.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new ReportReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getReportTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.reportType_);
            }
            for (int i3 = 0; i3 < this.itemList_.size(); i3++) {
                codedOutputStream.K0(2, this.itemList_.get(i3));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements ax {
            private List<Item> C;
            private bp<Item, Item.b, b> D;

            /* renamed from: i, reason: collision with root package name */
            private int f381662i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381663m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    x();
                }
            }

            private void v() {
                if ((this.f381662i & 1) == 0) {
                    this.C = new ArrayList(this.C);
                    this.f381662i |= 1;
                }
            }

            private bp<Item, Item.b, b> x() {
                if (this.D == null) {
                    List<Item> list = this.C;
                    boolean z16 = true;
                    if ((this.f381662i & 1) == 0) {
                        z16 = false;
                    }
                    this.D = new bp<>(list, z16, h(), isClean());
                    this.C = null;
                }
                return this.D;
            }

            public b A(ReportReq reportReq) {
                if (reportReq == ReportReq.getDefaultInstance()) {
                    return this;
                }
                if (!reportReq.getReportType().isEmpty()) {
                    this.f381663m = reportReq.reportType_;
                    onChanged();
                }
                if (this.D == null) {
                    if (!reportReq.itemList_.isEmpty()) {
                        if (this.C.isEmpty()) {
                            this.C = reportReq.itemList_;
                            this.f381662i &= -2;
                        } else {
                            v();
                            this.C.addAll(reportReq.itemList_);
                        }
                        onChanged();
                    }
                } else if (!reportReq.itemList_.isEmpty()) {
                    if (this.D.j()) {
                        this.D.f();
                        bp<Item, Item.b, b> bpVar = null;
                        this.D = null;
                        this.C = reportReq.itemList_;
                        this.f381662i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = x();
                        }
                        this.D = bpVar;
                    } else {
                        this.D.b(reportReq.itemList_);
                    }
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) reportReq).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b D(String str) {
                str.getClass();
                this.f381663m = str;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return WedataReportPB.f381647a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return WedataReportPB.f381648b.e(ReportReq.class, b.class);
            }

            public b n(Item item) {
                bp<Item, Item.b, b> bpVar = this.D;
                if (bpVar == null) {
                    item.getClass();
                    v();
                    this.C.add(item);
                    onChanged();
                } else {
                    bpVar.c(item);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ReportReq build() {
                ReportReq buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public ReportReq buildPartial() {
                ReportReq reportReq = new ReportReq(this);
                reportReq.reportType_ = this.f381663m;
                bp<Item, Item.b, b> bpVar = this.D;
                if (bpVar != null) {
                    reportReq.itemList_ = bpVar.d();
                } else {
                    if ((this.f381662i & 1) != 0) {
                        this.C = Collections.unmodifiableList(this.C);
                        this.f381662i &= -2;
                    }
                    reportReq.itemList_ = this.C;
                }
                onBuilt();
                return reportReq;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381663m = "";
                bp<Item, Item.b, b> bpVar = this.D;
                if (bpVar == null) {
                    this.C = Collections.emptyList();
                    this.f381662i &= -2;
                } else {
                    bpVar.e();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public ReportReq getDefaultInstanceForType() {
                return ReportReq.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                ReportReq reportReq = null;
                try {
                    try {
                        ReportReq reportReq2 = (ReportReq) ReportReq.f381661e.g(kVar, tVar);
                        if (reportReq2 != null) {
                            A(reportReq2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ReportReq reportReq3 = (ReportReq) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            reportReq = reportReq3;
                            if (reportReq != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (reportReq != null) {
                        A(reportReq);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ReportReq) {
                    return A((ReportReq) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            b() {
                this.f381663m = "";
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381663m = "";
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ReportReq reportReq) {
            return f381660d.toBuilder().A(reportReq);
        }

        public static ReportReq parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381661e.m(byteBuffer, tVar);
        }

        ReportReq(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ReportReq parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ReportReq) GeneratedMessageV3.parseDelimitedWithIOException(f381661e, inputStream, tVar);
        }

        public static ReportReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381661e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ReportReq getDefaultInstanceForType() {
            return f381660d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381660d ? new b() : new b().A(this);
        }

        public static ReportReq parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381661e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ReportReq() {
            this.memoizedIsInitialized = (byte) -1;
            this.reportType_ = "";
            this.itemList_ = Collections.emptyList();
        }

        public static ReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381661e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ReportReq parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381661e.i(bArr, tVar);
        }

        public static ReportReq parseFrom(InputStream inputStream) throws IOException {
            return (ReportReq) GeneratedMessageV3.parseWithIOException(f381661e, inputStream);
        }

        ReportReq(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 10) {
                                this.reportType_ = kVar.I();
                            } else if (J != 18) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if (!(z17 & true)) {
                                    this.itemList_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.itemList_.add((Item) kVar.z(Item.parser(), tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z17 & true) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ReportReq parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ReportReq) GeneratedMessageV3.parseWithIOException(f381661e, inputStream, tVar);
        }

        public static ReportReq parseFrom(k kVar) throws IOException {
            return (ReportReq) GeneratedMessageV3.parseWithIOException(f381661e, kVar);
        }

        public static ReportReq parseFrom(k kVar, t tVar) throws IOException {
            return (ReportReq) GeneratedMessageV3.parseWithIOException(f381661e, kVar, tVar);
        }
    }

    /* loaded from: classes27.dex */
    public static final class ReportRsp extends GeneratedMessageV3 implements ax {

        /* renamed from: d, reason: collision with root package name */
        private static final ReportRsp f381664d = new ReportRsp();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ReportRsp> f381665e = new a();
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;

        /* loaded from: classes27.dex */
        class a extends c<ReportRsp> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ReportRsp g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ReportRsp(kVar, tVar);
            }
        }

        public static ReportRsp getDefaultInstance() {
            return f381664d;
        }

        public static final Descriptors.b getDescriptor() {
            return WedataReportPB.f381653g;
        }

        public static b newBuilder() {
            return f381664d.toBuilder();
        }

        public static ReportRsp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReportRsp) GeneratedMessageV3.parseDelimitedWithIOException(f381665e, inputStream);
        }

        public static ReportRsp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381665e.d(byteBuffer);
        }

        public static bg<ReportRsp> parser() {
            return f381665e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ReportRsp)) {
                return super.equals(obj);
            }
            if (this.unknownFields.equals(((ReportRsp) obj).unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ReportRsp> getParserForType() {
            return f381665e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int serializedSize = this.unknownFields.getSerializedSize() + 0;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = ((e.CTRL_INDEX + getDescriptor().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return WedataReportPB.f381654h.e(ReportRsp.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new ReportRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements ax {
            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return WedataReportPB.f381653g;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return WedataReportPB.f381654h.e(ReportRsp.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ReportRsp build() {
                ReportRsp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ReportRsp buildPartial() {
                ReportRsp reportRsp = new ReportRsp(this);
                onBuilt();
                return reportRsp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public ReportRsp getDefaultInstanceForType() {
                return ReportRsp.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                ReportRsp reportRsp = null;
                try {
                    try {
                        ReportRsp reportRsp2 = (ReportRsp) ReportRsp.f381665e.g(kVar, tVar);
                        if (reportRsp2 != null) {
                            x(reportRsp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ReportRsp reportRsp3 = (ReportRsp) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            reportRsp = reportRsp3;
                            if (reportRsp != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (reportRsp != null) {
                        x(reportRsp);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ReportRsp) {
                    return x((ReportRsp) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(ReportRsp reportRsp) {
                if (reportRsp == ReportRsp.getDefaultInstance()) {
                    return this;
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) reportRsp).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            b() {
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ReportRsp reportRsp) {
            return f381664d.toBuilder().x(reportRsp);
        }

        public static ReportRsp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381665e.m(byteBuffer, tVar);
        }

        ReportRsp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ReportRsp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ReportRsp) GeneratedMessageV3.parseDelimitedWithIOException(f381665e, inputStream, tVar);
        }

        public static ReportRsp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381665e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ReportRsp getDefaultInstanceForType() {
            return f381664d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381664d ? new b() : new b().x(this);
        }

        public static ReportRsp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381665e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ReportRsp() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ReportRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381665e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ReportRsp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381665e.i(bArr, tVar);
        }

        ReportRsp(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            if (J == 0 || !parseUnknownField(kVar, g16, tVar, J)) {
                                z16 = true;
                            }
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ReportRsp parseFrom(InputStream inputStream) throws IOException {
            return (ReportRsp) GeneratedMessageV3.parseWithIOException(f381665e, inputStream);
        }

        public static ReportRsp parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ReportRsp) GeneratedMessageV3.parseWithIOException(f381665e, inputStream, tVar);
        }

        public static ReportRsp parseFrom(k kVar) throws IOException {
            return (ReportRsp) GeneratedMessageV3.parseWithIOException(f381665e, kVar);
        }

        public static ReportRsp parseFrom(k kVar, t tVar) throws IOException {
            return (ReportRsp) GeneratedMessageV3.parseWithIOException(f381665e, kVar, tVar);
        }
    }

    /* loaded from: classes27.dex */
    public interface b extends ax {
    }

    static {
        Descriptors.b bVar = h().p().get(0);
        f381647a = bVar;
        f381648b = new GeneratedMessageV3.e(bVar, new String[]{"ReportType", "ItemList"});
        Descriptors.b bVar2 = h().p().get(1);
        f381649c = bVar2;
        f381650d = new GeneratedMessageV3.e(bVar2, new String[]{"Kvs"});
        Descriptors.b bVar3 = bVar2.s().get(0);
        f381651e = bVar3;
        f381652f = new GeneratedMessageV3.e(bVar3, new String[]{"Key", "Value"});
        Descriptors.b bVar4 = h().p().get(2);
        f381653g = bVar4;
        f381654h = new GeneratedMessageV3.e(bVar4, new String[0]);
    }

    public static Descriptors.FileDescriptor h() {
        return f381655i;
    }
}
