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
public final class AdActionItem extends Message<AdActionItem, a> {
    public static final ProtoAdapter<AdActionItem> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdDownloadAction#ADAPTER", jsonName = "downloadAction", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AdDownloadAction download_action;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdOpenAppAction#ADAPTER", jsonName = "openAppAction", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdOpenAppAction open_app_action;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdOpenWxProgramAction#ADAPTER", jsonName = "openMiniGame", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final AdOpenWxProgramAction open_mini_game;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdOpenWxProgramAction#ADAPTER", jsonName = "openMiniProgram", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final AdOpenWxProgramAction open_mini_program;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdWebAction#ADAPTER", jsonName = "webAction", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdWebAction web_action;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdActionItem, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdWebAction f383514a;

        /* renamed from: b, reason: collision with root package name */
        public AdDownloadAction f383515b;

        /* renamed from: c, reason: collision with root package name */
        public AdOpenAppAction f383516c;

        /* renamed from: d, reason: collision with root package name */
        public AdOpenWxProgramAction f383517d;

        /* renamed from: e, reason: collision with root package name */
        public AdOpenWxProgramAction f383518e;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdActionItem build() {
            return new AdActionItem(this.f383514a, this.f383515b, this.f383516c, this.f383517d, this.f383518e, super.buildUnknownFields());
        }

        public a b(AdDownloadAction adDownloadAction) {
            this.f383515b = adDownloadAction;
            return this;
        }

        public a c(AdOpenAppAction adOpenAppAction) {
            this.f383516c = adOpenAppAction;
            return this;
        }

        public a d(AdOpenWxProgramAction adOpenWxProgramAction) {
            this.f383518e = adOpenWxProgramAction;
            return this;
        }

        public a e(AdOpenWxProgramAction adOpenWxProgramAction) {
            this.f383517d = adOpenWxProgramAction;
            return this;
        }

