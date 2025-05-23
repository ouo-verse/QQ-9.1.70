package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdActionButton extends Message<AdActionButton, a> {
    public static final ProtoAdapter<AdActionButton> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdActionTitle#ADAPTER", jsonName = "actionTitle", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdActionTitle action_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "bgColor", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String bg_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "delayHighlightInterval", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int delay_highlight_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "highlightBgColor", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String highlight_bg_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "highlightColor", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String highlight_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "textColor", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String text_color;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdActionButton, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdActionTitle f383508a;

        /* renamed from: b, reason: collision with root package name */
        public int f383509b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f383510c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383511d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f383512e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383513f = "";

        public a a(AdActionTitle adActionTitle) {
            this.f383508a = adActionTitle;
            return this;
        }

        public a b(String str) {
            this.f383511d = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AdActionButton build() {
            return new AdActionButton(this.f383508a, this.f383509b, this.f383510c, this.f383511d, this.f383512e, this.f383513f, super.buildUnknownFields());
        }

        public a d(int i3) {
            this.f383509b = i3;
            return this;
        }

        public a e(String str) {
            this.f383512e = str;
            return this;
        }

        public a f(String str) {
            this.f383510c = str;
            return this;
        }

        public a g(String str) {
            this.f383513f = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdActionButton> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdActionButton.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdActionButton", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdActionButton decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.a(AdActionTitle.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 3:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdActionButton adActionButton) throws IOException {
            if (!Objects.equals(adActionButton.action_title, null)) {
                AdActionTitle.ADAPTER.encodeWithTag(protoWriter, 1, adActionButton.action_title);
            }
            if (!Objects.equals(Integer.valueOf(adActionButton.delay_highlight_interval), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(adActionButton.delay_highlight_interval));
            }
            if (!Objects.equals(adActionButton.highlight_color, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adActionButton.highlight_color);
            }
            if (!Objects.equals(adActionButton.bg_color, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adActionButton.bg_color);
            }
            if (!Objects.equals(adActionButton.highlight_bg_color, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, adActionButton.highlight_bg_color);
            }
            if (!Objects.equals(adActionButton.text_color, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adActionButton.text_color);
            }
            protoWriter.writeBytes(adActionButton.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdActionButton adActionButton) {
            int i3;
            if (!Objects.equals(adActionButton.action_title, null)) {
                i3 = AdActionTitle.ADAPTER.encodedSizeWithTag(1, adActionButton.action_title) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(adActionButton.delay_highlight_interval), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(adActionButton.delay_highlight_interval));
            }
            if (!Objects.equals(adActionButton.highlight_color, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adActionButton.highlight_color);
            }
            if (!Objects.equals(adActionButton.bg_color, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adActionButton.bg_color);
            }
            if (!Objects.equals(adActionButton.highlight_bg_color, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, adActionButton.highlight_bg_color);
            }
            if (!Objects.equals(adActionButton.text_color, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, adActionButton.text_color);
            }
            return i3 + adActionButton.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdActionButton redact(AdActionButton adActionButton) {
            a newBuilder = adActionButton.newBuilder();
            AdActionTitle adActionTitle = newBuilder.f383508a;
            if (adActionTitle != null) {
                newBuilder.f383508a = AdActionTitle.ADAPTER.redact(adActionTitle);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdActionButton(AdActionTitle adActionTitle, int i3, String str, String str2, String str3, String str4) {
        this(adActionTitle, i3, str, str2, str3, str4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdActionButton)) {
            return false;
        }
        AdActionButton adActionButton = (AdActionButton) obj;
        if (unknownFields().equals(adActionButton.unknownFields()) && Internal.equals(this.action_title, adActionButton.action_title) && Internal.equals(Integer.valueOf(this.delay_highlight_interval), Integer.valueOf(adActionButton.delay_highlight_interval)) && Internal.equals(this.highlight_color, adActionButton.highlight_color) && Internal.equals(this.bg_color, adActionButton.bg_color) && Internal.equals(this.highlight_bg_color, adActionButton.highlight_bg_color) && Internal.equals(this.text_color, adActionButton.text_color)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdActionTitle adActionTitle = this.action_title;
            int i26 = 0;
            if (adActionTitle != null) {
                i3 = adActionTitle.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (((hashCode + i3) * 37) + this.delay_highlight_interval) * 37;
            String str = this.highlight_color;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            String str2 = this.bg_color;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            String str3 = this.highlight_bg_color;
            if (str3 != null) {
                i18 = str3.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str4 = this.text_color;
            if (str4 != null) {
                i26 = str4.hashCode();
            }
            int i37 = i36 + i26;
            this.hashCode = i37;
            return i37;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.action_title != null) {
            sb5.append(", action_title=");
            sb5.append(this.action_title);
        }
        sb5.append(", delay_highlight_interval=");
        sb5.append(this.delay_highlight_interval);
        if (this.highlight_color != null) {
            sb5.append(", highlight_color=");
            sb5.append(Internal.sanitize(this.highlight_color));
        }
        if (this.bg_color != null) {
            sb5.append(", bg_color=");
            sb5.append(Internal.sanitize(this.bg_color));
        }
        if (this.highlight_bg_color != null) {
            sb5.append(", highlight_bg_color=");
            sb5.append(Internal.sanitize(this.highlight_bg_color));
        }
        if (this.text_color != null) {
            sb5.append(", text_color=");
            sb5.append(Internal.sanitize(this.text_color));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdActionButton{");
        replace.append('}');
        return replace.toString();
    }

    public AdActionButton(AdActionTitle adActionTitle, int i3, String str, String str2, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.action_title = adActionTitle;
        this.delay_highlight_interval = i3;
        if (str != null) {
            this.highlight_color = str;
            if (str2 != null) {
                this.bg_color = str2;
                if (str3 != null) {
                    this.highlight_bg_color = str3;
                    if (str4 != null) {
                        this.text_color = str4;
                        return;
                    }
                    throw new IllegalArgumentException("text_color == null");
                }
                throw new IllegalArgumentException("highlight_bg_color == null");
            }
            throw new IllegalArgumentException("bg_color == null");
        }
        throw new IllegalArgumentException("highlight_color == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383508a = this.action_title;
        aVar.f383509b = this.delay_highlight_interval;
        aVar.f383510c = this.highlight_color;
        aVar.f383511d = this.bg_color;
        aVar.f383512e = this.highlight_bg_color;
        aVar.f383513f = this.text_color;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