        public a f(AdWebAction adWebAction) {
            this.f383514a = adWebAction;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdActionItem> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdActionItem.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdActionItem", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdActionItem decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    if (nextTag != 5) {
                                        protoReader.readUnknownField(nextTag);
                                    } else {
                                        aVar.d(AdOpenWxProgramAction.ADAPTER.decode(protoReader));
                                    }
                                } else {
                                    aVar.e(AdOpenWxProgramAction.ADAPTER.decode(protoReader));
                                }
                            } else {
                                aVar.c(AdOpenAppAction.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.b(AdDownloadAction.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.f(AdWebAction.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdActionItem adActionItem) throws IOException {
            if (!Objects.equals(adActionItem.web_action, null)) {
                AdWebAction.ADAPTER.encodeWithTag(protoWriter, 1, adActionItem.web_action);
            }
            if (!Objects.equals(adActionItem.download_action, null)) {
                AdDownloadAction.ADAPTER.encodeWithTag(protoWriter, 2, adActionItem.download_action);
            }
            if (!Objects.equals(adActionItem.open_app_action, null)) {
                AdOpenAppAction.ADAPTER.encodeWithTag(protoWriter, 3, adActionItem.open_app_action);
            }
            if (!Objects.equals(adActionItem.open_mini_program, null)) {
                AdOpenWxProgramAction.ADAPTER.encodeWithTag(protoWriter, 4, adActionItem.open_mini_program);
            }
            if (!Objects.equals(adActionItem.open_mini_game, null)) {
                AdOpenWxProgramAction.ADAPTER.encodeWithTag(protoWriter, 5, adActionItem.open_mini_game);
            }
            protoWriter.writeBytes(adActionItem.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdActionItem adActionItem) {
            int i3 = 0;
            if (!Objects.equals(adActionItem.web_action, null)) {
                i3 = 0 + AdWebAction.ADAPTER.encodedSizeWithTag(1, adActionItem.web_action);
            }
            if (!Objects.equals(adActionItem.download_action, null)) {
                i3 += AdDownloadAction.ADAPTER.encodedSizeWithTag(2, adActionItem.download_action);
            }
            if (!Objects.equals(adActionItem.open_app_action, null)) {
                i3 += AdOpenAppAction.ADAPTER.encodedSizeWithTag(3, adActionItem.open_app_action);
            }
            if (!Objects.equals(adActionItem.open_mini_program, null)) {
                i3 += AdOpenWxProgramAction.ADAPTER.encodedSizeWithTag(4, adActionItem.open_mini_program);
            }
            if (!Objects.equals(adActionItem.open_mini_game, null)) {
                i3 += AdOpenWxProgramAction.ADAPTER.encodedSizeWithTag(5, adActionItem.open_mini_game);
            }
            return i3 + adActionItem.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdActionItem redact(AdActionItem adActionItem) {
            a newBuilder = adActionItem.newBuilder();
            AdWebAction adWebAction = newBuilder.f383514a;
            if (adWebAction != null) {
                newBuilder.f383514a = AdWebAction.ADAPTER.redact(adWebAction);
            }
            AdDownloadAction adDownloadAction = newBuilder.f383515b;
            if (adDownloadAction != null) {
                newBuilder.f383515b = AdDownloadAction.ADAPTER.redact(adDownloadAction);
            }
            AdOpenAppAction adOpenAppAction = newBuilder.f383516c;
            if (adOpenAppAction != null) {
                newBuilder.f383516c = AdOpenAppAction.ADAPTER.redact(adOpenAppAction);
            }
            AdOpenWxProgramAction adOpenWxProgramAction = newBuilder.f383517d;
            if (adOpenWxProgramAction != null) {
                newBuilder.f383517d = AdOpenWxProgramAction.ADAPTER.redact(adOpenWxProgramAction);
            }
            AdOpenWxProgramAction adOpenWxProgramAction2 = newBuilder.f383518e;
            if (adOpenWxProgramAction2 != null) {
                newBuilder.f383518e = AdOpenWxProgramAction.ADAPTER.redact(adOpenWxProgramAction2);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdActionItem(AdWebAction adWebAction, AdDownloadAction adDownloadAction, AdOpenAppAction adOpenAppAction, AdOpenWxProgramAction adOpenWxProgramAction, AdOpenWxProgramAction adOpenWxProgramAction2) {
        this(adWebAction, adDownloadAction, adOpenAppAction, adOpenWxProgramAction, adOpenWxProgramAction2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdActionItem)) {
            return false;
        }
        AdActionItem adActionItem = (AdActionItem) obj;
        if (unknownFields().equals(adActionItem.unknownFields()) && Internal.equals(this.web_action, adActionItem.web_action) && Internal.equals(this.download_action, adActionItem.download_action) && Internal.equals(this.open_app_action, adActionItem.open_app_action) && Internal.equals(this.open_mini_program, adActionItem.open_mini_program) && Internal.equals(this.open_mini_game, adActionItem.open_mini_game)) {
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
            AdWebAction adWebAction = this.web_action;
            int i26 = 0;
            if (adWebAction != null) {
                i3 = adWebAction.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            AdDownloadAction adDownloadAction = this.download_action;
            if (adDownloadAction != null) {
                i16 = adDownloadAction.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            AdOpenAppAction adOpenAppAction = this.open_app_action;
            if (adOpenAppAction != null) {
                i17 = adOpenAppAction.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            AdOpenWxProgramAction adOpenWxProgramAction = this.open_mini_program;
            if (adOpenWxProgramAction != null) {
                i18 = adOpenWxProgramAction.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            AdOpenWxProgramAction adOpenWxProgramAction2 = this.open_mini_game;
            if (adOpenWxProgramAction2 != null) {
                i26 = adOpenWxProgramAction2.hashCode();
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
        if (this.web_action != null) {
            sb5.append(", web_action=");
            sb5.append(this.web_action);
        }
        if (this.download_action != null) {
            sb5.append(", download_action=");
            sb5.append(this.download_action);
        }
        if (this.open_app_action != null) {
            sb5.append(", open_app_action=");
            sb5.append(this.open_app_action);
        }
        if (this.open_mini_program != null) {
            sb5.append(", open_mini_program=");
            sb5.append(this.open_mini_program);
        }
        if (this.open_mini_game != null) {
            sb5.append(", open_mini_game=");
            sb5.append(this.open_mini_game);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdActionItem{");
        replace.append('}');
        return replace.toString();
    }

    public AdActionItem(AdWebAction adWebAction, AdDownloadAction adDownloadAction, AdOpenAppAction adOpenAppAction, AdOpenWxProgramAction adOpenWxProgramAction, AdOpenWxProgramAction adOpenWxProgramAction2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.web_action = adWebAction;
        this.download_action = adDownloadAction;
        this.open_app_action = adOpenAppAction;
        this.open_mini_program = adOpenWxProgramAction;
        this.open_mini_game = adOpenWxProgramAction2;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383514a = this.web_action;
        aVar.f383515b = this.download_action;
        aVar.f383516c = this.open_app_action;
        aVar.f383517d = this.open_mini_program;
        aVar.f383518e = this.open_mini_game;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
