package org.box2d.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.ad;
import com.google.protobuf.ar;
import com.google.protobuf.au;
import com.google.protobuf.ax;
import com.google.protobuf.b;
import com.google.protobuf.bk;
import com.google.protobuf.bo;
import com.google.protobuf.bt;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.r;
import com.google.protobuf.t;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.luggage.wxa.gf.y;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Box2D {
    private static Descriptors.FileDescriptor descriptor;
    private static Descriptors.b internal_static_box2d_PbBody_descriptor;
    private static GeneratedMessage.j internal_static_box2d_PbBody_fieldAccessorTable;
    private static Descriptors.b internal_static_box2d_PbFilter_descriptor;
    private static GeneratedMessage.j internal_static_box2d_PbFilter_fieldAccessorTable;
    private static Descriptors.b internal_static_box2d_PbFixture_descriptor;
    private static GeneratedMessage.j internal_static_box2d_PbFixture_fieldAccessorTable;
    private static Descriptors.b internal_static_box2d_PbJoint_descriptor;
    private static GeneratedMessage.j internal_static_box2d_PbJoint_fieldAccessorTable;
    private static Descriptors.b internal_static_box2d_PbShape_descriptor;
    private static GeneratedMessage.j internal_static_box2d_PbShape_fieldAccessorTable;
    private static Descriptors.b internal_static_box2d_PbVec2_descriptor;
    private static GeneratedMessage.j internal_static_box2d_PbVec2_fieldAccessorTable;
    private static Descriptors.b internal_static_box2d_PbWorld_descriptor;
    private static GeneratedMessage.j internal_static_box2d_PbWorld_fieldAccessorTable;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PbBody extends GeneratedMessage implements PbBodyOrBuilder {
        public static final int ACTIVE_FIELD_NUMBER = 56;
        public static final int ALLOW_SLEEP_FIELD_NUMBER = 54;
        public static final int ANGLE_FIELD_NUMBER = 11;
        public static final int ANGULAR_DAMPING_FIELD_NUMBER = 51;
        public static final int ANGULAR_VELOCITY_FIELD_NUMBER = 13;
        public static final int AWAKE_FIELD_NUMBER = 55;
        public static final int BULLET_FIELD_NUMBER = 53;
        public static final int FIXED_ROTATION_FIELD_NUMBER = 57;
        public static final int FIXTURES_FIELD_NUMBER = 100;
        public static final int GRAVITY_SCALE_FIELD_NUMBER = 52;
        public static final int LINEAR_DAMPING_FIELD_NUMBER = 50;
        public static final int LINEAR_VELOCITY_FIELD_NUMBER = 12;
        public static final int POSITION_FIELD_NUMBER = 10;
        public static final int TAG_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        private static final PbBody defaultInstance;
        private static final long serialVersionUID = 0;
        private boolean active_;
        private boolean allowSleep_;
        private float angle_;
        private float angularDamping_;
        private float angularVelocity_;
        private boolean awake_;
        private int bitField0_;
        private boolean bullet_;
        private boolean fixedRotation_;
        private List<PbFixture> fixtures_;
        private float gravityScale_;
        private float linearDamping_;
        private PbVec2 linearVelocity_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private PbVec2 position_;
        private long tag_;
        private PbBodyType type_;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Builder extends GeneratedMessage.f<Builder> implements PbBodyOrBuilder {
            private boolean active_;
            private boolean allowSleep_;
            private float angle_;
            private float angularDamping_;
            private float angularVelocity_;
            private boolean awake_;
            private int bitField0_;
            private boolean bullet_;
            private boolean fixedRotation_;
            private bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> fixturesBuilder_;
            private List<PbFixture> fixtures_;
            private float gravityScale_;
            private float linearDamping_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> linearVelocityBuilder_;
            private PbVec2 linearVelocity_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> positionBuilder_;
            private PbVec2 position_;
            private long tag_;
            private PbBodyType type_;

            static /* synthetic */ Builder access$10400() {
                return create();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PbBody buildParsed() throws InvalidProtocolBufferException {
                PbBody buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial).asInvalidProtocolBufferException();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureFixturesIsMutable() {
                if ((this.bitField0_ & 16384) != 16384) {
                    this.fixtures_ = new ArrayList(this.fixtures_);
                    this.bitField0_ |= 16384;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return Box2D.internal_static_box2d_PbBody_descriptor;
            }

            private bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> getFixturesFieldBuilder() {
                boolean z16;
                if (this.fixturesBuilder_ == null) {
                    List<PbFixture> list = this.fixtures_;
                    if ((this.bitField0_ & 16384) == 16384) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.fixturesBuilder_ = new bo<>(list, z16, getParentForChildren(), isClean());
                    this.fixtures_ = null;
                }
                return this.fixturesBuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getLinearVelocityFieldBuilder() {
                if (this.linearVelocityBuilder_ == null) {
                    this.linearVelocityBuilder_ = new bt<>(this.linearVelocity_, getParentForChildren(), isClean());
                    this.linearVelocity_ = null;
                }
                return this.linearVelocityBuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getPositionFieldBuilder() {
                if (this.positionBuilder_ == null) {
                    this.positionBuilder_ = new bt<>(this.position_, getParentForChildren(), isClean());
                    this.position_ = null;
                }
                return this.positionBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getPositionFieldBuilder();
                    getLinearVelocityFieldBuilder();
                    getFixturesFieldBuilder();
                }
            }

            public Builder addAllFixtures(Iterable<? extends PbFixture> iterable) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    ensureFixturesIsMutable();
                    b.a.addAll((Iterable) iterable, (Collection) this.fixtures_);
                    onChanged();
                } else {
                    boVar.b(iterable);
                }
                return this;
            }

            public Builder addFixtures(PbFixture pbFixture) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    pbFixture.getClass();
                    ensureFixturesIsMutable();
                    this.fixtures_.add(pbFixture);
                    onChanged();
                } else {
                    boVar.f(pbFixture);
                }
                return this;
            }

            public PbFixture.Builder addFixturesBuilder() {
                return getFixturesFieldBuilder().d(PbFixture.getDefaultInstance());
            }

            public Builder clearActive() {
                this.bitField0_ &= -4097;
                this.active_ = false;
                onChanged();
                return this;
            }

            public Builder clearAllowSleep() {
                this.bitField0_ &= -1025;
                this.allowSleep_ = false;
                onChanged();
                return this;
            }

            public Builder clearAngle() {
                this.bitField0_ &= -9;
                this.angle_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearAngularDamping() {
                this.bitField0_ &= -129;
                this.angularDamping_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearAngularVelocity() {
                this.bitField0_ &= -33;
                this.angularVelocity_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearAwake() {
                this.bitField0_ &= MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                this.awake_ = false;
                onChanged();
                return this;
            }

            public Builder clearBullet() {
                this.bitField0_ &= -513;
                this.bullet_ = false;
                onChanged();
                return this;
            }

            public Builder clearFixedRotation() {
                this.bitField0_ &= -8193;
                this.fixedRotation_ = false;
                onChanged();
                return this;
            }

            public Builder clearFixtures() {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    this.fixtures_ = Collections.emptyList();
                    this.bitField0_ &= -16385;
                    onChanged();
                } else {
                    boVar.h();
                }
                return this;
            }

            public Builder clearGravityScale() {
                this.bitField0_ &= -257;
                this.gravityScale_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearLinearDamping() {
                this.bitField0_ &= -65;
                this.linearDamping_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearLinearVelocity() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.linearVelocityBuilder_;
                if (btVar == null) {
                    this.linearVelocity_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearPosition() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.positionBuilder_;
                if (btVar == null) {
                    this.position_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearTag() {
                this.bitField0_ &= -2;
                this.tag_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -3;
                this.type_ = PbBodyType.STATIC;
                onChanged();
                return this;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean getActive() {
                return this.active_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean getAllowSleep() {
                return this.allowSleep_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public float getAngle() {
                return this.angle_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public float getAngularDamping() {
                return this.angularDamping_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public float getAngularVelocity() {
                return this.angularVelocity_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean getAwake() {
                return this.awake_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean getBullet() {
                return this.bullet_;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return PbBody.getDescriptor();
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean getFixedRotation() {
                return this.fixedRotation_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public PbFixture getFixtures(int i3) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    return this.fixtures_.get(i3);
                }
                return boVar.o(i3);
            }

            public PbFixture.Builder getFixturesBuilder(int i3) {
                return getFixturesFieldBuilder().l(i3);
            }

            public List<PbFixture.Builder> getFixturesBuilderList() {
                return getFixturesFieldBuilder().m();
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public int getFixturesCount() {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    return this.fixtures_.size();
                }
                return boVar.n();
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public List<PbFixture> getFixturesList() {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    return Collections.unmodifiableList(this.fixtures_);
                }
                return boVar.q();
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public PbFixtureOrBuilder getFixturesOrBuilder(int i3) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    return this.fixtures_.get(i3);
                }
                return boVar.r(i3);
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public List<? extends PbFixtureOrBuilder> getFixturesOrBuilderList() {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar != null) {
                    return boVar.s();
                }
                return Collections.unmodifiableList(this.fixtures_);
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public float getGravityScale() {
                return this.gravityScale_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public float getLinearDamping() {
                return this.linearDamping_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public PbVec2 getLinearVelocity() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.linearVelocityBuilder_;
                if (btVar == null) {
                    return this.linearVelocity_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getLinearVelocityBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return getLinearVelocityFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public PbVec2OrBuilder getLinearVelocityOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.linearVelocityBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.linearVelocity_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public PbVec2 getPosition() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.positionBuilder_;
                if (btVar == null) {
                    return this.position_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getPositionBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return getPositionFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public PbVec2OrBuilder getPositionOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.positionBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.position_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public long getTag() {
                return this.tag_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public PbBodyType getType() {
                return this.type_;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasActive() {
                if ((this.bitField0_ & 4096) == 4096) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasAllowSleep() {
                if ((this.bitField0_ & 1024) == 1024) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasAngle() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasAngularDamping() {
                if ((this.bitField0_ & 128) == 128) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasAngularVelocity() {
                if ((this.bitField0_ & 32) == 32) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasAwake() {
                if ((this.bitField0_ & 2048) == 2048) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasBullet() {
                if ((this.bitField0_ & 512) == 512) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasFixedRotation() {
                if ((this.bitField0_ & 8192) == 8192) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasGravityScale() {
                if ((this.bitField0_ & 256) == 256) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasLinearDamping() {
                if ((this.bitField0_ & 64) == 64) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasLinearVelocity() {
                if ((this.bitField0_ & 16) == 16) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasPosition() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasTag() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
            public boolean hasType() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.f
            protected GeneratedMessage.j internalGetFieldAccessorTable() {
                return Box2D.internal_static_box2d_PbBody_fieldAccessorTable;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.av
            public final boolean isInitialized() {
                if (!hasType()) {
                    return false;
                }
                if (hasPosition() && !getPosition().isInitialized()) {
                    return false;
                }
                if (hasLinearVelocity() && !getLinearVelocity().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getFixturesCount(); i3++) {
                    if (!getFixtures(i3).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeLinearVelocity(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.linearVelocityBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 16) == 16 && this.linearVelocity_ != PbVec2.getDefaultInstance()) {
                        this.linearVelocity_ = PbVec2.newBuilder(this.linearVelocity_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.linearVelocity_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergePosition(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.positionBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 4) == 4 && this.position_ != PbVec2.getDefaultInstance()) {
                        this.position_ = PbVec2.newBuilder(this.position_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.position_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder removeFixtures(int i3) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    ensureFixturesIsMutable();
                    this.fixtures_.remove(i3);
                    onChanged();
                } else {
                    boVar.w(i3);
                }
                return this;
            }

            public Builder setActive(boolean z16) {
                this.bitField0_ |= 4096;
                this.active_ = z16;
                onChanged();
                return this;
            }

            public Builder setAllowSleep(boolean z16) {
                this.bitField0_ |= 1024;
                this.allowSleep_ = z16;
                onChanged();
                return this;
            }

            public Builder setAngle(float f16) {
                this.bitField0_ |= 8;
                this.angle_ = f16;
                onChanged();
                return this;
            }

            public Builder setAngularDamping(float f16) {
                this.bitField0_ |= 128;
                this.angularDamping_ = f16;
                onChanged();
                return this;
            }

            public Builder setAngularVelocity(float f16) {
                this.bitField0_ |= 32;
                this.angularVelocity_ = f16;
                onChanged();
                return this;
            }

            public Builder setAwake(boolean z16) {
                this.bitField0_ |= 2048;
                this.awake_ = z16;
                onChanged();
                return this;
            }

            public Builder setBullet(boolean z16) {
                this.bitField0_ |= 512;
                this.bullet_ = z16;
                onChanged();
                return this;
            }

            public Builder setFixedRotation(boolean z16) {
                this.bitField0_ |= 8192;
                this.fixedRotation_ = z16;
                onChanged();
                return this;
            }

            public Builder setFixtures(int i3, PbFixture pbFixture) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    pbFixture.getClass();
                    ensureFixturesIsMutable();
                    this.fixtures_.set(i3, pbFixture);
                    onChanged();
                } else {
                    boVar.x(i3, pbFixture);
                }
                return this;
            }

            public Builder setGravityScale(float f16) {
                this.bitField0_ |= 256;
                this.gravityScale_ = f16;
                onChanged();
                return this;
            }

            public Builder setLinearDamping(float f16) {
                this.bitField0_ |= 64;
                this.linearDamping_ = f16;
                onChanged();
                return this;
            }

            public Builder setLinearVelocity(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.linearVelocityBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.linearVelocity_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setPosition(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.positionBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.position_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setTag(long j3) {
                this.bitField0_ |= 1;
                this.tag_ = j3;
                onChanged();
                return this;
            }

            public Builder setType(PbBodyType pbBodyType) {
                pbBodyType.getClass();
                this.bitField0_ |= 2;
                this.type_ = pbBodyType;
                onChanged();
                return this;
            }

            Builder() {
                this.type_ = PbBodyType.STATIC;
                this.position_ = PbVec2.getDefaultInstance();
                this.linearVelocity_ = PbVec2.getDefaultInstance();
                this.fixtures_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public PbFixture.Builder addFixturesBuilder(int i3) {
                return getFixturesFieldBuilder().c(i3, PbFixture.getDefaultInstance());
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbBody build() {
                PbBody buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbBody buildPartial() {
                PbBody pbBody = new PbBody(this);
                int i3 = this.bitField0_;
                int i16 = (i3 & 1) != 1 ? 0 : 1;
                pbBody.tag_ = this.tag_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                pbBody.type_ = this.type_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.positionBuilder_;
                if (btVar == null) {
                    pbBody.position_ = this.position_;
                } else {
                    pbBody.position_ = btVar.b();
                }
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                pbBody.angle_ = this.angle_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar2 = this.linearVelocityBuilder_;
                if (btVar2 == null) {
                    pbBody.linearVelocity_ = this.linearVelocity_;
                } else {
                    pbBody.linearVelocity_ = btVar2.b();
                }
                if ((i3 & 32) == 32) {
                    i16 |= 32;
                }
                pbBody.angularVelocity_ = this.angularVelocity_;
                if ((i3 & 64) == 64) {
                    i16 |= 64;
                }
                pbBody.linearDamping_ = this.linearDamping_;
                if ((i3 & 128) == 128) {
                    i16 |= 128;
                }
                pbBody.angularDamping_ = this.angularDamping_;
                if ((i3 & 256) == 256) {
                    i16 |= 256;
                }
                pbBody.gravityScale_ = this.gravityScale_;
                if ((i3 & 512) == 512) {
                    i16 |= 512;
                }
                pbBody.bullet_ = this.bullet_;
                if ((i3 & 1024) == 1024) {
                    i16 |= 1024;
                }
                pbBody.allowSleep_ = this.allowSleep_;
                if ((i3 & 2048) == 2048) {
                    i16 |= 2048;
                }
                pbBody.awake_ = this.awake_;
                if ((i3 & 4096) == 4096) {
                    i16 |= 4096;
                }
                pbBody.active_ = this.active_;
                if ((i3 & 8192) == 8192) {
                    i16 |= 8192;
                }
                pbBody.fixedRotation_ = this.fixedRotation_;
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar != null) {
                    pbBody.fixtures_ = boVar.g();
                } else {
                    if ((this.bitField0_ & 16384) == 16384) {
                        this.fixtures_ = Collections.unmodifiableList(this.fixtures_);
                        this.bitField0_ &= -16385;
                    }
                    pbBody.fixtures_ = this.fixtures_;
                }
                pbBody.bitField0_ = i16;
                onBuilt();
                return pbBody;
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            public PbBody getDefaultInstanceForType() {
                return PbBody.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a
            public Builder clear() {
                super.clear();
                this.tag_ = 0L;
                int i3 = this.bitField0_ & (-2);
                this.bitField0_ = i3;
                this.type_ = PbBodyType.STATIC;
                this.bitField0_ = i3 & (-3);
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.positionBuilder_;
                if (btVar == null) {
                    this.position_ = PbVec2.getDefaultInstance();
                } else {
                    btVar.c();
                }
                int i16 = this.bitField0_ & (-5);
                this.angle_ = 0.0f;
                this.bitField0_ = i16 & (-9);
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar2 = this.linearVelocityBuilder_;
                if (btVar2 == null) {
                    this.linearVelocity_ = PbVec2.getDefaultInstance();
                } else {
                    btVar2.c();
                }
                int i17 = this.bitField0_ & (-17);
                this.angularVelocity_ = 0.0f;
                this.linearDamping_ = 0.0f;
                this.angularDamping_ = 0.0f;
                this.gravityScale_ = 0.0f;
                this.bullet_ = false;
                this.allowSleep_ = false;
                this.awake_ = false;
                int i18 = i17 & (-33) & (-65) & (-129) & (-257) & (-513) & (-1025) & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                this.active_ = false;
                this.fixedRotation_ = false;
                this.bitField0_ = i18 & (-4097) & (-8193);
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    this.fixtures_ = Collections.emptyList();
                    this.bitField0_ &= -16385;
                } else {
                    boVar.h();
                }
                return this;
            }

            public Builder addFixtures(int i3, PbFixture pbFixture) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    pbFixture.getClass();
                    ensureFixturesIsMutable();
                    this.fixtures_.add(i3, pbFixture);
                    onChanged();
                } else {
                    boVar.e(i3, pbFixture);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
            /* renamed from: clone */
            public Builder mo50clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            public Builder mergeFrom(ar arVar) {
                if (arVar instanceof PbBody) {
                    return mergeFrom((PbBody) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public Builder setFixtures(int i3, PbFixture.Builder builder) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    ensureFixturesIsMutable();
                    this.fixtures_.set(i3, builder.build());
                    onChanged();
                } else {
                    boVar.x(i3, builder.build());
                }
                return this;
            }

            public Builder setLinearVelocity(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.linearVelocityBuilder_;
                if (btVar == null) {
                    this.linearVelocity_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setPosition(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.positionBuilder_;
                if (btVar == null) {
                    this.position_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            Builder(GeneratedMessage.g gVar) {
                super(gVar);
                this.type_ = PbBodyType.STATIC;
                this.position_ = PbVec2.getDefaultInstance();
                this.linearVelocity_ = PbVec2.getDefaultInstance();
                this.fixtures_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(PbBody pbBody) {
                if (pbBody == PbBody.getDefaultInstance()) {
                    return this;
                }
                if (pbBody.hasTag()) {
                    setTag(pbBody.getTag());
                }
                if (pbBody.hasType()) {
                    setType(pbBody.getType());
                }
                if (pbBody.hasPosition()) {
                    mergePosition(pbBody.getPosition());
                }
                if (pbBody.hasAngle()) {
                    setAngle(pbBody.getAngle());
                }
                if (pbBody.hasLinearVelocity()) {
                    mergeLinearVelocity(pbBody.getLinearVelocity());
                }
                if (pbBody.hasAngularVelocity()) {
                    setAngularVelocity(pbBody.getAngularVelocity());
                }
                if (pbBody.hasLinearDamping()) {
                    setLinearDamping(pbBody.getLinearDamping());
                }
                if (pbBody.hasAngularDamping()) {
                    setAngularDamping(pbBody.getAngularDamping());
                }
                if (pbBody.hasGravityScale()) {
                    setGravityScale(pbBody.getGravityScale());
                }
                if (pbBody.hasBullet()) {
                    setBullet(pbBody.getBullet());
                }
                if (pbBody.hasAllowSleep()) {
                    setAllowSleep(pbBody.getAllowSleep());
                }
                if (pbBody.hasAwake()) {
                    setAwake(pbBody.getAwake());
                }
                if (pbBody.hasActive()) {
                    setActive(pbBody.getActive());
                }
                if (pbBody.hasFixedRotation()) {
                    setFixedRotation(pbBody.getFixedRotation());
                }
                if (this.fixturesBuilder_ == null) {
                    if (!pbBody.fixtures_.isEmpty()) {
                        if (this.fixtures_.isEmpty()) {
                            this.fixtures_ = pbBody.fixtures_;
                            this.bitField0_ &= -16385;
                        } else {
                            ensureFixturesIsMutable();
                            this.fixtures_.addAll(pbBody.fixtures_);
                        }
                        onChanged();
                    }
                } else if (!pbBody.fixtures_.isEmpty()) {
                    if (!this.fixturesBuilder_.u()) {
                        this.fixturesBuilder_.b(pbBody.fixtures_);
                    } else {
                        this.fixturesBuilder_.i();
                        this.fixturesBuilder_ = null;
                        this.fixtures_ = pbBody.fixtures_;
                        this.bitField0_ &= -16385;
                        this.fixturesBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getFixturesFieldBuilder() : null;
                    }
                }
                mo52mergeUnknownFields(pbBody.getUnknownFields());
                return this;
            }

            public Builder addFixtures(PbFixture.Builder builder) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    ensureFixturesIsMutable();
                    this.fixtures_.add(builder.build());
                    onChanged();
                } else {
                    boVar.f(builder.build());
                }
                return this;
            }

            public Builder addFixtures(int i3, PbFixture.Builder builder) {
                bo<PbFixture, PbFixture.Builder, PbFixtureOrBuilder> boVar = this.fixturesBuilder_;
                if (boVar == null) {
                    ensureFixturesIsMutable();
                    this.fixtures_.add(i3, builder.build());
                    onChanged();
                } else {
                    boVar.e(i3, builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            public Builder mergeFrom(k kVar, t tVar) throws IOException {
                cc.b h16 = cc.h(getUnknownFields());
                while (true) {
                    int J = kVar.J();
                    switch (J) {
                        case 0:
                            setUnknownFields(h16.build());
                            onChanged();
                            return this;
                        case 8:
                            this.bitField0_ |= 1;
                            this.tag_ = kVar.y();
                            break;
                        case 16:
                            int s16 = kVar.s();
                            PbBodyType valueOf = PbBodyType.valueOf(s16);
                            if (valueOf == null) {
                                h16.r(2, s16);
                                break;
                            } else {
                                this.bitField0_ |= 2;
                                this.type_ = valueOf;
                                break;
                            }
                        case 82:
                            PbVec2.Builder newBuilder = PbVec2.newBuilder();
                            if (hasPosition()) {
                                newBuilder.mergeFrom(getPosition());
                            }
                            kVar.A(newBuilder, tVar);
                            setPosition(newBuilder.buildPartial());
                            break;
                        case 93:
                            this.bitField0_ |= 8;
                            this.angle_ = kVar.v();
                            break;
                        case 98:
                            PbVec2.Builder newBuilder2 = PbVec2.newBuilder();
                            if (hasLinearVelocity()) {
                                newBuilder2.mergeFrom(getLinearVelocity());
                            }
                            kVar.A(newBuilder2, tVar);
                            setLinearVelocity(newBuilder2.buildPartial());
                            break;
                        case 109:
                            this.bitField0_ |= 32;
                            this.angularVelocity_ = kVar.v();
                            break;
                        case 405:
                            this.bitField0_ |= 64;
                            this.linearDamping_ = kVar.v();
                            break;
                        case 413:
                            this.bitField0_ |= 128;
                            this.angularDamping_ = kVar.v();
                            break;
                        case 421:
                            this.bitField0_ |= 256;
                            this.gravityScale_ = kVar.v();
                            break;
                        case 424:
                            this.bitField0_ |= 512;
                            this.bullet_ = kVar.p();
                            break;
                        case 432:
                            this.bitField0_ |= 1024;
                            this.allowSleep_ = kVar.p();
                            break;
                        case 440:
                            this.bitField0_ |= 2048;
                            this.awake_ = kVar.p();
                            break;
                        case TroopInfo.PAY_PRIVILEGE_ALL /* 448 */:
                            this.bitField0_ |= 4096;
                            this.active_ = kVar.p();
                            break;
                        case QFSNumberConstants.Int.NUM_456 /* 456 */:
                            this.bitField0_ |= 8192;
                            this.fixedRotation_ = kVar.p();
                            break;
                        case 802:
                            PbFixture.Builder newBuilder3 = PbFixture.newBuilder();
                            kVar.A(newBuilder3, tVar);
                            addFixtures(newBuilder3.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(kVar, h16, tVar, J)) {
                                setUnknownFields(h16.build());
                                onChanged();
                                return this;
                            }
                            break;
                    }
                }
            }
        }

        static {
            PbBody pbBody = new PbBody(true);
            defaultInstance = pbBody;
            pbBody.initFields();
        }

        public static PbBody getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.b getDescriptor() {
            return Box2D.internal_static_box2d_PbBody_descriptor;
        }

        private void initFields() {
            this.tag_ = 0L;
            this.type_ = PbBodyType.STATIC;
            this.position_ = PbVec2.getDefaultInstance();
            this.angle_ = 0.0f;
            this.linearVelocity_ = PbVec2.getDefaultInstance();
            this.angularVelocity_ = 0.0f;
            this.linearDamping_ = 0.0f;
            this.angularDamping_ = 0.0f;
            this.gravityScale_ = 0.0f;
            this.bullet_ = false;
            this.allowSleep_ = false;
            this.awake_ = false;
            this.active_ = false;
            this.fixedRotation_ = false;
            this.fixtures_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$10400();
        }

        public static PbBody parseDelimitedFrom(InputStream inputStream) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbBody parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString)).buildParsed();
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean getActive() {
            return this.active_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean getAllowSleep() {
            return this.allowSleep_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public float getAngle() {
            return this.angle_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public float getAngularDamping() {
            return this.angularDamping_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public float getAngularVelocity() {
            return this.angularVelocity_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean getAwake() {
            return this.awake_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean getBullet() {
            return this.bullet_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean getFixedRotation() {
            return this.fixedRotation_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public PbFixture getFixtures(int i3) {
            return this.fixtures_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public int getFixturesCount() {
            return this.fixtures_.size();
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public List<PbFixture> getFixturesList() {
            return this.fixtures_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public PbFixtureOrBuilder getFixturesOrBuilder(int i3) {
            return this.fixtures_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public List<? extends PbFixtureOrBuilder> getFixturesOrBuilderList() {
            return this.fixtures_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public float getGravityScale() {
            return this.gravityScale_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public float getLinearDamping() {
            return this.linearDamping_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public PbVec2 getLinearVelocity() {
            return this.linearVelocity_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public PbVec2OrBuilder getLinearVelocityOrBuilder() {
            return this.linearVelocity_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public PbVec2 getPosition() {
            return this.position_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public PbVec2OrBuilder getPositionOrBuilder() {
            return this.position_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.z(1, this.tag_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.l(2, this.type_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.G(10, this.position_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.r(11, this.angle_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.G(12, this.linearVelocity_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.r(13, this.angularVelocity_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.r(50, this.linearDamping_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i3 += CodedOutputStream.r(51, this.angularDamping_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i3 += CodedOutputStream.r(52, this.gravityScale_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i3 += CodedOutputStream.e(53, this.bullet_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                i3 += CodedOutputStream.e(54, this.allowSleep_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                i3 += CodedOutputStream.e(55, this.awake_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                i3 += CodedOutputStream.e(56, this.active_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                i3 += CodedOutputStream.e(57, this.fixedRotation_);
            }
            for (int i17 = 0; i17 < this.fixtures_.size(); i17++) {
                i3 += CodedOutputStream.G(100, this.fixtures_.get(i17));
            }
            int serializedSize = i3 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public long getTag() {
            return this.tag_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public PbBodyType getType() {
            return this.type_;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasActive() {
            if ((this.bitField0_ & 4096) == 4096) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasAllowSleep() {
            if ((this.bitField0_ & 1024) == 1024) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasAngle() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasAngularDamping() {
            if ((this.bitField0_ & 128) == 128) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasAngularVelocity() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasAwake() {
            if ((this.bitField0_ & 2048) == 2048) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasBullet() {
            if ((this.bitField0_ & 512) == 512) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasFixedRotation() {
            if ((this.bitField0_ & 8192) == 8192) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasGravityScale() {
            if ((this.bitField0_ & 256) == 256) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasLinearDamping() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasLinearVelocity() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasPosition() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasTag() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbBodyOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.j internalGetFieldAccessorTable() {
            return Box2D.internal_static_box2d_PbBody_fieldAccessorTable;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 != -1) {
                if (b16 == 1) {
                    return true;
                }
                return false;
            }
            if (!hasType()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasPosition() && !getPosition().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasLinearVelocity() && !getLinearVelocity().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getFixturesCount(); i3++) {
                if (!getFixtures(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.I0(1, this.tag_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.u0(2, this.type_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.K0(10, this.position_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.A0(11, this.angle_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.K0(12, this.linearVelocity_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.A0(13, this.angularVelocity_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.A0(50, this.linearDamping_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.A0(51, this.angularDamping_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.A0(52, this.gravityScale_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.m0(53, this.bullet_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.m0(54, this.allowSleep_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.m0(55, this.awake_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.m0(56, this.active_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.m0(57, this.fixedRotation_);
            }
            for (int i3 = 0; i3 < this.fixtures_.size(); i3++) {
                codedOutputStream.K0(100, this.fixtures_.get(i3));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        PbBody(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Builder newBuilder(PbBody pbBody) {
            return newBuilder().mergeFrom(pbBody);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbBody parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbBody parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.av, com.google.protobuf.ax
        public PbBody getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static PbBody parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream, tVar)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbBody parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr, tVar)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder newBuilderForType() {
            return newBuilder();
        }

        PbBody(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbBody parseFrom(InputStream inputStream) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.g gVar) {
            return new Builder(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbBody parseFrom(InputStream inputStream, t tVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbBody parseFrom(k kVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(kVar)).buildParsed();
        }

        public static PbBody parseFrom(k kVar, t tVar) throws IOException {
            return newBuilder().mergeFrom(kVar, tVar).buildParsed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface PbBodyOrBuilder extends ax {
        /* synthetic */ List<String> findInitializationErrors();

        boolean getActive();

        @Override // com.google.protobuf.ax
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        boolean getAllowSleep();

        float getAngle();

        float getAngularDamping();

        float getAngularVelocity();

        boolean getAwake();

        boolean getBullet();

        @Override // com.google.protobuf.ax
        /* synthetic */ ar getDefaultInstanceForType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean getFixedRotation();

        PbFixture getFixtures(int i3);

        int getFixturesCount();

        List<PbFixture> getFixturesList();

        PbFixtureOrBuilder getFixturesOrBuilder(int i3);

        List<? extends PbFixtureOrBuilder> getFixturesOrBuilderList();

        float getGravityScale();

        /* synthetic */ String getInitializationErrorString();

        float getLinearDamping();

        PbVec2 getLinearVelocity();

        PbVec2OrBuilder getLinearVelocityOrBuilder();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar);

        PbVec2 getPosition();

        PbVec2OrBuilder getPositionOrBuilder();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        long getTag();

        PbBodyType getType();

        @Override // com.google.protobuf.ax
        /* synthetic */ cc getUnknownFields();

        boolean hasActive();

        boolean hasAllowSleep();

        boolean hasAngle();

        boolean hasAngularDamping();

        boolean hasAngularVelocity();

        boolean hasAwake();

        boolean hasBullet();

        @Override // com.google.protobuf.ax
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasFixedRotation();

        boolean hasGravityScale();

        boolean hasLinearDamping();

        boolean hasLinearVelocity();

        /* synthetic */ boolean hasOneof(Descriptors.g gVar);

        boolean hasPosition();

        boolean hasTag();

        boolean hasType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum PbBodyType implements bk {
        STATIC(0, 0),
        DYNAMIC(1, 1),
        KINEMATIC(2, 2);

        public static final int DYNAMIC_VALUE = 1;
        public static final int KINEMATIC_VALUE = 2;
        public static final int STATIC_VALUE = 0;
        private static final PbBodyType[] VALUES;
        private static ad.d<PbBodyType> internalValueMap;
        private final int index;
        private final int value;

        static {
            PbBodyType pbBodyType = STATIC;
            PbBodyType pbBodyType2 = DYNAMIC;
            PbBodyType pbBodyType3 = KINEMATIC;
            internalValueMap = new ad.d<PbBodyType>() { // from class: org.box2d.proto.Box2D.PbBodyType.1
                @Override // com.google.protobuf.ad.d
                public PbBodyType findValueByNumber(int i3) {
                    return PbBodyType.valueOf(i3);
                }
            };
            VALUES = new PbBodyType[]{pbBodyType, pbBodyType2, pbBodyType3};
        }

        PbBodyType(int i3, int i16) {
            this.index = i3;
            this.value = i16;
        }

        public static final Descriptors.c getDescriptor() {
            return Box2D.getDescriptor().o().get(0);
        }

        public static ad.d<PbBodyType> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.c getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        public final Descriptors.d getValueDescriptor() {
            return getDescriptor().o().get(this.index);
        }

        public static PbBodyType valueOf(int i3) {
            if (i3 == 0) {
                return STATIC;
            }
            if (i3 == 1) {
                return DYNAMIC;
            }
            if (i3 != 2) {
                return null;
            }
            return KINEMATIC;
        }

        public static PbBodyType valueOf(Descriptors.d dVar) {
            if (dVar.m() == getDescriptor()) {
                return VALUES[dVar.l()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PbFilter extends GeneratedMessage implements PbFilterOrBuilder {
        public static final int CATEGORY_BITS_FIELD_NUMBER = 1;
        public static final int GROUP_INDEX_FIELD_NUMBER = 3;
        public static final int MASK_BITS_FIELD_NUMBER = 2;
        private static final PbFilter defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int categoryBits_;
        private int groupIndex_;
        private int maskBits_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Builder extends GeneratedMessage.f<Builder> implements PbFilterOrBuilder {
            private int bitField0_;
            private int categoryBits_;
            private int groupIndex_;
            private int maskBits_;

            static /* synthetic */ Builder access$1300() {
                return create();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PbFilter buildParsed() throws InvalidProtocolBufferException {
                PbFilter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial).asInvalidProtocolBufferException();
            }

            private static Builder create() {
                return new Builder();
            }

            public static final Descriptors.b getDescriptor() {
                return Box2D.internal_static_box2d_PbFilter_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessage.alwaysUseFieldBuilders;
            }

            public Builder clearCategoryBits() {
                this.bitField0_ &= -2;
                this.categoryBits_ = 0;
                onChanged();
                return this;
            }

            public Builder clearGroupIndex() {
                this.bitField0_ &= -5;
                this.groupIndex_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMaskBits() {
                this.bitField0_ &= -3;
                this.maskBits_ = 0;
                onChanged();
                return this;
            }

            @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
            public int getCategoryBits() {
                return this.categoryBits_;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return PbFilter.getDescriptor();
            }

            @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
            public int getGroupIndex() {
                return this.groupIndex_;
            }

            @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
            public int getMaskBits() {
                return this.maskBits_;
            }

            @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
            public boolean hasCategoryBits() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
            public boolean hasGroupIndex() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
            public boolean hasMaskBits() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.f
            protected GeneratedMessage.j internalGetFieldAccessorTable() {
                return Box2D.internal_static_box2d_PbFilter_fieldAccessorTable;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.av
            public final boolean isInitialized() {
                return true;
            }

            public Builder setCategoryBits(int i3) {
                this.bitField0_ |= 1;
                this.categoryBits_ = i3;
                onChanged();
                return this;
            }

            public Builder setGroupIndex(int i3) {
                this.bitField0_ |= 4;
                this.groupIndex_ = i3;
                onChanged();
                return this;
            }

            public Builder setMaskBits(int i3) {
                this.bitField0_ |= 2;
                this.maskBits_ = i3;
                onChanged();
                return this;
            }

            Builder() {
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbFilter build() {
                PbFilter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbFilter buildPartial() {
                PbFilter pbFilter = new PbFilter(this);
                int i3 = this.bitField0_;
                int i16 = (i3 & 1) != 1 ? 0 : 1;
                pbFilter.categoryBits_ = this.categoryBits_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                pbFilter.maskBits_ = this.maskBits_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                pbFilter.groupIndex_ = this.groupIndex_;
                pbFilter.bitField0_ = i16;
                onBuilt();
                return pbFilter;
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            public PbFilter getDefaultInstanceForType() {
                return PbFilter.getDefaultInstance();
            }

            Builder(GeneratedMessage.g gVar) {
                super(gVar);
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a
            public Builder clear() {
                super.clear();
                this.categoryBits_ = 0;
                int i3 = this.bitField0_ & (-2);
                this.maskBits_ = 0;
                this.groupIndex_ = 0;
                this.bitField0_ = i3 & (-3) & (-5);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
            /* renamed from: clone */
            public Builder mo50clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            public Builder mergeFrom(ar arVar) {
                if (arVar instanceof PbFilter) {
                    return mergeFrom((PbFilter) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public Builder mergeFrom(PbFilter pbFilter) {
                if (pbFilter == PbFilter.getDefaultInstance()) {
                    return this;
                }
                if (pbFilter.hasCategoryBits()) {
                    setCategoryBits(pbFilter.getCategoryBits());
                }
                if (pbFilter.hasMaskBits()) {
                    setMaskBits(pbFilter.getMaskBits());
                }
                if (pbFilter.hasGroupIndex()) {
                    setGroupIndex(pbFilter.getGroupIndex());
                }
                mo52mergeUnknownFields(pbFilter.getUnknownFields());
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            public Builder mergeFrom(k kVar, t tVar) throws IOException {
                cc.b h16 = cc.h(getUnknownFields());
                while (true) {
                    int J = kVar.J();
                    if (J == 0) {
                        setUnknownFields(h16.build());
                        onChanged();
                        return this;
                    }
                    if (J == 8) {
                        this.bitField0_ |= 1;
                        this.categoryBits_ = kVar.x();
                    } else if (J == 16) {
                        this.bitField0_ |= 2;
                        this.maskBits_ = kVar.x();
                    } else if (J != 24) {
                        if (!parseUnknownField(kVar, h16, tVar, J)) {
                            setUnknownFields(h16.build());
                            onChanged();
                            return this;
                        }
                    } else {
                        this.bitField0_ |= 4;
                        this.groupIndex_ = kVar.x();
                    }
                }
            }
        }

        static {
            PbFilter pbFilter = new PbFilter(true);
            defaultInstance = pbFilter;
            pbFilter.initFields();
        }

        public static PbFilter getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.b getDescriptor() {
            return Box2D.internal_static_box2d_PbFilter_descriptor;
        }

        private void initFields() {
            this.categoryBits_ = 0;
            this.maskBits_ = 0;
            this.groupIndex_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$1300();
        }

        public static PbFilter parseDelimitedFrom(InputStream inputStream) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFilter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString)).buildParsed();
        }

        @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
        public int getCategoryBits() {
            return this.categoryBits_;
        }

        @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
        public int getGroupIndex() {
            return this.groupIndex_;
        }

        @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
        public int getMaskBits() {
            return this.maskBits_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i16 = 0 + CodedOutputStream.x(1, this.categoryBits_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i16 += CodedOutputStream.x(2, this.maskBits_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i16 += CodedOutputStream.x(3, this.groupIndex_);
            }
            int serializedSize = i16 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
        public boolean hasCategoryBits() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
        public boolean hasGroupIndex() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbFilterOrBuilder
        public boolean hasMaskBits() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.j internalGetFieldAccessorTable() {
            return Box2D.internal_static_box2d_PbFilter_fieldAccessorTable;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 != -1) {
                if (b16 == 1) {
                    return true;
                }
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.G0(1, this.categoryBits_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.G0(2, this.maskBits_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.G0(3, this.groupIndex_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        PbFilter(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Builder newBuilder(PbFilter pbFilter) {
            return newBuilder().mergeFrom(pbFilter);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFilter parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFilter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.av, com.google.protobuf.ax
        public PbFilter getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static PbFilter parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream, tVar)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFilter parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr, tVar)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder newBuilderForType() {
            return newBuilder();
        }

        PbFilter(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFilter parseFrom(InputStream inputStream) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.g gVar) {
            return new Builder(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFilter parseFrom(InputStream inputStream, t tVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFilter parseFrom(k kVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(kVar)).buildParsed();
        }

        public static PbFilter parseFrom(k kVar, t tVar) throws IOException {
            return newBuilder().mergeFrom(kVar, tVar).buildParsed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface PbFilterOrBuilder extends ax {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.ax
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        int getCategoryBits();

        @Override // com.google.protobuf.ax
        /* synthetic */ ar getDefaultInstanceForType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        int getGroupIndex();

        /* synthetic */ String getInitializationErrorString();

        int getMaskBits();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar);

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        @Override // com.google.protobuf.ax
        /* synthetic */ cc getUnknownFields();

        boolean hasCategoryBits();

        @Override // com.google.protobuf.ax
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasGroupIndex();

        boolean hasMaskBits();

        /* synthetic */ boolean hasOneof(Descriptors.g gVar);

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PbFixture extends GeneratedMessage implements PbFixtureOrBuilder {
        public static final int DENSITY_FIELD_NUMBER = 4;
        public static final int FILTER_FIELD_NUMBER = 10;
        public static final int FRICTION_FIELD_NUMBER = 3;
        public static final int RESTITUTION_FIELD_NUMBER = 2;
        public static final int SENSOR_FIELD_NUMBER = 5;
        public static final int SHAPE_FIELD_NUMBER = 11;
        public static final int TAG_FIELD_NUMBER = 1;
        private static final PbFixture defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private float density_;
        private PbFilter filter_;
        private float friction_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private float restitution_;
        private boolean sensor_;
        private PbShape shape_;
        private long tag_;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Builder extends GeneratedMessage.f<Builder> implements PbFixtureOrBuilder {
            private int bitField0_;
            private float density_;
            private bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> filterBuilder_;
            private PbFilter filter_;
            private float friction_;
            private float restitution_;
            private boolean sensor_;
            private bt<PbShape, PbShape.Builder, PbShapeOrBuilder> shapeBuilder_;
            private PbShape shape_;
            private long tag_;

            static /* synthetic */ Builder access$4900() {
                return create();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PbFixture buildParsed() throws InvalidProtocolBufferException {
                PbFixture buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial).asInvalidProtocolBufferException();
            }

            private static Builder create() {
                return new Builder();
            }

            public static final Descriptors.b getDescriptor() {
                return Box2D.internal_static_box2d_PbFixture_descriptor;
            }

            private bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> getFilterFieldBuilder() {
                if (this.filterBuilder_ == null) {
                    this.filterBuilder_ = new bt<>(this.filter_, getParentForChildren(), isClean());
                    this.filter_ = null;
                }
                return this.filterBuilder_;
            }

            private bt<PbShape, PbShape.Builder, PbShapeOrBuilder> getShapeFieldBuilder() {
                if (this.shapeBuilder_ == null) {
                    this.shapeBuilder_ = new bt<>(this.shape_, getParentForChildren(), isClean());
                    this.shape_ = null;
                }
                return this.shapeBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getFilterFieldBuilder();
                    getShapeFieldBuilder();
                }
            }

            public Builder clearDensity() {
                this.bitField0_ &= -9;
                this.density_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearFilter() {
                bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> btVar = this.filterBuilder_;
                if (btVar == null) {
                    this.filter_ = PbFilter.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearFriction() {
                this.bitField0_ &= -5;
                this.friction_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearRestitution() {
                this.bitField0_ &= -3;
                this.restitution_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearSensor() {
                this.bitField0_ &= -17;
                this.sensor_ = false;
                onChanged();
                return this;
            }

            public Builder clearShape() {
                bt<PbShape, PbShape.Builder, PbShapeOrBuilder> btVar = this.shapeBuilder_;
                if (btVar == null) {
                    this.shape_ = PbShape.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearTag() {
                this.bitField0_ &= -2;
                this.tag_ = 0L;
                onChanged();
                return this;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public float getDensity() {
                return this.density_;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return PbFixture.getDescriptor();
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public PbFilter getFilter() {
                bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> btVar = this.filterBuilder_;
                if (btVar == null) {
                    return this.filter_;
                }
                return btVar.f();
            }

            public PbFilter.Builder getFilterBuilder() {
                this.bitField0_ |= 32;
                onChanged();
                return getFilterFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public PbFilterOrBuilder getFilterOrBuilder() {
                bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> btVar = this.filterBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.filter_;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public float getFriction() {
                return this.friction_;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public float getRestitution() {
                return this.restitution_;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public boolean getSensor() {
                return this.sensor_;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public PbShape getShape() {
                bt<PbShape, PbShape.Builder, PbShapeOrBuilder> btVar = this.shapeBuilder_;
                if (btVar == null) {
                    return this.shape_;
                }
                return btVar.f();
            }

            public PbShape.Builder getShapeBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return getShapeFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public PbShapeOrBuilder getShapeOrBuilder() {
                bt<PbShape, PbShape.Builder, PbShapeOrBuilder> btVar = this.shapeBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.shape_;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public long getTag() {
                return this.tag_;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public boolean hasDensity() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public boolean hasFilter() {
                if ((this.bitField0_ & 32) == 32) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public boolean hasFriction() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public boolean hasRestitution() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public boolean hasSensor() {
                if ((this.bitField0_ & 16) == 16) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public boolean hasShape() {
                if ((this.bitField0_ & 64) == 64) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
            public boolean hasTag() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.f
            protected GeneratedMessage.j internalGetFieldAccessorTable() {
                return Box2D.internal_static_box2d_PbFixture_fieldAccessorTable;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.av
            public final boolean isInitialized() {
                if (hasShape() && !getShape().isInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFilter(PbFilter pbFilter) {
                bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> btVar = this.filterBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 32) == 32 && this.filter_ != PbFilter.getDefaultInstance()) {
                        this.filter_ = PbFilter.newBuilder(this.filter_).mergeFrom(pbFilter).buildPartial();
                    } else {
                        this.filter_ = pbFilter;
                    }
                    onChanged();
                } else {
                    btVar.h(pbFilter);
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeShape(PbShape pbShape) {
                bt<PbShape, PbShape.Builder, PbShapeOrBuilder> btVar = this.shapeBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 64) == 64 && this.shape_ != PbShape.getDefaultInstance()) {
                        this.shape_ = PbShape.newBuilder(this.shape_).mergeFrom(pbShape).buildPartial();
                    } else {
                        this.shape_ = pbShape;
                    }
                    onChanged();
                } else {
                    btVar.h(pbShape);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setDensity(float f16) {
                this.bitField0_ |= 8;
                this.density_ = f16;
                onChanged();
                return this;
            }

            public Builder setFilter(PbFilter pbFilter) {
                bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> btVar = this.filterBuilder_;
                if (btVar == null) {
                    pbFilter.getClass();
                    this.filter_ = pbFilter;
                    onChanged();
                } else {
                    btVar.j(pbFilter);
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setFriction(float f16) {
                this.bitField0_ |= 4;
                this.friction_ = f16;
                onChanged();
                return this;
            }

            public Builder setRestitution(float f16) {
                this.bitField0_ |= 2;
                this.restitution_ = f16;
                onChanged();
                return this;
            }

            public Builder setSensor(boolean z16) {
                this.bitField0_ |= 16;
                this.sensor_ = z16;
                onChanged();
                return this;
            }

            public Builder setShape(PbShape pbShape) {
                bt<PbShape, PbShape.Builder, PbShapeOrBuilder> btVar = this.shapeBuilder_;
                if (btVar == null) {
                    pbShape.getClass();
                    this.shape_ = pbShape;
                    onChanged();
                } else {
                    btVar.j(pbShape);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setTag(long j3) {
                this.bitField0_ |= 1;
                this.tag_ = j3;
                onChanged();
                return this;
            }

            Builder() {
                this.filter_ = PbFilter.getDefaultInstance();
                this.shape_ = PbShape.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbFixture build() {
                PbFixture buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbFixture buildPartial() {
                PbFixture pbFixture = new PbFixture(this);
                int i3 = this.bitField0_;
                int i16 = (i3 & 1) != 1 ? 0 : 1;
                pbFixture.tag_ = this.tag_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                pbFixture.restitution_ = this.restitution_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                pbFixture.friction_ = this.friction_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                pbFixture.density_ = this.density_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                pbFixture.sensor_ = this.sensor_;
                if ((i3 & 32) == 32) {
                    i16 |= 32;
                }
                bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> btVar = this.filterBuilder_;
                if (btVar == null) {
                    pbFixture.filter_ = this.filter_;
                } else {
                    pbFixture.filter_ = btVar.b();
                }
                if ((i3 & 64) == 64) {
                    i16 |= 64;
                }
                bt<PbShape, PbShape.Builder, PbShapeOrBuilder> btVar2 = this.shapeBuilder_;
                if (btVar2 == null) {
                    pbFixture.shape_ = this.shape_;
                } else {
                    pbFixture.shape_ = btVar2.b();
                }
                pbFixture.bitField0_ = i16;
                onBuilt();
                return pbFixture;
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            public PbFixture getDefaultInstanceForType() {
                return PbFixture.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a
            public Builder clear() {
                super.clear();
                this.tag_ = 0L;
                int i3 = this.bitField0_ & (-2);
                this.restitution_ = 0.0f;
                this.friction_ = 0.0f;
                this.density_ = 0.0f;
                this.sensor_ = false;
                this.bitField0_ = i3 & (-3) & (-5) & (-9) & (-17);
                bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> btVar = this.filterBuilder_;
                if (btVar == null) {
                    this.filter_ = PbFilter.getDefaultInstance();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -33;
                bt<PbShape, PbShape.Builder, PbShapeOrBuilder> btVar2 = this.shapeBuilder_;
                if (btVar2 == null) {
                    this.shape_ = PbShape.getDefaultInstance();
                } else {
                    btVar2.c();
                }
                this.bitField0_ &= -65;
                return this;
            }

            Builder(GeneratedMessage.g gVar) {
                super(gVar);
                this.filter_ = PbFilter.getDefaultInstance();
                this.shape_ = PbShape.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
            /* renamed from: clone */
            public Builder mo50clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            public Builder mergeFrom(ar arVar) {
                if (arVar instanceof PbFixture) {
                    return mergeFrom((PbFixture) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public Builder setFilter(PbFilter.Builder builder) {
                bt<PbFilter, PbFilter.Builder, PbFilterOrBuilder> btVar = this.filterBuilder_;
                if (btVar == null) {
                    this.filter_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setShape(PbShape.Builder builder) {
                bt<PbShape, PbShape.Builder, PbShapeOrBuilder> btVar = this.shapeBuilder_;
                if (btVar == null) {
                    this.shape_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeFrom(PbFixture pbFixture) {
                if (pbFixture == PbFixture.getDefaultInstance()) {
                    return this;
                }
                if (pbFixture.hasTag()) {
                    setTag(pbFixture.getTag());
                }
                if (pbFixture.hasRestitution()) {
                    setRestitution(pbFixture.getRestitution());
                }
                if (pbFixture.hasFriction()) {
                    setFriction(pbFixture.getFriction());
                }
                if (pbFixture.hasDensity()) {
                    setDensity(pbFixture.getDensity());
                }
                if (pbFixture.hasSensor()) {
                    setSensor(pbFixture.getSensor());
                }
                if (pbFixture.hasFilter()) {
                    mergeFilter(pbFixture.getFilter());
                }
                if (pbFixture.hasShape()) {
                    mergeShape(pbFixture.getShape());
                }
                mo52mergeUnknownFields(pbFixture.getUnknownFields());
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            public Builder mergeFrom(k kVar, t tVar) throws IOException {
                cc.b h16 = cc.h(getUnknownFields());
                while (true) {
                    int J = kVar.J();
                    if (J == 0) {
                        setUnknownFields(h16.build());
                        onChanged();
                        return this;
                    }
                    if (J == 8) {
                        this.bitField0_ |= 1;
                        this.tag_ = kVar.y();
                    } else if (J == 21) {
                        this.bitField0_ |= 2;
                        this.restitution_ = kVar.v();
                    } else if (J == 29) {
                        this.bitField0_ |= 4;
                        this.friction_ = kVar.v();
                    } else if (J == 37) {
                        this.bitField0_ |= 8;
                        this.density_ = kVar.v();
                    } else if (J == 40) {
                        this.bitField0_ |= 16;
                        this.sensor_ = kVar.p();
                    } else if (J == 82) {
                        PbFilter.Builder newBuilder = PbFilter.newBuilder();
                        if (hasFilter()) {
                            newBuilder.mergeFrom(getFilter());
                        }
                        kVar.A(newBuilder, tVar);
                        setFilter(newBuilder.buildPartial());
                    } else if (J != 90) {
                        if (!parseUnknownField(kVar, h16, tVar, J)) {
                            setUnknownFields(h16.build());
                            onChanged();
                            return this;
                        }
                    } else {
                        PbShape.Builder newBuilder2 = PbShape.newBuilder();
                        if (hasShape()) {
                            newBuilder2.mergeFrom(getShape());
                        }
                        kVar.A(newBuilder2, tVar);
                        setShape(newBuilder2.buildPartial());
                    }
                }
            }
        }

        static {
            PbFixture pbFixture = new PbFixture(true);
            defaultInstance = pbFixture;
            pbFixture.initFields();
        }

        public static PbFixture getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.b getDescriptor() {
            return Box2D.internal_static_box2d_PbFixture_descriptor;
        }

        private void initFields() {
            this.tag_ = 0L;
            this.restitution_ = 0.0f;
            this.friction_ = 0.0f;
            this.density_ = 0.0f;
            this.sensor_ = false;
            this.filter_ = PbFilter.getDefaultInstance();
            this.shape_ = PbShape.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$4900();
        }

        public static PbFixture parseDelimitedFrom(InputStream inputStream) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFixture parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString)).buildParsed();
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public float getDensity() {
            return this.density_;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public PbFilter getFilter() {
            return this.filter_;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public PbFilterOrBuilder getFilterOrBuilder() {
            return this.filter_;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public float getFriction() {
            return this.friction_;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public float getRestitution() {
            return this.restitution_;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public boolean getSensor() {
            return this.sensor_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i16 = 0 + CodedOutputStream.z(1, this.tag_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i16 += CodedOutputStream.r(2, this.restitution_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i16 += CodedOutputStream.r(3, this.friction_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i16 += CodedOutputStream.r(4, this.density_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i16 += CodedOutputStream.e(5, this.sensor_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i16 += CodedOutputStream.G(10, this.filter_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i16 += CodedOutputStream.G(11, this.shape_);
            }
            int serializedSize = i16 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public PbShape getShape() {
            return this.shape_;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public PbShapeOrBuilder getShapeOrBuilder() {
            return this.shape_;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public long getTag() {
            return this.tag_;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public boolean hasDensity() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public boolean hasFilter() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public boolean hasFriction() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public boolean hasRestitution() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public boolean hasSensor() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public boolean hasShape() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbFixtureOrBuilder
        public boolean hasTag() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.j internalGetFieldAccessorTable() {
            return Box2D.internal_static_box2d_PbFixture_fieldAccessorTable;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 != -1) {
                if (b16 != 1) {
                    return false;
                }
                return true;
            }
            if (hasShape() && !getShape().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.I0(1, this.tag_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.A0(2, this.restitution_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.A0(3, this.friction_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.A0(4, this.density_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m0(5, this.sensor_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.K0(10, this.filter_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.K0(11, this.shape_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        PbFixture(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Builder newBuilder(PbFixture pbFixture) {
            return newBuilder().mergeFrom(pbFixture);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFixture parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFixture parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.av, com.google.protobuf.ax
        public PbFixture getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static PbFixture parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream, tVar)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFixture parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr, tVar)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder newBuilderForType() {
            return newBuilder();
        }

        PbFixture(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFixture parseFrom(InputStream inputStream) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.g gVar) {
            return new Builder(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFixture parseFrom(InputStream inputStream, t tVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbFixture parseFrom(k kVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(kVar)).buildParsed();
        }

        public static PbFixture parseFrom(k kVar, t tVar) throws IOException {
            return newBuilder().mergeFrom(kVar, tVar).buildParsed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface PbFixtureOrBuilder extends ax {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.ax
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Override // com.google.protobuf.ax
        /* synthetic */ ar getDefaultInstanceForType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        float getDensity();

        @Override // com.google.protobuf.ax
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        PbFilter getFilter();

        PbFilterOrBuilder getFilterOrBuilder();

        float getFriction();

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar);

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        float getRestitution();

        boolean getSensor();

        PbShape getShape();

        PbShapeOrBuilder getShapeOrBuilder();

        long getTag();

        @Override // com.google.protobuf.ax
        /* synthetic */ cc getUnknownFields();

        boolean hasDensity();

        @Override // com.google.protobuf.ax
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasFilter();

        boolean hasFriction();

        /* synthetic */ boolean hasOneof(Descriptors.g gVar);

        boolean hasRestitution();

        boolean hasSensor();

        boolean hasShape();

        boolean hasTag();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PbJoint extends GeneratedMessage implements PbJointOrBuilder {
        public static final int BODIES_FIELD_NUMBER = 110;
        public static final int BODY_A_FIELD_NUMBER = 3;
        public static final int BODY_B_FIELD_NUMBER = 4;
        public static final int COLLIDECONNECTED_FIELD_NUMBER = 5;
        public static final int DAMPING_RATIO_FIELD_NUMBER = 32;
        public static final int ENABLE_LIMIT_FIELD_NUMBER = 12;
        public static final int ENABLE_MOTOR_FIELD_NUMBER = 15;
        public static final int FREQUENCY_FIELD_NUMBER = 31;
        public static final int GROUND_ANCHOR_A_FIELD_NUMBER = 40;
        public static final int GROUND_ANCHOR_B_FIELD_NUMBER = 41;
        public static final int JOINT1_FIELD_NUMBER = 61;
        public static final int JOINT2_FIELD_NUMBER = 62;
        public static final int JOINTS_FIELD_NUMBER = 111;
        public static final int LENGTH_A_FIELD_NUMBER = 42;
        public static final int LENGTH_B_FIELD_NUMBER = 43;
        public static final int LENGTH_FIELD_NUMBER = 30;
        public static final int LOCAL_ANCHOR_A_FIELD_NUMBER = 6;
        public static final int LOCAL_ANCHOR_B_FIELD_NUMBER = 7;
        public static final int LOCAL_AXIS_A_FIELD_NUMBER = 20;
        public static final int LOWER_LIMIT_FIELD_NUMBER = 13;
        public static final int MAX_FORCE_FIELD_NUMBER = 51;
        public static final int MAX_LENGTH_FIELD_NUMBER = 100;
        public static final int MAX_MOTOR_FORCE_FIELD_NUMBER = 21;
        public static final int MAX_MOTOR_TORQUE_FIELD_NUMBER = 17;
        public static final int MAX_TORQUE_FIELD_NUMBER = 90;
        public static final int MOTOR_SPEED_FIELD_NUMBER = 16;
        public static final int RATIO_FIELD_NUMBER = 44;
        public static final int REF_ANGLE_FIELD_NUMBER = 10;
        public static final int TAG_FIELD_NUMBER = 1;
        public static final int TARGET_FIELD_NUMBER = 50;
        public static final int TYPE_FIELD_NUMBER = 2;
        public static final int UPPER_LIMIT_FIELD_NUMBER = 14;
        private static final PbJoint defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<Integer> bodies_;
        private int bodyA_;
        private int bodyB_;
        private boolean collideConnected_;
        private float dampingRatio_;
        private boolean enableLimit_;
        private boolean enableMotor_;
        private float frequency_;
        private PbVec2 groundAnchorA_;
        private PbVec2 groundAnchorB_;
        private int joint1_;
        private int joint2_;
        private List<Integer> joints_;
        private float lengthA_;
        private float lengthB_;
        private float length_;
        private PbVec2 localAnchorA_;
        private PbVec2 localAnchorB_;
        private PbVec2 localAxisA_;
        private float lowerLimit_;
        private float maxForce_;
        private float maxLength_;
        private float maxMotorForce_;
        private float maxMotorTorque_;
        private float maxTorque_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private float motorSpeed_;
        private float ratio_;
        private float refAngle_;
        private long tag_;
        private PbVec2 target_;
        private PbJointType type_;
        private float upperLimit_;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Builder extends GeneratedMessage.f<Builder> implements PbJointOrBuilder {
            private int bitField0_;
            private List<Integer> bodies_;
            private int bodyA_;
            private int bodyB_;
            private boolean collideConnected_;
            private float dampingRatio_;
            private boolean enableLimit_;
            private boolean enableMotor_;
            private float frequency_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> groundAnchorABuilder_;
            private PbVec2 groundAnchorA_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> groundAnchorBBuilder_;
            private PbVec2 groundAnchorB_;
            private int joint1_;
            private int joint2_;
            private List<Integer> joints_;
            private float lengthA_;
            private float lengthB_;
            private float length_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> localAnchorABuilder_;
            private PbVec2 localAnchorA_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> localAnchorBBuilder_;
            private PbVec2 localAnchorB_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> localAxisABuilder_;
            private PbVec2 localAxisA_;
            private float lowerLimit_;
            private float maxForce_;
            private float maxLength_;
            private float maxMotorForce_;
            private float maxMotorTorque_;
            private float maxTorque_;
            private float motorSpeed_;
            private float ratio_;
            private float refAngle_;
            private long tag_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> targetBuilder_;
            private PbVec2 target_;
            private PbJointType type_;
            private float upperLimit_;

            static /* synthetic */ Builder access$6400() {
                return create();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PbJoint buildParsed() throws InvalidProtocolBufferException {
                PbJoint buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial).asInvalidProtocolBufferException();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureBodiesIsMutable() {
                if ((this.bitField0_ & 1073741824) != 1073741824) {
                    this.bodies_ = new ArrayList(this.bodies_);
                    this.bitField0_ |= 1073741824;
                }
            }

            private void ensureJointsIsMutable() {
                if ((this.bitField0_ & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                    this.joints_ = new ArrayList(this.joints_);
                    this.bitField0_ |= Integer.MIN_VALUE;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return Box2D.internal_static_box2d_PbJoint_descriptor;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getGroundAnchorAFieldBuilder() {
                if (this.groundAnchorABuilder_ == null) {
                    this.groundAnchorABuilder_ = new bt<>(this.groundAnchorA_, getParentForChildren(), isClean());
                    this.groundAnchorA_ = null;
                }
                return this.groundAnchorABuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getGroundAnchorBFieldBuilder() {
                if (this.groundAnchorBBuilder_ == null) {
                    this.groundAnchorBBuilder_ = new bt<>(this.groundAnchorB_, getParentForChildren(), isClean());
                    this.groundAnchorB_ = null;
                }
                return this.groundAnchorBBuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getLocalAnchorAFieldBuilder() {
                if (this.localAnchorABuilder_ == null) {
                    this.localAnchorABuilder_ = new bt<>(this.localAnchorA_, getParentForChildren(), isClean());
                    this.localAnchorA_ = null;
                }
                return this.localAnchorABuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getLocalAnchorBFieldBuilder() {
                if (this.localAnchorBBuilder_ == null) {
                    this.localAnchorBBuilder_ = new bt<>(this.localAnchorB_, getParentForChildren(), isClean());
                    this.localAnchorB_ = null;
                }
                return this.localAnchorBBuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getLocalAxisAFieldBuilder() {
                if (this.localAxisABuilder_ == null) {
                    this.localAxisABuilder_ = new bt<>(this.localAxisA_, getParentForChildren(), isClean());
                    this.localAxisA_ = null;
                }
                return this.localAxisABuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getTargetFieldBuilder() {
                if (this.targetBuilder_ == null) {
                    this.targetBuilder_ = new bt<>(this.target_, getParentForChildren(), isClean());
                    this.target_ = null;
                }
                return this.targetBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getLocalAnchorAFieldBuilder();
                    getLocalAnchorBFieldBuilder();
                    getLocalAxisAFieldBuilder();
                    getGroundAnchorAFieldBuilder();
                    getGroundAnchorBFieldBuilder();
                    getTargetFieldBuilder();
                }
            }

            public Builder addAllBodies(Iterable<? extends Integer> iterable) {
                ensureBodiesIsMutable();
                b.a.addAll((Iterable) iterable, (Collection) this.bodies_);
                onChanged();
                return this;
            }

            public Builder addAllJoints(Iterable<? extends Integer> iterable) {
                ensureJointsIsMutable();
                b.a.addAll((Iterable) iterable, (Collection) this.joints_);
                onChanged();
                return this;
            }

            public Builder addBodies(int i3) {
                ensureBodiesIsMutable();
                this.bodies_.add(Integer.valueOf(i3));
                onChanged();
                return this;
            }

            public Builder addJoints(int i3) {
                ensureJointsIsMutable();
                this.joints_.add(Integer.valueOf(i3));
                onChanged();
                return this;
            }

            public Builder clearBodies() {
                this.bodies_ = Collections.emptyList();
                this.bitField0_ &= -1073741825;
                onChanged();
                return this;
            }

            public Builder clearBodyA() {
                this.bitField0_ &= -5;
                this.bodyA_ = 0;
                onChanged();
                return this;
            }

            public Builder clearBodyB() {
                this.bitField0_ &= -9;
                this.bodyB_ = 0;
                onChanged();
                return this;
            }

            public Builder clearCollideConnected() {
                this.bitField0_ &= -17;
                this.collideConnected_ = false;
                onChanged();
                return this;
            }

            public Builder clearDampingRatio() {
                this.bitField0_ &= -262145;
                this.dampingRatio_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearEnableLimit() {
                this.bitField0_ &= -257;
                this.enableLimit_ = false;
                onChanged();
                return this;
            }

            public Builder clearEnableMotor() {
                this.bitField0_ &= MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                this.enableMotor_ = false;
                onChanged();
                return this;
            }

            public Builder clearFrequency() {
                this.bitField0_ &= -131073;
                this.frequency_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearGroundAnchorA() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorABuilder_;
                if (btVar == null) {
                    this.groundAnchorA_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -524289;
                return this;
            }

            public Builder clearGroundAnchorB() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorBBuilder_;
                if (btVar == null) {
                    this.groundAnchorB_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -1048577;
                return this;
            }

            public Builder clearJoint1() {
                this.bitField0_ &= -67108865;
                this.joint1_ = 0;
                onChanged();
                return this;
            }

            public Builder clearJoint2() {
                this.bitField0_ &= -134217729;
                this.joint2_ = 0;
                onChanged();
                return this;
            }

            public Builder clearJoints() {
                this.joints_ = Collections.emptyList();
                this.bitField0_ &= Integer.MAX_VALUE;
                onChanged();
                return this;
            }

            public Builder clearLength() {
                this.bitField0_ &= -65537;
                this.length_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearLengthA() {
                this.bitField0_ &= -2097153;
                this.lengthA_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearLengthB() {
                this.bitField0_ &= -4194305;
                this.lengthB_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearLocalAnchorA() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorABuilder_;
                if (btVar == null) {
                    this.localAnchorA_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearLocalAnchorB() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorBBuilder_;
                if (btVar == null) {
                    this.localAnchorB_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearLocalAxisA() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAxisABuilder_;
                if (btVar == null) {
                    this.localAxisA_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -16385;
                return this;
            }

            public Builder clearLowerLimit() {
                this.bitField0_ &= -513;
                this.lowerLimit_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearMaxForce() {
                this.bitField0_ &= -33554433;
                this.maxForce_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearMaxLength() {
                this.bitField0_ &= -536870913;
                this.maxLength_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearMaxMotorForce() {
                this.bitField0_ &= -32769;
                this.maxMotorForce_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearMaxMotorTorque() {
                this.bitField0_ &= -8193;
                this.maxMotorTorque_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearMaxTorque() {
                this.bitField0_ &= -268435457;
                this.maxTorque_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearMotorSpeed() {
                this.bitField0_ &= -4097;
                this.motorSpeed_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearRatio() {
                this.bitField0_ &= -8388609;
                this.ratio_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearRefAngle() {
                this.bitField0_ &= -129;
                this.refAngle_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearTag() {
                this.bitField0_ &= -2;
                this.tag_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearTarget() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.targetBuilder_;
                if (btVar == null) {
                    this.target_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -16777217;
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -3;
                this.type_ = PbJointType.DISTANCE;
                onChanged();
                return this;
            }

            public Builder clearUpperLimit() {
                this.bitField0_ &= -1025;
                this.upperLimit_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public int getBodies(int i3) {
                return this.bodies_.get(i3).intValue();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public int getBodiesCount() {
                return this.bodies_.size();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public List<Integer> getBodiesList() {
                return Collections.unmodifiableList(this.bodies_);
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public int getBodyA() {
                return this.bodyA_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public int getBodyB() {
                return this.bodyB_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean getCollideConnected() {
                return this.collideConnected_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getDampingRatio() {
                return this.dampingRatio_;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return PbJoint.getDescriptor();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean getEnableLimit() {
                return this.enableLimit_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean getEnableMotor() {
                return this.enableMotor_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getFrequency() {
                return this.frequency_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2 getGroundAnchorA() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorABuilder_;
                if (btVar == null) {
                    return this.groundAnchorA_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getGroundAnchorABuilder() {
                this.bitField0_ |= 524288;
                onChanged();
                return getGroundAnchorAFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2OrBuilder getGroundAnchorAOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorABuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.groundAnchorA_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2 getGroundAnchorB() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorBBuilder_;
                if (btVar == null) {
                    return this.groundAnchorB_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getGroundAnchorBBuilder() {
                this.bitField0_ |= 1048576;
                onChanged();
                return getGroundAnchorBFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2OrBuilder getGroundAnchorBOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorBBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.groundAnchorB_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public int getJoint1() {
                return this.joint1_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public int getJoint2() {
                return this.joint2_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public int getJoints(int i3) {
                return this.joints_.get(i3).intValue();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public int getJointsCount() {
                return this.joints_.size();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public List<Integer> getJointsList() {
                return Collections.unmodifiableList(this.joints_);
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getLength() {
                return this.length_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getLengthA() {
                return this.lengthA_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getLengthB() {
                return this.lengthB_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2 getLocalAnchorA() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorABuilder_;
                if (btVar == null) {
                    return this.localAnchorA_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getLocalAnchorABuilder() {
                this.bitField0_ |= 32;
                onChanged();
                return getLocalAnchorAFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2OrBuilder getLocalAnchorAOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorABuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.localAnchorA_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2 getLocalAnchorB() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorBBuilder_;
                if (btVar == null) {
                    return this.localAnchorB_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getLocalAnchorBBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return getLocalAnchorBFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2OrBuilder getLocalAnchorBOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorBBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.localAnchorB_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2 getLocalAxisA() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAxisABuilder_;
                if (btVar == null) {
                    return this.localAxisA_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getLocalAxisABuilder() {
                this.bitField0_ |= 16384;
                onChanged();
                return getLocalAxisAFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2OrBuilder getLocalAxisAOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAxisABuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.localAxisA_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getLowerLimit() {
                return this.lowerLimit_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getMaxForce() {
                return this.maxForce_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getMaxLength() {
                return this.maxLength_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getMaxMotorForce() {
                return this.maxMotorForce_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getMaxMotorTorque() {
                return this.maxMotorTorque_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getMaxTorque() {
                return this.maxTorque_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getMotorSpeed() {
                return this.motorSpeed_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getRatio() {
                return this.ratio_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getRefAngle() {
                return this.refAngle_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public long getTag() {
                return this.tag_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2 getTarget() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.targetBuilder_;
                if (btVar == null) {
                    return this.target_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getTargetBuilder() {
                this.bitField0_ |= 16777216;
                onChanged();
                return getTargetFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbVec2OrBuilder getTargetOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.targetBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.target_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public PbJointType getType() {
                return this.type_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public float getUpperLimit() {
                return this.upperLimit_;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasBodyA() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasBodyB() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasCollideConnected() {
                if ((this.bitField0_ & 16) == 16) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasDampingRatio() {
                if ((this.bitField0_ & 262144) == 262144) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasEnableLimit() {
                if ((this.bitField0_ & 256) == 256) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasEnableMotor() {
                if ((this.bitField0_ & 2048) == 2048) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasFrequency() {
                if ((this.bitField0_ & 131072) == 131072) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasGroundAnchorA() {
                if ((this.bitField0_ & 524288) == 524288) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasGroundAnchorB() {
                if ((this.bitField0_ & 1048576) == 1048576) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasJoint1() {
                if ((this.bitField0_ & 67108864) == 67108864) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasJoint2() {
                if ((this.bitField0_ & 134217728) == 134217728) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasLength() {
                if ((this.bitField0_ & 65536) == 65536) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasLengthA() {
                if ((this.bitField0_ & 2097152) == 2097152) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasLengthB() {
                if ((this.bitField0_ & 4194304) == 4194304) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasLocalAnchorA() {
                if ((this.bitField0_ & 32) == 32) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasLocalAnchorB() {
                if ((this.bitField0_ & 64) == 64) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasLocalAxisA() {
                if ((this.bitField0_ & 16384) == 16384) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasLowerLimit() {
                if ((this.bitField0_ & 512) == 512) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasMaxForce() {
                if ((this.bitField0_ & 33554432) == 33554432) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasMaxLength() {
                if ((this.bitField0_ & 536870912) == 536870912) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasMaxMotorForce() {
                if ((this.bitField0_ & 32768) == 32768) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasMaxMotorTorque() {
                if ((this.bitField0_ & 8192) == 8192) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasMaxTorque() {
                if ((this.bitField0_ & 268435456) == 268435456) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasMotorSpeed() {
                if ((this.bitField0_ & 4096) == 4096) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasRatio() {
                if ((this.bitField0_ & 8388608) == 8388608) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasRefAngle() {
                if ((this.bitField0_ & 128) == 128) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasTag() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasTarget() {
                if ((this.bitField0_ & 16777216) == 16777216) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasType() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbJointOrBuilder
            public boolean hasUpperLimit() {
                if ((this.bitField0_ & 1024) == 1024) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.f
            protected GeneratedMessage.j internalGetFieldAccessorTable() {
                return Box2D.internal_static_box2d_PbJoint_fieldAccessorTable;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.av
            public final boolean isInitialized() {
                if (!hasType()) {
                    return false;
                }
                if (hasLocalAnchorA() && !getLocalAnchorA().isInitialized()) {
                    return false;
                }
                if (hasLocalAnchorB() && !getLocalAnchorB().isInitialized()) {
                    return false;
                }
                if (hasLocalAxisA() && !getLocalAxisA().isInitialized()) {
                    return false;
                }
                if (hasGroundAnchorA() && !getGroundAnchorA().isInitialized()) {
                    return false;
                }
                if (hasGroundAnchorB() && !getGroundAnchorB().isInitialized()) {
                    return false;
                }
                if (hasTarget() && !getTarget().isInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeGroundAnchorA(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorABuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 524288) == 524288 && this.groundAnchorA_ != PbVec2.getDefaultInstance()) {
                        this.groundAnchorA_ = PbVec2.newBuilder(this.groundAnchorA_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.groundAnchorA_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 524288;
                return this;
            }

            public Builder mergeGroundAnchorB(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorBBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 1048576) == 1048576 && this.groundAnchorB_ != PbVec2.getDefaultInstance()) {
                        this.groundAnchorB_ = PbVec2.newBuilder(this.groundAnchorB_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.groundAnchorB_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 1048576;
                return this;
            }

            public Builder mergeLocalAnchorA(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorABuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 32) == 32 && this.localAnchorA_ != PbVec2.getDefaultInstance()) {
                        this.localAnchorA_ = PbVec2.newBuilder(this.localAnchorA_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.localAnchorA_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeLocalAnchorB(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorBBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 64) == 64 && this.localAnchorB_ != PbVec2.getDefaultInstance()) {
                        this.localAnchorB_ = PbVec2.newBuilder(this.localAnchorB_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.localAnchorB_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeLocalAxisA(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAxisABuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 16384) == 16384 && this.localAxisA_ != PbVec2.getDefaultInstance()) {
                        this.localAxisA_ = PbVec2.newBuilder(this.localAxisA_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.localAxisA_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 16384;
                return this;
            }

            public Builder mergeTarget(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.targetBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 16777216) == 16777216 && this.target_ != PbVec2.getDefaultInstance()) {
                        this.target_ = PbVec2.newBuilder(this.target_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.target_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 16777216;
                return this;
            }

            public Builder setBodies(int i3, int i16) {
                ensureBodiesIsMutable();
                this.bodies_.set(i3, Integer.valueOf(i16));
                onChanged();
                return this;
            }

            public Builder setBodyA(int i3) {
                this.bitField0_ |= 4;
                this.bodyA_ = i3;
                onChanged();
                return this;
            }

            public Builder setBodyB(int i3) {
                this.bitField0_ |= 8;
                this.bodyB_ = i3;
                onChanged();
                return this;
            }

            public Builder setCollideConnected(boolean z16) {
                this.bitField0_ |= 16;
                this.collideConnected_ = z16;
                onChanged();
                return this;
            }

            public Builder setDampingRatio(float f16) {
                this.bitField0_ |= 262144;
                this.dampingRatio_ = f16;
                onChanged();
                return this;
            }

            public Builder setEnableLimit(boolean z16) {
                this.bitField0_ |= 256;
                this.enableLimit_ = z16;
                onChanged();
                return this;
            }

            public Builder setEnableMotor(boolean z16) {
                this.bitField0_ |= 2048;
                this.enableMotor_ = z16;
                onChanged();
                return this;
            }

            public Builder setFrequency(float f16) {
                this.bitField0_ |= 131072;
                this.frequency_ = f16;
                onChanged();
                return this;
            }

            public Builder setGroundAnchorA(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorABuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.groundAnchorA_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 524288;
                return this;
            }

            public Builder setGroundAnchorB(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorBBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.groundAnchorB_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 1048576;
                return this;
            }

            public Builder setJoint1(int i3) {
                this.bitField0_ |= 67108864;
                this.joint1_ = i3;
                onChanged();
                return this;
            }

            public Builder setJoint2(int i3) {
                this.bitField0_ |= 134217728;
                this.joint2_ = i3;
                onChanged();
                return this;
            }

            public Builder setJoints(int i3, int i16) {
                ensureJointsIsMutable();
                this.joints_.set(i3, Integer.valueOf(i16));
                onChanged();
                return this;
            }

            public Builder setLength(float f16) {
                this.bitField0_ |= 65536;
                this.length_ = f16;
                onChanged();
                return this;
            }

            public Builder setLengthA(float f16) {
                this.bitField0_ |= 2097152;
                this.lengthA_ = f16;
                onChanged();
                return this;
            }

            public Builder setLengthB(float f16) {
                this.bitField0_ |= 4194304;
                this.lengthB_ = f16;
                onChanged();
                return this;
            }

            public Builder setLocalAnchorA(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorABuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.localAnchorA_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setLocalAnchorB(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorBBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.localAnchorB_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setLocalAxisA(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAxisABuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.localAxisA_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 16384;
                return this;
            }

            public Builder setLowerLimit(float f16) {
                this.bitField0_ |= 512;
                this.lowerLimit_ = f16;
                onChanged();
                return this;
            }

            public Builder setMaxForce(float f16) {
                this.bitField0_ |= 33554432;
                this.maxForce_ = f16;
                onChanged();
                return this;
            }

            public Builder setMaxLength(float f16) {
                this.bitField0_ |= 536870912;
                this.maxLength_ = f16;
                onChanged();
                return this;
            }

            public Builder setMaxMotorForce(float f16) {
                this.bitField0_ |= 32768;
                this.maxMotorForce_ = f16;
                onChanged();
                return this;
            }

            public Builder setMaxMotorTorque(float f16) {
                this.bitField0_ |= 8192;
                this.maxMotorTorque_ = f16;
                onChanged();
                return this;
            }

            public Builder setMaxTorque(float f16) {
                this.bitField0_ |= 268435456;
                this.maxTorque_ = f16;
                onChanged();
                return this;
            }

            public Builder setMotorSpeed(float f16) {
                this.bitField0_ |= 4096;
                this.motorSpeed_ = f16;
                onChanged();
                return this;
            }

            public Builder setRatio(float f16) {
                this.bitField0_ |= 8388608;
                this.ratio_ = f16;
                onChanged();
                return this;
            }

            public Builder setRefAngle(float f16) {
                this.bitField0_ |= 128;
                this.refAngle_ = f16;
                onChanged();
                return this;
            }

            public Builder setTag(long j3) {
                this.bitField0_ |= 1;
                this.tag_ = j3;
                onChanged();
                return this;
            }

            public Builder setTarget(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.targetBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.target_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 16777216;
                return this;
            }

            public Builder setType(PbJointType pbJointType) {
                pbJointType.getClass();
                this.bitField0_ |= 2;
                this.type_ = pbJointType;
                onChanged();
                return this;
            }

            public Builder setUpperLimit(float f16) {
                this.bitField0_ |= 1024;
                this.upperLimit_ = f16;
                onChanged();
                return this;
            }

            Builder() {
                this.type_ = PbJointType.DISTANCE;
                this.localAnchorA_ = PbVec2.getDefaultInstance();
                this.localAnchorB_ = PbVec2.getDefaultInstance();
                this.localAxisA_ = PbVec2.getDefaultInstance();
                this.groundAnchorA_ = PbVec2.getDefaultInstance();
                this.groundAnchorB_ = PbVec2.getDefaultInstance();
                this.target_ = PbVec2.getDefaultInstance();
                this.bodies_ = Collections.emptyList();
                this.joints_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbJoint build() {
                PbJoint buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbJoint buildPartial() {
                PbJoint pbJoint = new PbJoint(this);
                int i3 = this.bitField0_;
                int i16 = (i3 & 1) != 1 ? 0 : 1;
                pbJoint.tag_ = this.tag_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                pbJoint.type_ = this.type_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                pbJoint.bodyA_ = this.bodyA_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                pbJoint.bodyB_ = this.bodyB_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                pbJoint.collideConnected_ = this.collideConnected_;
                if ((i3 & 32) == 32) {
                    i16 |= 32;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorABuilder_;
                if (btVar == null) {
                    pbJoint.localAnchorA_ = this.localAnchorA_;
                } else {
                    pbJoint.localAnchorA_ = btVar.b();
                }
                if ((i3 & 64) == 64) {
                    i16 |= 64;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar2 = this.localAnchorBBuilder_;
                if (btVar2 == null) {
                    pbJoint.localAnchorB_ = this.localAnchorB_;
                } else {
                    pbJoint.localAnchorB_ = btVar2.b();
                }
                if ((i3 & 128) == 128) {
                    i16 |= 128;
                }
                pbJoint.refAngle_ = this.refAngle_;
                if ((i3 & 256) == 256) {
                    i16 |= 256;
                }
                pbJoint.enableLimit_ = this.enableLimit_;
                if ((i3 & 512) == 512) {
                    i16 |= 512;
                }
                pbJoint.lowerLimit_ = this.lowerLimit_;
                if ((i3 & 1024) == 1024) {
                    i16 |= 1024;
                }
                pbJoint.upperLimit_ = this.upperLimit_;
                if ((i3 & 2048) == 2048) {
                    i16 |= 2048;
                }
                pbJoint.enableMotor_ = this.enableMotor_;
                if ((i3 & 4096) == 4096) {
                    i16 |= 4096;
                }
                pbJoint.motorSpeed_ = this.motorSpeed_;
                if ((i3 & 8192) == 8192) {
                    i16 |= 8192;
                }
                pbJoint.maxMotorTorque_ = this.maxMotorTorque_;
                if ((i3 & 16384) == 16384) {
                    i16 |= 16384;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar3 = this.localAxisABuilder_;
                if (btVar3 == null) {
                    pbJoint.localAxisA_ = this.localAxisA_;
                } else {
                    pbJoint.localAxisA_ = btVar3.b();
                }
                if ((i3 & 32768) == 32768) {
                    i16 |= 32768;
                }
                pbJoint.maxMotorForce_ = this.maxMotorForce_;
                if ((i3 & 65536) == 65536) {
                    i16 |= 65536;
                }
                pbJoint.length_ = this.length_;
                if ((i3 & 131072) == 131072) {
                    i16 |= 131072;
                }
                pbJoint.frequency_ = this.frequency_;
                if ((i3 & 262144) == 262144) {
                    i16 |= 262144;
                }
                pbJoint.dampingRatio_ = this.dampingRatio_;
                if ((i3 & 524288) == 524288) {
                    i16 |= 524288;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar4 = this.groundAnchorABuilder_;
                if (btVar4 == null) {
                    pbJoint.groundAnchorA_ = this.groundAnchorA_;
                } else {
                    pbJoint.groundAnchorA_ = btVar4.b();
                }
                if ((i3 & 1048576) == 1048576) {
                    i16 |= 1048576;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar5 = this.groundAnchorBBuilder_;
                if (btVar5 == null) {
                    pbJoint.groundAnchorB_ = this.groundAnchorB_;
                } else {
                    pbJoint.groundAnchorB_ = btVar5.b();
                }
                if ((i3 & 2097152) == 2097152) {
                    i16 |= 2097152;
                }
                pbJoint.lengthA_ = this.lengthA_;
                if ((4194304 & i3) == 4194304) {
                    i16 |= 4194304;
                }
                pbJoint.lengthB_ = this.lengthB_;
                if ((8388608 & i3) == 8388608) {
                    i16 |= 8388608;
                }
                pbJoint.ratio_ = this.ratio_;
                if ((16777216 & i3) == 16777216) {
                    i16 |= 16777216;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar6 = this.targetBuilder_;
                if (btVar6 == null) {
                    pbJoint.target_ = this.target_;
                } else {
                    pbJoint.target_ = btVar6.b();
                }
                if ((33554432 & i3) == 33554432) {
                    i16 |= 33554432;
                }
                pbJoint.maxForce_ = this.maxForce_;
                if ((67108864 & i3) == 67108864) {
                    i16 |= 67108864;
                }
                pbJoint.joint1_ = this.joint1_;
                if ((134217728 & i3) == 134217728) {
                    i16 |= 134217728;
                }
                pbJoint.joint2_ = this.joint2_;
                if ((268435456 & i3) == 268435456) {
                    i16 |= 268435456;
                }
                pbJoint.maxTorque_ = this.maxTorque_;
                if ((i3 & 536870912) == 536870912) {
                    i16 |= 536870912;
                }
                pbJoint.maxLength_ = this.maxLength_;
                if ((this.bitField0_ & 1073741824) == 1073741824) {
                    this.bodies_ = Collections.unmodifiableList(this.bodies_);
                    this.bitField0_ &= -1073741825;
                }
                pbJoint.bodies_ = this.bodies_;
                if ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                    this.joints_ = Collections.unmodifiableList(this.joints_);
                    this.bitField0_ &= Integer.MAX_VALUE;
                }
                pbJoint.joints_ = this.joints_;
                pbJoint.bitField0_ = i16;
                onBuilt();
                return pbJoint;
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            public PbJoint getDefaultInstanceForType() {
                return PbJoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a
            public Builder clear() {
                super.clear();
                this.tag_ = 0L;
                int i3 = this.bitField0_ & (-2);
                this.bitField0_ = i3;
                this.type_ = PbJointType.DISTANCE;
                this.bodyA_ = 0;
                this.bodyB_ = 0;
                this.collideConnected_ = false;
                this.bitField0_ = i3 & (-3) & (-5) & (-9) & (-17);
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorABuilder_;
                if (btVar == null) {
                    this.localAnchorA_ = PbVec2.getDefaultInstance();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -33;
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar2 = this.localAnchorBBuilder_;
                if (btVar2 == null) {
                    this.localAnchorB_ = PbVec2.getDefaultInstance();
                } else {
                    btVar2.c();
                }
                int i16 = this.bitField0_ & (-65);
                this.refAngle_ = 0.0f;
                this.enableLimit_ = false;
                this.lowerLimit_ = 0.0f;
                this.upperLimit_ = 0.0f;
                this.enableMotor_ = false;
                int i17 = i16 & (-129) & (-257) & (-513) & (-1025) & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                this.motorSpeed_ = 0.0f;
                this.maxMotorTorque_ = 0.0f;
                this.bitField0_ = i17 & (-4097) & (-8193);
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar3 = this.localAxisABuilder_;
                if (btVar3 == null) {
                    this.localAxisA_ = PbVec2.getDefaultInstance();
                } else {
                    btVar3.c();
                }
                int i18 = this.bitField0_ & (-16385);
                this.maxMotorForce_ = 0.0f;
                this.length_ = 0.0f;
                this.frequency_ = 0.0f;
                this.dampingRatio_ = 0.0f;
                this.bitField0_ = i18 & (-32769) & (-65537) & (-131073) & (-262145);
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar4 = this.groundAnchorABuilder_;
                if (btVar4 == null) {
                    this.groundAnchorA_ = PbVec2.getDefaultInstance();
                } else {
                    btVar4.c();
                }
                this.bitField0_ &= -524289;
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar5 = this.groundAnchorBBuilder_;
                if (btVar5 == null) {
                    this.groundAnchorB_ = PbVec2.getDefaultInstance();
                } else {
                    btVar5.c();
                }
                int i19 = this.bitField0_ & (-1048577);
                this.lengthA_ = 0.0f;
                this.lengthB_ = 0.0f;
                this.ratio_ = 0.0f;
                this.bitField0_ = i19 & (-2097153) & (-4194305) & (-8388609);
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar6 = this.targetBuilder_;
                if (btVar6 == null) {
                    this.target_ = PbVec2.getDefaultInstance();
                } else {
                    btVar6.c();
                }
                int i26 = this.bitField0_ & (-16777217);
                this.maxForce_ = 0.0f;
                this.joint1_ = 0;
                this.joint2_ = 0;
                this.maxTorque_ = 0.0f;
                this.maxLength_ = 0.0f;
                this.bitField0_ = i26 & (-33554433) & (-67108865) & (-134217729) & (-268435457) & (-536870913);
                this.bodies_ = Collections.emptyList();
                this.bitField0_ &= -1073741825;
                this.joints_ = Collections.emptyList();
                this.bitField0_ &= Integer.MAX_VALUE;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
            /* renamed from: clone */
            public Builder mo50clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            public Builder mergeFrom(ar arVar) {
                if (arVar instanceof PbJoint) {
                    return mergeFrom((PbJoint) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public Builder setGroundAnchorA(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorABuilder_;
                if (btVar == null) {
                    this.groundAnchorA_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 524288;
                return this;
            }

            public Builder setGroundAnchorB(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.groundAnchorBBuilder_;
                if (btVar == null) {
                    this.groundAnchorB_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 1048576;
                return this;
            }

            public Builder setLocalAnchorA(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorABuilder_;
                if (btVar == null) {
                    this.localAnchorA_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setLocalAnchorB(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAnchorBBuilder_;
                if (btVar == null) {
                    this.localAnchorB_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setLocalAxisA(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.localAxisABuilder_;
                if (btVar == null) {
                    this.localAxisA_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 16384;
                return this;
            }

            public Builder setTarget(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.targetBuilder_;
                if (btVar == null) {
                    this.target_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 16777216;
                return this;
            }

            public Builder mergeFrom(PbJoint pbJoint) {
                if (pbJoint == PbJoint.getDefaultInstance()) {
                    return this;
                }
                if (pbJoint.hasTag()) {
                    setTag(pbJoint.getTag());
                }
                if (pbJoint.hasType()) {
                    setType(pbJoint.getType());
                }
                if (pbJoint.hasBodyA()) {
                    setBodyA(pbJoint.getBodyA());
                }
                if (pbJoint.hasBodyB()) {
                    setBodyB(pbJoint.getBodyB());
                }
                if (pbJoint.hasCollideConnected()) {
                    setCollideConnected(pbJoint.getCollideConnected());
                }
                if (pbJoint.hasLocalAnchorA()) {
                    mergeLocalAnchorA(pbJoint.getLocalAnchorA());
                }
                if (pbJoint.hasLocalAnchorB()) {
                    mergeLocalAnchorB(pbJoint.getLocalAnchorB());
                }
                if (pbJoint.hasRefAngle()) {
                    setRefAngle(pbJoint.getRefAngle());
                }
                if (pbJoint.hasEnableLimit()) {
                    setEnableLimit(pbJoint.getEnableLimit());
                }
                if (pbJoint.hasLowerLimit()) {
                    setLowerLimit(pbJoint.getLowerLimit());
                }
                if (pbJoint.hasUpperLimit()) {
                    setUpperLimit(pbJoint.getUpperLimit());
                }
                if (pbJoint.hasEnableMotor()) {
                    setEnableMotor(pbJoint.getEnableMotor());
                }
                if (pbJoint.hasMotorSpeed()) {
                    setMotorSpeed(pbJoint.getMotorSpeed());
                }
                if (pbJoint.hasMaxMotorTorque()) {
                    setMaxMotorTorque(pbJoint.getMaxMotorTorque());
                }
                if (pbJoint.hasLocalAxisA()) {
                    mergeLocalAxisA(pbJoint.getLocalAxisA());
                }
                if (pbJoint.hasMaxMotorForce()) {
                    setMaxMotorForce(pbJoint.getMaxMotorForce());
                }
                if (pbJoint.hasLength()) {
                    setLength(pbJoint.getLength());
                }
                if (pbJoint.hasFrequency()) {
                    setFrequency(pbJoint.getFrequency());
                }
                if (pbJoint.hasDampingRatio()) {
                    setDampingRatio(pbJoint.getDampingRatio());
                }
                if (pbJoint.hasGroundAnchorA()) {
                    mergeGroundAnchorA(pbJoint.getGroundAnchorA());
                }
                if (pbJoint.hasGroundAnchorB()) {
                    mergeGroundAnchorB(pbJoint.getGroundAnchorB());
                }
                if (pbJoint.hasLengthA()) {
                    setLengthA(pbJoint.getLengthA());
                }
                if (pbJoint.hasLengthB()) {
                    setLengthB(pbJoint.getLengthB());
                }
                if (pbJoint.hasRatio()) {
                    setRatio(pbJoint.getRatio());
                }
                if (pbJoint.hasTarget()) {
                    mergeTarget(pbJoint.getTarget());
                }
                if (pbJoint.hasMaxForce()) {
                    setMaxForce(pbJoint.getMaxForce());
                }
                if (pbJoint.hasJoint1()) {
                    setJoint1(pbJoint.getJoint1());
                }
                if (pbJoint.hasJoint2()) {
                    setJoint2(pbJoint.getJoint2());
                }
                if (pbJoint.hasMaxTorque()) {
                    setMaxTorque(pbJoint.getMaxTorque());
                }
                if (pbJoint.hasMaxLength()) {
                    setMaxLength(pbJoint.getMaxLength());
                }
                if (!pbJoint.bodies_.isEmpty()) {
                    if (this.bodies_.isEmpty()) {
                        this.bodies_ = pbJoint.bodies_;
                        this.bitField0_ &= -1073741825;
                    } else {
                        ensureBodiesIsMutable();
                        this.bodies_.addAll(pbJoint.bodies_);
                    }
                    onChanged();
                }
                if (!pbJoint.joints_.isEmpty()) {
                    if (this.joints_.isEmpty()) {
                        this.joints_ = pbJoint.joints_;
                        this.bitField0_ &= Integer.MAX_VALUE;
                    } else {
                        ensureJointsIsMutable();
                        this.joints_.addAll(pbJoint.joints_);
                    }
                    onChanged();
                }
                mo52mergeUnknownFields(pbJoint.getUnknownFields());
                return this;
            }

            Builder(GeneratedMessage.g gVar) {
                super(gVar);
                this.type_ = PbJointType.DISTANCE;
                this.localAnchorA_ = PbVec2.getDefaultInstance();
                this.localAnchorB_ = PbVec2.getDefaultInstance();
                this.localAxisA_ = PbVec2.getDefaultInstance();
                this.groundAnchorA_ = PbVec2.getDefaultInstance();
                this.groundAnchorB_ = PbVec2.getDefaultInstance();
                this.target_ = PbVec2.getDefaultInstance();
                this.bodies_ = Collections.emptyList();
                this.joints_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            public Builder mergeFrom(k kVar, t tVar) throws IOException {
                cc.b h16 = cc.h(getUnknownFields());
                while (true) {
                    int J = kVar.J();
                    switch (J) {
                        case 0:
                            setUnknownFields(h16.build());
                            onChanged();
                            return this;
                        case 8:
                            this.bitField0_ |= 1;
                            this.tag_ = kVar.y();
                            break;
                        case 16:
                            int s16 = kVar.s();
                            PbJointType valueOf = PbJointType.valueOf(s16);
                            if (valueOf == null) {
                                h16.r(2, s16);
                                break;
                            } else {
                                this.bitField0_ |= 2;
                                this.type_ = valueOf;
                                break;
                            }
                        case 24:
                            this.bitField0_ |= 4;
                            this.bodyA_ = kVar.x();
                            break;
                        case 32:
                            this.bitField0_ |= 8;
                            this.bodyB_ = kVar.x();
                            break;
                        case 40:
                            this.bitField0_ |= 16;
                            this.collideConnected_ = kVar.p();
                            break;
                        case 50:
                            PbVec2.Builder newBuilder = PbVec2.newBuilder();
                            if (hasLocalAnchorA()) {
                                newBuilder.mergeFrom(getLocalAnchorA());
                            }
                            kVar.A(newBuilder, tVar);
                            setLocalAnchorA(newBuilder.buildPartial());
                            break;
                        case 58:
                            PbVec2.Builder newBuilder2 = PbVec2.newBuilder();
                            if (hasLocalAnchorB()) {
                                newBuilder2.mergeFrom(getLocalAnchorB());
                            }
                            kVar.A(newBuilder2, tVar);
                            setLocalAnchorB(newBuilder2.buildPartial());
                            break;
                        case 85:
                            this.bitField0_ |= 128;
                            this.refAngle_ = kVar.v();
                            break;
                        case 96:
                            this.bitField0_ |= 256;
                            this.enableLimit_ = kVar.p();
                            break;
                        case 109:
                            this.bitField0_ |= 512;
                            this.lowerLimit_ = kVar.v();
                            break;
                        case 117:
                            this.bitField0_ |= 1024;
                            this.upperLimit_ = kVar.v();
                            break;
                        case 120:
                            this.bitField0_ |= 2048;
                            this.enableMotor_ = kVar.p();
                            break;
                        case 133:
                            this.bitField0_ |= 4096;
                            this.motorSpeed_ = kVar.v();
                            break;
                        case 141:
                            this.bitField0_ |= 8192;
                            this.maxMotorTorque_ = kVar.v();
                            break;
                        case 162:
                            PbVec2.Builder newBuilder3 = PbVec2.newBuilder();
                            if (hasLocalAxisA()) {
                                newBuilder3.mergeFrom(getLocalAxisA());
                            }
                            kVar.A(newBuilder3, tVar);
                            setLocalAxisA(newBuilder3.buildPartial());
                            break;
                        case 173:
                            this.bitField0_ |= 32768;
                            this.maxMotorForce_ = kVar.v();
                            break;
                        case 245:
                            this.bitField0_ |= 65536;
                            this.length_ = kVar.v();
                            break;
                        case 253:
                            this.bitField0_ |= 131072;
                            this.frequency_ = kVar.v();
                            break;
                        case 261:
                            this.bitField0_ |= 262144;
                            this.dampingRatio_ = kVar.v();
                            break;
                        case 322:
                            PbVec2.Builder newBuilder4 = PbVec2.newBuilder();
                            if (hasGroundAnchorA()) {
                                newBuilder4.mergeFrom(getGroundAnchorA());
                            }
                            kVar.A(newBuilder4, tVar);
                            setGroundAnchorA(newBuilder4.buildPartial());
                            break;
                        case MapItemKt.ITEM_AVATAR_MIN_WIDTH /* 330 */:
                            PbVec2.Builder newBuilder5 = PbVec2.newBuilder();
                            if (hasGroundAnchorB()) {
                                newBuilder5.mergeFrom(getGroundAnchorB());
                            }
                            kVar.A(newBuilder5, tVar);
                            setGroundAnchorB(newBuilder5.buildPartial());
                            break;
                        case 341:
                            this.bitField0_ |= 2097152;
                            this.lengthA_ = kVar.v();
                            break;
                        case 349:
                            this.bitField0_ |= 4194304;
                            this.lengthB_ = kVar.v();
                            break;
                        case 357:
                            this.bitField0_ |= 8388608;
                            this.ratio_ = kVar.v();
                            break;
                        case 402:
                            PbVec2.Builder newBuilder6 = PbVec2.newBuilder();
                            if (hasTarget()) {
                                newBuilder6.mergeFrom(getTarget());
                            }
                            kVar.A(newBuilder6, tVar);
                            setTarget(newBuilder6.buildPartial());
                            break;
                        case 413:
                            this.bitField0_ |= 33554432;
                            this.maxForce_ = kVar.v();
                            break;
                        case 488:
                            this.bitField0_ |= 67108864;
                            this.joint1_ = kVar.x();
                            break;
                        case w.CTRL_INDEX /* 496 */:
                            this.bitField0_ |= 134217728;
                            this.joint2_ = kVar.x();
                            break;
                        case 725:
                            this.bitField0_ |= 268435456;
                            this.maxTorque_ = kVar.v();
                            break;
                        case 805:
                            this.bitField0_ |= 536870912;
                            this.maxLength_ = kVar.v();
                            break;
                        case x.CTRL_INDEX /* 880 */:
                            ensureBodiesIsMutable();
                            this.bodies_.add(Integer.valueOf(kVar.x()));
                            break;
                        case 882:
                            int o16 = kVar.o(kVar.B());
                            while (kVar.d() > 0) {
                                addBodies(kVar.x());
                            }
                            kVar.n(o16);
                            break;
                        case 888:
                            ensureJointsIsMutable();
                            this.joints_.add(Integer.valueOf(kVar.x()));
                            break;
                        case y.CTRL_INDEX /* 890 */:
                            int o17 = kVar.o(kVar.B());
                            while (kVar.d() > 0) {
                                addJoints(kVar.x());
                            }
                            kVar.n(o17);
                            break;
                        default:
                            if (!parseUnknownField(kVar, h16, tVar, J)) {
                                setUnknownFields(h16.build());
                                onChanged();
                                return this;
                            }
                            break;
                    }
                }
            }
        }

        static {
            PbJoint pbJoint = new PbJoint(true);
            defaultInstance = pbJoint;
            pbJoint.initFields();
        }

        public static PbJoint getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.b getDescriptor() {
            return Box2D.internal_static_box2d_PbJoint_descriptor;
        }

        private void initFields() {
            this.tag_ = 0L;
            this.type_ = PbJointType.DISTANCE;
            this.bodyA_ = 0;
            this.bodyB_ = 0;
            this.collideConnected_ = false;
            this.localAnchorA_ = PbVec2.getDefaultInstance();
            this.localAnchorB_ = PbVec2.getDefaultInstance();
            this.refAngle_ = 0.0f;
            this.enableLimit_ = false;
            this.lowerLimit_ = 0.0f;
            this.upperLimit_ = 0.0f;
            this.enableMotor_ = false;
            this.motorSpeed_ = 0.0f;
            this.maxMotorTorque_ = 0.0f;
            this.localAxisA_ = PbVec2.getDefaultInstance();
            this.maxMotorForce_ = 0.0f;
            this.length_ = 0.0f;
            this.frequency_ = 0.0f;
            this.dampingRatio_ = 0.0f;
            this.groundAnchorA_ = PbVec2.getDefaultInstance();
            this.groundAnchorB_ = PbVec2.getDefaultInstance();
            this.lengthA_ = 0.0f;
            this.lengthB_ = 0.0f;
            this.ratio_ = 0.0f;
            this.target_ = PbVec2.getDefaultInstance();
            this.maxForce_ = 0.0f;
            this.joint1_ = 0;
            this.joint2_ = 0;
            this.maxTorque_ = 0.0f;
            this.maxLength_ = 0.0f;
            this.bodies_ = Collections.emptyList();
            this.joints_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$6400();
        }

        public static PbJoint parseDelimitedFrom(InputStream inputStream) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbJoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString)).buildParsed();
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public int getBodies(int i3) {
            return this.bodies_.get(i3).intValue();
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public int getBodiesCount() {
            return this.bodies_.size();
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public List<Integer> getBodiesList() {
            return this.bodies_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public int getBodyA() {
            return this.bodyA_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public int getBodyB() {
            return this.bodyB_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean getCollideConnected() {
            return this.collideConnected_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getDampingRatio() {
            return this.dampingRatio_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean getEnableLimit() {
            return this.enableLimit_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean getEnableMotor() {
            return this.enableMotor_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getFrequency() {
            return this.frequency_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2 getGroundAnchorA() {
            return this.groundAnchorA_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2OrBuilder getGroundAnchorAOrBuilder() {
            return this.groundAnchorA_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2 getGroundAnchorB() {
            return this.groundAnchorB_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2OrBuilder getGroundAnchorBOrBuilder() {
            return this.groundAnchorB_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public int getJoint1() {
            return this.joint1_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public int getJoint2() {
            return this.joint2_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public int getJoints(int i3) {
            return this.joints_.get(i3).intValue();
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public int getJointsCount() {
            return this.joints_.size();
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public List<Integer> getJointsList() {
            return this.joints_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getLength() {
            return this.length_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getLengthA() {
            return this.lengthA_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getLengthB() {
            return this.lengthB_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2 getLocalAnchorA() {
            return this.localAnchorA_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2OrBuilder getLocalAnchorAOrBuilder() {
            return this.localAnchorA_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2 getLocalAnchorB() {
            return this.localAnchorB_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2OrBuilder getLocalAnchorBOrBuilder() {
            return this.localAnchorB_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2 getLocalAxisA() {
            return this.localAxisA_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2OrBuilder getLocalAxisAOrBuilder() {
            return this.localAxisA_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getLowerLimit() {
            return this.lowerLimit_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getMaxForce() {
            return this.maxForce_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getMaxLength() {
            return this.maxLength_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getMaxMotorForce() {
            return this.maxMotorForce_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getMaxMotorTorque() {
            return this.maxMotorTorque_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getMaxTorque() {
            return this.maxTorque_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getMotorSpeed() {
            return this.motorSpeed_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getRatio() {
            return this.ratio_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getRefAngle() {
            return this.refAngle_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.z(1, this.tag_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.l(2, this.type_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.x(3, this.bodyA_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.x(4, this.bodyB_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.e(5, this.collideConnected_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.G(6, this.localAnchorA_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.G(7, this.localAnchorB_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i3 += CodedOutputStream.r(10, this.refAngle_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i3 += CodedOutputStream.e(12, this.enableLimit_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i3 += CodedOutputStream.r(13, this.lowerLimit_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                i3 += CodedOutputStream.r(14, this.upperLimit_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                i3 += CodedOutputStream.e(15, this.enableMotor_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                i3 += CodedOutputStream.r(16, this.motorSpeed_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                i3 += CodedOutputStream.r(17, this.maxMotorTorque_);
            }
            if ((this.bitField0_ & 16384) == 16384) {
                i3 += CodedOutputStream.G(20, this.localAxisA_);
            }
            if ((this.bitField0_ & 32768) == 32768) {
                i3 += CodedOutputStream.r(21, this.maxMotorForce_);
            }
            if ((this.bitField0_ & 65536) == 65536) {
                i3 += CodedOutputStream.r(30, this.length_);
            }
            if ((this.bitField0_ & 131072) == 131072) {
                i3 += CodedOutputStream.r(31, this.frequency_);
            }
            if ((this.bitField0_ & 262144) == 262144) {
                i3 += CodedOutputStream.r(32, this.dampingRatio_);
            }
            if ((this.bitField0_ & 524288) == 524288) {
                i3 += CodedOutputStream.G(40, this.groundAnchorA_);
            }
            if ((this.bitField0_ & 1048576) == 1048576) {
                i3 += CodedOutputStream.G(41, this.groundAnchorB_);
            }
            if ((this.bitField0_ & 2097152) == 2097152) {
                i3 += CodedOutputStream.r(42, this.lengthA_);
            }
            if ((this.bitField0_ & 4194304) == 4194304) {
                i3 += CodedOutputStream.r(43, this.lengthB_);
            }
            if ((this.bitField0_ & 8388608) == 8388608) {
                i3 += CodedOutputStream.r(44, this.ratio_);
            }
            if ((this.bitField0_ & 16777216) == 16777216) {
                i3 += CodedOutputStream.G(50, this.target_);
            }
            if ((this.bitField0_ & 33554432) == 33554432) {
                i3 += CodedOutputStream.r(51, this.maxForce_);
            }
            if ((this.bitField0_ & 67108864) == 67108864) {
                i3 += CodedOutputStream.x(61, this.joint1_);
            }
            if ((this.bitField0_ & 134217728) == 134217728) {
                i3 += CodedOutputStream.x(62, this.joint2_);
            }
            if ((this.bitField0_ & 268435456) == 268435456) {
                i3 += CodedOutputStream.r(90, this.maxTorque_);
            }
            if ((this.bitField0_ & 536870912) == 536870912) {
                i3 += CodedOutputStream.r(100, this.maxLength_);
            }
            int i17 = 0;
            for (int i18 = 0; i18 < this.bodies_.size(); i18++) {
                i17 += CodedOutputStream.y(this.bodies_.get(i18).intValue());
            }
            int size = i3 + i17 + (getBodiesList().size() * 2);
            int i19 = 0;
            for (int i26 = 0; i26 < this.joints_.size(); i26++) {
                i19 += CodedOutputStream.y(this.joints_.get(i26).intValue());
            }
            int size2 = size + i19 + (getJointsList().size() * 2) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size2;
            return size2;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public long getTag() {
            return this.tag_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2 getTarget() {
            return this.target_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbVec2OrBuilder getTargetOrBuilder() {
            return this.target_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public PbJointType getType() {
            return this.type_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public float getUpperLimit() {
            return this.upperLimit_;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasBodyA() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasBodyB() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasCollideConnected() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasDampingRatio() {
            if ((this.bitField0_ & 262144) == 262144) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasEnableLimit() {
            if ((this.bitField0_ & 256) == 256) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasEnableMotor() {
            if ((this.bitField0_ & 2048) == 2048) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasFrequency() {
            if ((this.bitField0_ & 131072) == 131072) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasGroundAnchorA() {
            if ((this.bitField0_ & 524288) == 524288) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasGroundAnchorB() {
            if ((this.bitField0_ & 1048576) == 1048576) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasJoint1() {
            if ((this.bitField0_ & 67108864) == 67108864) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasJoint2() {
            if ((this.bitField0_ & 134217728) == 134217728) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasLength() {
            if ((this.bitField0_ & 65536) == 65536) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasLengthA() {
            if ((this.bitField0_ & 2097152) == 2097152) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasLengthB() {
            if ((this.bitField0_ & 4194304) == 4194304) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasLocalAnchorA() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasLocalAnchorB() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasLocalAxisA() {
            if ((this.bitField0_ & 16384) == 16384) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasLowerLimit() {
            if ((this.bitField0_ & 512) == 512) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasMaxForce() {
            if ((this.bitField0_ & 33554432) == 33554432) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasMaxLength() {
            if ((this.bitField0_ & 536870912) == 536870912) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasMaxMotorForce() {
            if ((this.bitField0_ & 32768) == 32768) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasMaxMotorTorque() {
            if ((this.bitField0_ & 8192) == 8192) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasMaxTorque() {
            if ((this.bitField0_ & 268435456) == 268435456) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasMotorSpeed() {
            if ((this.bitField0_ & 4096) == 4096) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasRatio() {
            if ((this.bitField0_ & 8388608) == 8388608) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasRefAngle() {
            if ((this.bitField0_ & 128) == 128) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasTag() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasTarget() {
            if ((this.bitField0_ & 16777216) == 16777216) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbJointOrBuilder
        public boolean hasUpperLimit() {
            if ((this.bitField0_ & 1024) == 1024) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.j internalGetFieldAccessorTable() {
            return Box2D.internal_static_box2d_PbJoint_fieldAccessorTable;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 != -1) {
                if (b16 == 1) {
                    return true;
                }
                return false;
            }
            if (!hasType()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasLocalAnchorA() && !getLocalAnchorA().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasLocalAnchorB() && !getLocalAnchorB().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasLocalAxisA() && !getLocalAxisA().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasGroundAnchorA() && !getGroundAnchorA().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasGroundAnchorB() && !getGroundAnchorB().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasTarget() && !getTarget().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.I0(1, this.tag_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.u0(2, this.type_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.G0(3, this.bodyA_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.G0(4, this.bodyB_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m0(5, this.collideConnected_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.K0(6, this.localAnchorA_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.K0(7, this.localAnchorB_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.A0(10, this.refAngle_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.m0(12, this.enableLimit_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.A0(13, this.lowerLimit_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.A0(14, this.upperLimit_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.m0(15, this.enableMotor_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.A0(16, this.motorSpeed_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.A0(17, this.maxMotorTorque_);
            }
            if ((this.bitField0_ & 16384) == 16384) {
                codedOutputStream.K0(20, this.localAxisA_);
            }
            if ((this.bitField0_ & 32768) == 32768) {
                codedOutputStream.A0(21, this.maxMotorForce_);
            }
            if ((this.bitField0_ & 65536) == 65536) {
                codedOutputStream.A0(30, this.length_);
            }
            if ((this.bitField0_ & 131072) == 131072) {
                codedOutputStream.A0(31, this.frequency_);
            }
            if ((this.bitField0_ & 262144) == 262144) {
                codedOutputStream.A0(32, this.dampingRatio_);
            }
            if ((this.bitField0_ & 524288) == 524288) {
                codedOutputStream.K0(40, this.groundAnchorA_);
            }
            if ((this.bitField0_ & 1048576) == 1048576) {
                codedOutputStream.K0(41, this.groundAnchorB_);
            }
            if ((this.bitField0_ & 2097152) == 2097152) {
                codedOutputStream.A0(42, this.lengthA_);
            }
            if ((this.bitField0_ & 4194304) == 4194304) {
                codedOutputStream.A0(43, this.lengthB_);
            }
            if ((this.bitField0_ & 8388608) == 8388608) {
                codedOutputStream.A0(44, this.ratio_);
            }
            if ((this.bitField0_ & 16777216) == 16777216) {
                codedOutputStream.K0(50, this.target_);
            }
            if ((this.bitField0_ & 33554432) == 33554432) {
                codedOutputStream.A0(51, this.maxForce_);
            }
            if ((this.bitField0_ & 67108864) == 67108864) {
                codedOutputStream.G0(61, this.joint1_);
            }
            if ((this.bitField0_ & 134217728) == 134217728) {
                codedOutputStream.G0(62, this.joint2_);
            }
            if ((this.bitField0_ & 268435456) == 268435456) {
                codedOutputStream.A0(90, this.maxTorque_);
            }
            if ((this.bitField0_ & 536870912) == 536870912) {
                codedOutputStream.A0(100, this.maxLength_);
            }
            for (int i3 = 0; i3 < this.bodies_.size(); i3++) {
                codedOutputStream.G0(110, this.bodies_.get(i3).intValue());
            }
            for (int i16 = 0; i16 < this.joints_.size(); i16++) {
                codedOutputStream.G0(111, this.joints_.get(i16).intValue());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        PbJoint(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Builder newBuilder(PbJoint pbJoint) {
            return newBuilder().mergeFrom(pbJoint);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbJoint parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbJoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.av, com.google.protobuf.ax
        public PbJoint getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static PbJoint parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream, tVar)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbJoint parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr, tVar)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder newBuilderForType() {
            return newBuilder();
        }

        PbJoint(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbJoint parseFrom(InputStream inputStream) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.g gVar) {
            return new Builder(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbJoint parseFrom(InputStream inputStream, t tVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbJoint parseFrom(k kVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(kVar)).buildParsed();
        }

        public static PbJoint parseFrom(k kVar, t tVar) throws IOException {
            return newBuilder().mergeFrom(kVar, tVar).buildParsed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface PbJointOrBuilder extends ax {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.ax
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        int getBodies(int i3);

        int getBodiesCount();

        List<Integer> getBodiesList();

        int getBodyA();

        int getBodyB();

        boolean getCollideConnected();

        float getDampingRatio();

        @Override // com.google.protobuf.ax
        /* synthetic */ ar getDefaultInstanceForType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Descriptors.b getDescriptorForType();

        boolean getEnableLimit();

        boolean getEnableMotor();

        @Override // com.google.protobuf.ax
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        float getFrequency();

        PbVec2 getGroundAnchorA();

        PbVec2OrBuilder getGroundAnchorAOrBuilder();

        PbVec2 getGroundAnchorB();

        PbVec2OrBuilder getGroundAnchorBOrBuilder();

        /* synthetic */ String getInitializationErrorString();

        int getJoint1();

        int getJoint2();

        int getJoints(int i3);

        int getJointsCount();

        List<Integer> getJointsList();

        float getLength();

        float getLengthA();

        float getLengthB();

        PbVec2 getLocalAnchorA();

        PbVec2OrBuilder getLocalAnchorAOrBuilder();

        PbVec2 getLocalAnchorB();

        PbVec2OrBuilder getLocalAnchorBOrBuilder();

        PbVec2 getLocalAxisA();

        PbVec2OrBuilder getLocalAxisAOrBuilder();

        float getLowerLimit();

        float getMaxForce();

        float getMaxLength();

        float getMaxMotorForce();

        float getMaxMotorTorque();

        float getMaxTorque();

        float getMotorSpeed();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar);

        float getRatio();

        float getRefAngle();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        long getTag();

        PbVec2 getTarget();

        PbVec2OrBuilder getTargetOrBuilder();

        PbJointType getType();

        @Override // com.google.protobuf.ax
        /* synthetic */ cc getUnknownFields();

        float getUpperLimit();

        boolean hasBodyA();

        boolean hasBodyB();

        boolean hasCollideConnected();

        boolean hasDampingRatio();

        boolean hasEnableLimit();

        boolean hasEnableMotor();

        @Override // com.google.protobuf.ax
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasFrequency();

        boolean hasGroundAnchorA();

        boolean hasGroundAnchorB();

        boolean hasJoint1();

        boolean hasJoint2();

        boolean hasLength();

        boolean hasLengthA();

        boolean hasLengthB();

        boolean hasLocalAnchorA();

        boolean hasLocalAnchorB();

        boolean hasLocalAxisA();

        boolean hasLowerLimit();

        boolean hasMaxForce();

        boolean hasMaxLength();

        boolean hasMaxMotorForce();

        boolean hasMaxMotorTorque();

        boolean hasMaxTorque();

        boolean hasMotorSpeed();

        /* synthetic */ boolean hasOneof(Descriptors.g gVar);

        boolean hasRatio();

        boolean hasRefAngle();

        boolean hasTag();

        boolean hasTarget();

        boolean hasType();

        boolean hasUpperLimit();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum PbJointType implements bk {
        DISTANCE(0, 1),
        REVOLUTE(1, 2),
        PRISMATIC(2, 3),
        PULLEY(3, 4),
        MOUSE(4, 5),
        GEAR(5, 6),
        WHEEL(6, 7),
        WELD(7, 8),
        FRICTION(8, 9),
        ROPE(9, 10),
        CONSTANT_VOLUME(10, 11),
        LINE(11, 12);

        public static final int CONSTANT_VOLUME_VALUE = 11;
        public static final int DISTANCE_VALUE = 1;
        public static final int FRICTION_VALUE = 9;
        public static final int GEAR_VALUE = 6;
        public static final int LINE_VALUE = 12;
        public static final int MOUSE_VALUE = 5;
        public static final int PRISMATIC_VALUE = 3;
        public static final int PULLEY_VALUE = 4;
        public static final int REVOLUTE_VALUE = 2;
        public static final int ROPE_VALUE = 10;
        private static final PbJointType[] VALUES;
        public static final int WELD_VALUE = 8;
        public static final int WHEEL_VALUE = 7;
        private static ad.d<PbJointType> internalValueMap;
        private final int index;
        private final int value;

        static {
            PbJointType pbJointType = DISTANCE;
            PbJointType pbJointType2 = REVOLUTE;
            PbJointType pbJointType3 = PRISMATIC;
            PbJointType pbJointType4 = PULLEY;
            PbJointType pbJointType5 = MOUSE;
            PbJointType pbJointType6 = GEAR;
            PbJointType pbJointType7 = WHEEL;
            PbJointType pbJointType8 = WELD;
            PbJointType pbJointType9 = FRICTION;
            PbJointType pbJointType10 = ROPE;
            PbJointType pbJointType11 = CONSTANT_VOLUME;
            PbJointType pbJointType12 = LINE;
            internalValueMap = new ad.d<PbJointType>() { // from class: org.box2d.proto.Box2D.PbJointType.1
                @Override // com.google.protobuf.ad.d
                public PbJointType findValueByNumber(int i3) {
                    return PbJointType.valueOf(i3);
                }
            };
            VALUES = new PbJointType[]{pbJointType, pbJointType2, pbJointType3, pbJointType4, pbJointType5, pbJointType6, pbJointType7, pbJointType8, pbJointType9, pbJointType10, pbJointType11, pbJointType12};
        }

        PbJointType(int i3, int i16) {
            this.index = i3;
            this.value = i16;
        }

        public static final Descriptors.c getDescriptor() {
            return Box2D.getDescriptor().o().get(2);
        }

        public static ad.d<PbJointType> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.c getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        public final Descriptors.d getValueDescriptor() {
            return getDescriptor().o().get(this.index);
        }

        public static PbJointType valueOf(int i3) {
            switch (i3) {
                case 1:
                    return DISTANCE;
                case 2:
                    return REVOLUTE;
                case 3:
                    return PRISMATIC;
                case 4:
                    return PULLEY;
                case 5:
                    return MOUSE;
                case 6:
                    return GEAR;
                case 7:
                    return WHEEL;
                case 8:
                    return WELD;
                case 9:
                    return FRICTION;
                case 10:
                    return ROPE;
                case 11:
                    return CONSTANT_VOLUME;
                case 12:
                    return LINE;
                default:
                    return null;
            }
        }

        public static PbJointType valueOf(Descriptors.d dVar) {
            if (dVar.m() == getDescriptor()) {
                return VALUES[dVar.l()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PbShape extends GeneratedMessage implements PbShapeOrBuilder {
        public static final int CENTER_FIELD_NUMBER = 10;
        public static final int CENTROID_FIELD_NUMBER = 22;
        public static final int HAS0_FIELD_NUMBER = 34;
        public static final int HAS3_FIELD_NUMBER = 35;
        public static final int NEXT_FIELD_NUMBER = 41;
        public static final int NORMALS_FIELD_NUMBER = 21;
        public static final int POINTS_FIELD_NUMBER = 20;
        public static final int PREV_FIELD_NUMBER = 40;
        public static final int RADIUS_FIELD_NUMBER = 11;
        public static final int TAG_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        public static final int V0_FIELD_NUMBER = 30;
        public static final int V1_FIELD_NUMBER = 31;
        public static final int V2_FIELD_NUMBER = 32;
        public static final int V3_FIELD_NUMBER = 33;
        private static final PbShape defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private PbVec2 center_;
        private PbVec2 centroid_;
        private boolean has0_;
        private boolean has3_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private PbVec2 next_;
        private List<PbVec2> normals_;
        private List<PbVec2> points_;
        private PbVec2 prev_;
        private float radius_;
        private long tag_;
        private PbShapeType type_;
        private PbVec2 v0_;
        private PbVec2 v1_;
        private PbVec2 v2_;
        private PbVec2 v3_;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Builder extends GeneratedMessage.f<Builder> implements PbShapeOrBuilder {
            private int bitField0_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> centerBuilder_;
            private PbVec2 center_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> centroidBuilder_;
            private PbVec2 centroid_;
            private boolean has0_;
            private boolean has3_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> nextBuilder_;
            private PbVec2 next_;
            private bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> normalsBuilder_;
            private List<PbVec2> normals_;
            private bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> pointsBuilder_;
            private List<PbVec2> points_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> prevBuilder_;
            private PbVec2 prev_;
            private float radius_;
            private long tag_;
            private PbShapeType type_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> v0Builder_;
            private PbVec2 v0_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> v1Builder_;
            private PbVec2 v1_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> v2Builder_;
            private PbVec2 v2_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> v3Builder_;
            private PbVec2 v3_;

            static /* synthetic */ Builder access$2400() {
                return create();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PbShape buildParsed() throws InvalidProtocolBufferException {
                PbShape buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial).asInvalidProtocolBufferException();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureNormalsIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.normals_ = new ArrayList(this.normals_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensurePointsIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.points_ = new ArrayList(this.points_);
                    this.bitField0_ |= 16;
                }
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getCenterFieldBuilder() {
                if (this.centerBuilder_ == null) {
                    this.centerBuilder_ = new bt<>(this.center_, getParentForChildren(), isClean());
                    this.center_ = null;
                }
                return this.centerBuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getCentroidFieldBuilder() {
                if (this.centroidBuilder_ == null) {
                    this.centroidBuilder_ = new bt<>(this.centroid_, getParentForChildren(), isClean());
                    this.centroid_ = null;
                }
                return this.centroidBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return Box2D.internal_static_box2d_PbShape_descriptor;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getNextFieldBuilder() {
                if (this.nextBuilder_ == null) {
                    this.nextBuilder_ = new bt<>(this.next_, getParentForChildren(), isClean());
                    this.next_ = null;
                }
                return this.nextBuilder_;
            }

            private bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getNormalsFieldBuilder() {
                boolean z16;
                if (this.normalsBuilder_ == null) {
                    List<PbVec2> list = this.normals_;
                    if ((this.bitField0_ & 32) == 32) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.normalsBuilder_ = new bo<>(list, z16, getParentForChildren(), isClean());
                    this.normals_ = null;
                }
                return this.normalsBuilder_;
            }

            private bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getPointsFieldBuilder() {
                boolean z16;
                if (this.pointsBuilder_ == null) {
                    List<PbVec2> list = this.points_;
                    if ((this.bitField0_ & 16) == 16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.pointsBuilder_ = new bo<>(list, z16, getParentForChildren(), isClean());
                    this.points_ = null;
                }
                return this.pointsBuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getPrevFieldBuilder() {
                if (this.prevBuilder_ == null) {
                    this.prevBuilder_ = new bt<>(this.prev_, getParentForChildren(), isClean());
                    this.prev_ = null;
                }
                return this.prevBuilder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getV0FieldBuilder() {
                if (this.v0Builder_ == null) {
                    this.v0Builder_ = new bt<>(this.v0_, getParentForChildren(), isClean());
                    this.v0_ = null;
                }
                return this.v0Builder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getV1FieldBuilder() {
                if (this.v1Builder_ == null) {
                    this.v1Builder_ = new bt<>(this.v1_, getParentForChildren(), isClean());
                    this.v1_ = null;
                }
                return this.v1Builder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getV2FieldBuilder() {
                if (this.v2Builder_ == null) {
                    this.v2Builder_ = new bt<>(this.v2_, getParentForChildren(), isClean());
                    this.v2_ = null;
                }
                return this.v2Builder_;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getV3FieldBuilder() {
                if (this.v3Builder_ == null) {
                    this.v3Builder_ = new bt<>(this.v3_, getParentForChildren(), isClean());
                    this.v3_ = null;
                }
                return this.v3Builder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getCenterFieldBuilder();
                    getPointsFieldBuilder();
                    getNormalsFieldBuilder();
                    getCentroidFieldBuilder();
                    getV0FieldBuilder();
                    getV1FieldBuilder();
                    getV2FieldBuilder();
                    getV3FieldBuilder();
                    getPrevFieldBuilder();
                    getNextFieldBuilder();
                }
            }

            public Builder addAllNormals(Iterable<? extends PbVec2> iterable) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    ensureNormalsIsMutable();
                    b.a.addAll((Iterable) iterable, (Collection) this.normals_);
                    onChanged();
                } else {
                    boVar.b(iterable);
                }
                return this;
            }

            public Builder addAllPoints(Iterable<? extends PbVec2> iterable) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    ensurePointsIsMutable();
                    b.a.addAll((Iterable) iterable, (Collection) this.points_);
                    onChanged();
                } else {
                    boVar.b(iterable);
                }
                return this;
            }

            public Builder addNormals(PbVec2 pbVec2) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    pbVec2.getClass();
                    ensureNormalsIsMutable();
                    this.normals_.add(pbVec2);
                    onChanged();
                } else {
                    boVar.f(pbVec2);
                }
                return this;
            }

            public PbVec2.Builder addNormalsBuilder() {
                return getNormalsFieldBuilder().d(PbVec2.getDefaultInstance());
            }

            public Builder addPoints(PbVec2 pbVec2) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    pbVec2.getClass();
                    ensurePointsIsMutable();
                    this.points_.add(pbVec2);
                    onChanged();
                } else {
                    boVar.f(pbVec2);
                }
                return this;
            }

            public PbVec2.Builder addPointsBuilder() {
                return getPointsFieldBuilder().d(PbVec2.getDefaultInstance());
            }

            public Builder clearCenter() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centerBuilder_;
                if (btVar == null) {
                    this.center_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearCentroid() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centroidBuilder_;
                if (btVar == null) {
                    this.centroid_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearHas0() {
                this.bitField0_ &= MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                this.has0_ = false;
                onChanged();
                return this;
            }

            public Builder clearHas3() {
                this.bitField0_ &= -4097;
                this.has3_ = false;
                onChanged();
                return this;
            }

            public Builder clearNext() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.nextBuilder_;
                if (btVar == null) {
                    this.next_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -16385;
                return this;
            }

            public Builder clearNormals() {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    this.normals_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    boVar.h();
                }
                return this;
            }

            public Builder clearPoints() {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    this.points_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    boVar.h();
                }
                return this;
            }

            public Builder clearPrev() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.prevBuilder_;
                if (btVar == null) {
                    this.prev_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -8193;
                return this;
            }

            public Builder clearRadius() {
                this.bitField0_ &= -9;
                this.radius_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearTag() {
                this.bitField0_ &= -2;
                this.tag_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -3;
                this.type_ = PbShapeType.CIRCLE;
                onChanged();
                return this;
            }

            public Builder clearV0() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v0Builder_;
                if (btVar == null) {
                    this.v0_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -129;
                return this;
            }

            public Builder clearV1() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v1Builder_;
                if (btVar == null) {
                    this.v1_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -257;
                return this;
            }

            public Builder clearV2() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v2Builder_;
                if (btVar == null) {
                    this.v2_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -513;
                return this;
            }

            public Builder clearV3() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v3Builder_;
                if (btVar == null) {
                    this.v3_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -1025;
                return this;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getCenter() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centerBuilder_;
                if (btVar == null) {
                    return this.center_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getCenterBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return getCenterFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getCenterOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centerBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.center_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getCentroid() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centroidBuilder_;
                if (btVar == null) {
                    return this.centroid_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getCentroidBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return getCentroidFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getCentroidOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centroidBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.centroid_;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return PbShape.getDescriptor();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean getHas0() {
                return this.has0_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean getHas3() {
                return this.has3_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getNext() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.nextBuilder_;
                if (btVar == null) {
                    return this.next_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getNextBuilder() {
                this.bitField0_ |= 16384;
                onChanged();
                return getNextFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getNextOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.nextBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.next_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getNormals(int i3) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    return this.normals_.get(i3);
                }
                return boVar.o(i3);
            }

            public PbVec2.Builder getNormalsBuilder(int i3) {
                return getNormalsFieldBuilder().l(i3);
            }

            public List<PbVec2.Builder> getNormalsBuilderList() {
                return getNormalsFieldBuilder().m();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public int getNormalsCount() {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    return this.normals_.size();
                }
                return boVar.n();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public List<PbVec2> getNormalsList() {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    return Collections.unmodifiableList(this.normals_);
                }
                return boVar.q();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getNormalsOrBuilder(int i3) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    return this.normals_.get(i3);
                }
                return boVar.r(i3);
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public List<? extends PbVec2OrBuilder> getNormalsOrBuilderList() {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar != null) {
                    return boVar.s();
                }
                return Collections.unmodifiableList(this.normals_);
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getPoints(int i3) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    return this.points_.get(i3);
                }
                return boVar.o(i3);
            }

            public PbVec2.Builder getPointsBuilder(int i3) {
                return getPointsFieldBuilder().l(i3);
            }

            public List<PbVec2.Builder> getPointsBuilderList() {
                return getPointsFieldBuilder().m();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public int getPointsCount() {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    return this.points_.size();
                }
                return boVar.n();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public List<PbVec2> getPointsList() {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    return Collections.unmodifiableList(this.points_);
                }
                return boVar.q();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getPointsOrBuilder(int i3) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    return this.points_.get(i3);
                }
                return boVar.r(i3);
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public List<? extends PbVec2OrBuilder> getPointsOrBuilderList() {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar != null) {
                    return boVar.s();
                }
                return Collections.unmodifiableList(this.points_);
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getPrev() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.prevBuilder_;
                if (btVar == null) {
                    return this.prev_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getPrevBuilder() {
                this.bitField0_ |= 8192;
                onChanged();
                return getPrevFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getPrevOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.prevBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.prev_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public float getRadius() {
                return this.radius_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public long getTag() {
                return this.tag_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbShapeType getType() {
                return this.type_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getV0() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v0Builder_;
                if (btVar == null) {
                    return this.v0_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getV0Builder() {
                this.bitField0_ |= 128;
                onChanged();
                return getV0FieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getV0OrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v0Builder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.v0_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getV1() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v1Builder_;
                if (btVar == null) {
                    return this.v1_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getV1Builder() {
                this.bitField0_ |= 256;
                onChanged();
                return getV1FieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getV1OrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v1Builder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.v1_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getV2() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v2Builder_;
                if (btVar == null) {
                    return this.v2_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getV2Builder() {
                this.bitField0_ |= 512;
                onChanged();
                return getV2FieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getV2OrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v2Builder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.v2_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2 getV3() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v3Builder_;
                if (btVar == null) {
                    return this.v3_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getV3Builder() {
                this.bitField0_ |= 1024;
                onChanged();
                return getV3FieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public PbVec2OrBuilder getV3OrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v3Builder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.v3_;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasCenter() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasCentroid() {
                if ((this.bitField0_ & 64) == 64) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasHas0() {
                if ((this.bitField0_ & 2048) == 2048) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasHas3() {
                if ((this.bitField0_ & 4096) == 4096) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasNext() {
                if ((this.bitField0_ & 16384) == 16384) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasPrev() {
                if ((this.bitField0_ & 8192) == 8192) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasRadius() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasTag() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasType() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasV0() {
                if ((this.bitField0_ & 128) == 128) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasV1() {
                if ((this.bitField0_ & 256) == 256) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasV2() {
                if ((this.bitField0_ & 512) == 512) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
            public boolean hasV3() {
                if ((this.bitField0_ & 1024) == 1024) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.f
            protected GeneratedMessage.j internalGetFieldAccessorTable() {
                return Box2D.internal_static_box2d_PbShape_fieldAccessorTable;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.av
            public final boolean isInitialized() {
                if (!hasType()) {
                    return false;
                }
                if (hasCenter() && !getCenter().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getPointsCount(); i3++) {
                    if (!getPoints(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i16 = 0; i16 < getNormalsCount(); i16++) {
                    if (!getNormals(i16).isInitialized()) {
                        return false;
                    }
                }
                if (hasCentroid() && !getCentroid().isInitialized()) {
                    return false;
                }
                if (hasV0() && !getV0().isInitialized()) {
                    return false;
                }
                if (hasV1() && !getV1().isInitialized()) {
                    return false;
                }
                if (hasV2() && !getV2().isInitialized()) {
                    return false;
                }
                if (hasV3() && !getV3().isInitialized()) {
                    return false;
                }
                if (hasPrev() && !getPrev().isInitialized()) {
                    return false;
                }
                if (hasNext() && !getNext().isInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeCenter(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centerBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 4) == 4 && this.center_ != PbVec2.getDefaultInstance()) {
                        this.center_ = PbVec2.newBuilder(this.center_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.center_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeCentroid(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centroidBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 64) == 64 && this.centroid_ != PbVec2.getDefaultInstance()) {
                        this.centroid_ = PbVec2.newBuilder(this.centroid_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.centroid_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeNext(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.nextBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 16384) == 16384 && this.next_ != PbVec2.getDefaultInstance()) {
                        this.next_ = PbVec2.newBuilder(this.next_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.next_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 16384;
                return this;
            }

            public Builder mergePrev(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.prevBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 8192) == 8192 && this.prev_ != PbVec2.getDefaultInstance()) {
                        this.prev_ = PbVec2.newBuilder(this.prev_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.prev_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public Builder mergeV0(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v0Builder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 128) == 128 && this.v0_ != PbVec2.getDefaultInstance()) {
                        this.v0_ = PbVec2.newBuilder(this.v0_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.v0_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder mergeV1(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v1Builder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 256) == 256 && this.v1_ != PbVec2.getDefaultInstance()) {
                        this.v1_ = PbVec2.newBuilder(this.v1_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.v1_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder mergeV2(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v2Builder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 512) == 512 && this.v2_ != PbVec2.getDefaultInstance()) {
                        this.v2_ = PbVec2.newBuilder(this.v2_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.v2_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 512;
                return this;
            }

            public Builder mergeV3(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v3Builder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 1024) == 1024 && this.v3_ != PbVec2.getDefaultInstance()) {
                        this.v3_ = PbVec2.newBuilder(this.v3_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.v3_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 1024;
                return this;
            }

            public Builder removeNormals(int i3) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    ensureNormalsIsMutable();
                    this.normals_.remove(i3);
                    onChanged();
                } else {
                    boVar.w(i3);
                }
                return this;
            }

            public Builder removePoints(int i3) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    ensurePointsIsMutable();
                    this.points_.remove(i3);
                    onChanged();
                } else {
                    boVar.w(i3);
                }
                return this;
            }

            public Builder setCenter(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centerBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.center_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setCentroid(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centroidBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.centroid_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setHas0(boolean z16) {
                this.bitField0_ |= 2048;
                this.has0_ = z16;
                onChanged();
                return this;
            }

            public Builder setHas3(boolean z16) {
                this.bitField0_ |= 4096;
                this.has3_ = z16;
                onChanged();
                return this;
            }

            public Builder setNext(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.nextBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.next_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 16384;
                return this;
            }

            public Builder setNormals(int i3, PbVec2 pbVec2) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    pbVec2.getClass();
                    ensureNormalsIsMutable();
                    this.normals_.set(i3, pbVec2);
                    onChanged();
                } else {
                    boVar.x(i3, pbVec2);
                }
                return this;
            }

            public Builder setPoints(int i3, PbVec2 pbVec2) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    pbVec2.getClass();
                    ensurePointsIsMutable();
                    this.points_.set(i3, pbVec2);
                    onChanged();
                } else {
                    boVar.x(i3, pbVec2);
                }
                return this;
            }

            public Builder setPrev(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.prevBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.prev_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public Builder setRadius(float f16) {
                this.bitField0_ |= 8;
                this.radius_ = f16;
                onChanged();
                return this;
            }

            public Builder setTag(long j3) {
                this.bitField0_ |= 1;
                this.tag_ = j3;
                onChanged();
                return this;
            }

            public Builder setType(PbShapeType pbShapeType) {
                pbShapeType.getClass();
                this.bitField0_ |= 2;
                this.type_ = pbShapeType;
                onChanged();
                return this;
            }

            public Builder setV0(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v0Builder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.v0_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder setV1(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v1Builder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.v1_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder setV2(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v2Builder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.v2_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 512;
                return this;
            }

            public Builder setV3(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v3Builder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.v3_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 1024;
                return this;
            }

            Builder() {
                this.type_ = PbShapeType.CIRCLE;
                this.center_ = PbVec2.getDefaultInstance();
                this.points_ = Collections.emptyList();
                this.normals_ = Collections.emptyList();
                this.centroid_ = PbVec2.getDefaultInstance();
                this.v0_ = PbVec2.getDefaultInstance();
                this.v1_ = PbVec2.getDefaultInstance();
                this.v2_ = PbVec2.getDefaultInstance();
                this.v3_ = PbVec2.getDefaultInstance();
                this.prev_ = PbVec2.getDefaultInstance();
                this.next_ = PbVec2.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public PbVec2.Builder addNormalsBuilder(int i3) {
                return getNormalsFieldBuilder().c(i3, PbVec2.getDefaultInstance());
            }

            public PbVec2.Builder addPointsBuilder(int i3) {
                return getPointsFieldBuilder().c(i3, PbVec2.getDefaultInstance());
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbShape build() {
                PbShape buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbShape buildPartial() {
                PbShape pbShape = new PbShape(this);
                int i3 = this.bitField0_;
                int i16 = (i3 & 1) != 1 ? 0 : 1;
                pbShape.tag_ = this.tag_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                pbShape.type_ = this.type_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centerBuilder_;
                if (btVar == null) {
                    pbShape.center_ = this.center_;
                } else {
                    pbShape.center_ = btVar.b();
                }
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                pbShape.radius_ = this.radius_;
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar != null) {
                    pbShape.points_ = boVar.g();
                } else {
                    if ((this.bitField0_ & 16) == 16) {
                        this.points_ = Collections.unmodifiableList(this.points_);
                        this.bitField0_ &= -17;
                    }
                    pbShape.points_ = this.points_;
                }
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar2 = this.normalsBuilder_;
                if (boVar2 != null) {
                    pbShape.normals_ = boVar2.g();
                } else {
                    if ((this.bitField0_ & 32) == 32) {
                        this.normals_ = Collections.unmodifiableList(this.normals_);
                        this.bitField0_ &= -33;
                    }
                    pbShape.normals_ = this.normals_;
                }
                if ((i3 & 64) == 64) {
                    i16 |= 16;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar2 = this.centroidBuilder_;
                if (btVar2 == null) {
                    pbShape.centroid_ = this.centroid_;
                } else {
                    pbShape.centroid_ = btVar2.b();
                }
                if ((i3 & 128) == 128) {
                    i16 |= 32;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar3 = this.v0Builder_;
                if (btVar3 == null) {
                    pbShape.v0_ = this.v0_;
                } else {
                    pbShape.v0_ = btVar3.b();
                }
                if ((i3 & 256) == 256) {
                    i16 |= 64;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar4 = this.v1Builder_;
                if (btVar4 == null) {
                    pbShape.v1_ = this.v1_;
                } else {
                    pbShape.v1_ = btVar4.b();
                }
                if ((i3 & 512) == 512) {
                    i16 |= 128;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar5 = this.v2Builder_;
                if (btVar5 == null) {
                    pbShape.v2_ = this.v2_;
                } else {
                    pbShape.v2_ = btVar5.b();
                }
                if ((i3 & 1024) == 1024) {
                    i16 |= 256;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar6 = this.v3Builder_;
                if (btVar6 == null) {
                    pbShape.v3_ = this.v3_;
                } else {
                    pbShape.v3_ = btVar6.b();
                }
                if ((i3 & 2048) == 2048) {
                    i16 |= 512;
                }
                pbShape.has0_ = this.has0_;
                if ((i3 & 4096) == 4096) {
                    i16 |= 1024;
                }
                pbShape.has3_ = this.has3_;
                if ((i3 & 8192) == 8192) {
                    i16 |= 2048;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar7 = this.prevBuilder_;
                if (btVar7 == null) {
                    pbShape.prev_ = this.prev_;
                } else {
                    pbShape.prev_ = btVar7.b();
                }
                if ((i3 & 16384) == 16384) {
                    i16 |= 4096;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar8 = this.nextBuilder_;
                if (btVar8 == null) {
                    pbShape.next_ = this.next_;
                } else {
                    pbShape.next_ = btVar8.b();
                }
                pbShape.bitField0_ = i16;
                onBuilt();
                return pbShape;
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            public PbShape getDefaultInstanceForType() {
                return PbShape.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a
            public Builder clear() {
                super.clear();
                this.tag_ = 0L;
                int i3 = this.bitField0_ & (-2);
                this.bitField0_ = i3;
                this.type_ = PbShapeType.CIRCLE;
                this.bitField0_ = i3 & (-3);
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centerBuilder_;
                if (btVar == null) {
                    this.center_ = PbVec2.getDefaultInstance();
                } else {
                    btVar.c();
                }
                int i16 = this.bitField0_ & (-5);
                this.radius_ = 0.0f;
                this.bitField0_ = i16 & (-9);
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    this.points_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    boVar.h();
                }
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar2 = this.normalsBuilder_;
                if (boVar2 == null) {
                    this.normals_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    boVar2.h();
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar2 = this.centroidBuilder_;
                if (btVar2 == null) {
                    this.centroid_ = PbVec2.getDefaultInstance();
                } else {
                    btVar2.c();
                }
                this.bitField0_ &= -65;
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar3 = this.v0Builder_;
                if (btVar3 == null) {
                    this.v0_ = PbVec2.getDefaultInstance();
                } else {
                    btVar3.c();
                }
                this.bitField0_ &= -129;
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar4 = this.v1Builder_;
                if (btVar4 == null) {
                    this.v1_ = PbVec2.getDefaultInstance();
                } else {
                    btVar4.c();
                }
                this.bitField0_ &= -257;
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar5 = this.v2Builder_;
                if (btVar5 == null) {
                    this.v2_ = PbVec2.getDefaultInstance();
                } else {
                    btVar5.c();
                }
                this.bitField0_ &= -513;
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar6 = this.v3Builder_;
                if (btVar6 == null) {
                    this.v3_ = PbVec2.getDefaultInstance();
                } else {
                    btVar6.c();
                }
                int i17 = this.bitField0_ & (-1025);
                this.has0_ = false;
                int i18 = i17 & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                this.has3_ = false;
                this.bitField0_ = i18 & (-4097);
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar7 = this.prevBuilder_;
                if (btVar7 == null) {
                    this.prev_ = PbVec2.getDefaultInstance();
                } else {
                    btVar7.c();
                }
                this.bitField0_ &= -8193;
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar8 = this.nextBuilder_;
                if (btVar8 == null) {
                    this.next_ = PbVec2.getDefaultInstance();
                } else {
                    btVar8.c();
                }
                this.bitField0_ &= -16385;
                return this;
            }

            public Builder addNormals(int i3, PbVec2 pbVec2) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    pbVec2.getClass();
                    ensureNormalsIsMutable();
                    this.normals_.add(i3, pbVec2);
                    onChanged();
                } else {
                    boVar.e(i3, pbVec2);
                }
                return this;
            }

            public Builder addPoints(int i3, PbVec2 pbVec2) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    pbVec2.getClass();
                    ensurePointsIsMutable();
                    this.points_.add(i3, pbVec2);
                    onChanged();
                } else {
                    boVar.e(i3, pbVec2);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
            /* renamed from: clone */
            public Builder mo50clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            public Builder mergeFrom(ar arVar) {
                if (arVar instanceof PbShape) {
                    return mergeFrom((PbShape) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public Builder setCenter(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centerBuilder_;
                if (btVar == null) {
                    this.center_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setCentroid(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.centroidBuilder_;
                if (btVar == null) {
                    this.centroid_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setNext(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.nextBuilder_;
                if (btVar == null) {
                    this.next_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 16384;
                return this;
            }

            public Builder setNormals(int i3, PbVec2.Builder builder) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    ensureNormalsIsMutable();
                    this.normals_.set(i3, builder.build());
                    onChanged();
                } else {
                    boVar.x(i3, builder.build());
                }
                return this;
            }

            public Builder setPoints(int i3, PbVec2.Builder builder) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    ensurePointsIsMutable();
                    this.points_.set(i3, builder.build());
                    onChanged();
                } else {
                    boVar.x(i3, builder.build());
                }
                return this;
            }

            public Builder setPrev(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.prevBuilder_;
                if (btVar == null) {
                    this.prev_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public Builder setV0(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v0Builder_;
                if (btVar == null) {
                    this.v0_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder setV1(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v1Builder_;
                if (btVar == null) {
                    this.v1_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder setV2(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v2Builder_;
                if (btVar == null) {
                    this.v2_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 512;
                return this;
            }

            public Builder setV3(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.v3Builder_;
                if (btVar == null) {
                    this.v3_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 1024;
                return this;
            }

            public Builder mergeFrom(PbShape pbShape) {
                if (pbShape == PbShape.getDefaultInstance()) {
                    return this;
                }
                if (pbShape.hasTag()) {
                    setTag(pbShape.getTag());
                }
                if (pbShape.hasType()) {
                    setType(pbShape.getType());
                }
                if (pbShape.hasCenter()) {
                    mergeCenter(pbShape.getCenter());
                }
                if (pbShape.hasRadius()) {
                    setRadius(pbShape.getRadius());
                }
                if (this.pointsBuilder_ == null) {
                    if (!pbShape.points_.isEmpty()) {
                        if (this.points_.isEmpty()) {
                            this.points_ = pbShape.points_;
                            this.bitField0_ &= -17;
                        } else {
                            ensurePointsIsMutable();
                            this.points_.addAll(pbShape.points_);
                        }
                        onChanged();
                    }
                } else if (!pbShape.points_.isEmpty()) {
                    if (!this.pointsBuilder_.u()) {
                        this.pointsBuilder_.b(pbShape.points_);
                    } else {
                        this.pointsBuilder_.i();
                        this.pointsBuilder_ = null;
                        this.points_ = pbShape.points_;
                        this.bitField0_ &= -17;
                        this.pointsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getPointsFieldBuilder() : null;
                    }
                }
                if (this.normalsBuilder_ == null) {
                    if (!pbShape.normals_.isEmpty()) {
                        if (this.normals_.isEmpty()) {
                            this.normals_ = pbShape.normals_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureNormalsIsMutable();
                            this.normals_.addAll(pbShape.normals_);
                        }
                        onChanged();
                    }
                } else if (!pbShape.normals_.isEmpty()) {
                    if (!this.normalsBuilder_.u()) {
                        this.normalsBuilder_.b(pbShape.normals_);
                    } else {
                        this.normalsBuilder_.i();
                        this.normalsBuilder_ = null;
                        this.normals_ = pbShape.normals_;
                        this.bitField0_ &= -33;
                        this.normalsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getNormalsFieldBuilder() : null;
                    }
                }
                if (pbShape.hasCentroid()) {
                    mergeCentroid(pbShape.getCentroid());
                }
                if (pbShape.hasV0()) {
                    mergeV0(pbShape.getV0());
                }
                if (pbShape.hasV1()) {
                    mergeV1(pbShape.getV1());
                }
                if (pbShape.hasV2()) {
                    mergeV2(pbShape.getV2());
                }
                if (pbShape.hasV3()) {
                    mergeV3(pbShape.getV3());
                }
                if (pbShape.hasHas0()) {
                    setHas0(pbShape.getHas0());
                }
                if (pbShape.hasHas3()) {
                    setHas3(pbShape.getHas3());
                }
                if (pbShape.hasPrev()) {
                    mergePrev(pbShape.getPrev());
                }
                if (pbShape.hasNext()) {
                    mergeNext(pbShape.getNext());
                }
                mo52mergeUnknownFields(pbShape.getUnknownFields());
                return this;
            }

            public Builder addNormals(PbVec2.Builder builder) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    ensureNormalsIsMutable();
                    this.normals_.add(builder.build());
                    onChanged();
                } else {
                    boVar.f(builder.build());
                }
                return this;
            }

            public Builder addPoints(PbVec2.Builder builder) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    ensurePointsIsMutable();
                    this.points_.add(builder.build());
                    onChanged();
                } else {
                    boVar.f(builder.build());
                }
                return this;
            }

            Builder(GeneratedMessage.g gVar) {
                super(gVar);
                this.type_ = PbShapeType.CIRCLE;
                this.center_ = PbVec2.getDefaultInstance();
                this.points_ = Collections.emptyList();
                this.normals_ = Collections.emptyList();
                this.centroid_ = PbVec2.getDefaultInstance();
                this.v0_ = PbVec2.getDefaultInstance();
                this.v1_ = PbVec2.getDefaultInstance();
                this.v2_ = PbVec2.getDefaultInstance();
                this.v3_ = PbVec2.getDefaultInstance();
                this.prev_ = PbVec2.getDefaultInstance();
                this.next_ = PbVec2.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public Builder addNormals(int i3, PbVec2.Builder builder) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.normalsBuilder_;
                if (boVar == null) {
                    ensureNormalsIsMutable();
                    this.normals_.add(i3, builder.build());
                    onChanged();
                } else {
                    boVar.e(i3, builder.build());
                }
                return this;
            }

            public Builder addPoints(int i3, PbVec2.Builder builder) {
                bo<PbVec2, PbVec2.Builder, PbVec2OrBuilder> boVar = this.pointsBuilder_;
                if (boVar == null) {
                    ensurePointsIsMutable();
                    this.points_.add(i3, builder.build());
                    onChanged();
                } else {
                    boVar.e(i3, builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            public Builder mergeFrom(k kVar, t tVar) throws IOException {
                cc.b h16 = cc.h(getUnknownFields());
                while (true) {
                    int J = kVar.J();
                    switch (J) {
                        case 0:
                            setUnknownFields(h16.build());
                            onChanged();
                            return this;
                        case 8:
                            this.bitField0_ |= 1;
                            this.tag_ = kVar.y();
                            break;
                        case 16:
                            int s16 = kVar.s();
                            PbShapeType valueOf = PbShapeType.valueOf(s16);
                            if (valueOf == null) {
                                h16.r(2, s16);
                                break;
                            } else {
                                this.bitField0_ |= 2;
                                this.type_ = valueOf;
                                break;
                            }
                        case 82:
                            PbVec2.Builder newBuilder = PbVec2.newBuilder();
                            if (hasCenter()) {
                                newBuilder.mergeFrom(getCenter());
                            }
                            kVar.A(newBuilder, tVar);
                            setCenter(newBuilder.buildPartial());
                            break;
                        case 93:
                            this.bitField0_ |= 8;
                            this.radius_ = kVar.v();
                            break;
                        case 162:
                            PbVec2.Builder newBuilder2 = PbVec2.newBuilder();
                            kVar.A(newBuilder2, tVar);
                            addPoints(newBuilder2.buildPartial());
                            break;
                        case 170:
                            PbVec2.Builder newBuilder3 = PbVec2.newBuilder();
                            kVar.A(newBuilder3, tVar);
                            addNormals(newBuilder3.buildPartial());
                            break;
                        case 178:
                            PbVec2.Builder newBuilder4 = PbVec2.newBuilder();
                            if (hasCentroid()) {
                                newBuilder4.mergeFrom(getCentroid());
                            }
                            kVar.A(newBuilder4, tVar);
                            setCentroid(newBuilder4.buildPartial());
                            break;
                        case 242:
                            PbVec2.Builder newBuilder5 = PbVec2.newBuilder();
                            if (hasV0()) {
                                newBuilder5.mergeFrom(getV0());
                            }
                            kVar.A(newBuilder5, tVar);
                            setV0(newBuilder5.buildPartial());
                            break;
                        case 250:
                            PbVec2.Builder newBuilder6 = PbVec2.newBuilder();
                            if (hasV1()) {
                                newBuilder6.mergeFrom(getV1());
                            }
                            kVar.A(newBuilder6, tVar);
                            setV1(newBuilder6.buildPartial());
                            break;
                        case 258:
                            PbVec2.Builder newBuilder7 = PbVec2.newBuilder();
                            if (hasV2()) {
                                newBuilder7.mergeFrom(getV2());
                            }
                            kVar.A(newBuilder7, tVar);
                            setV2(newBuilder7.buildPartial());
                            break;
                        case 266:
                            PbVec2.Builder newBuilder8 = PbVec2.newBuilder();
                            if (hasV3()) {
                                newBuilder8.mergeFrom(getV3());
                            }
                            kVar.A(newBuilder8, tVar);
                            setV3(newBuilder8.buildPartial());
                            break;
                        case 272:
                            this.bitField0_ |= 2048;
                            this.has0_ = kVar.p();
                            break;
                        case FilterEnum.MIC_PTU_TRANS_XINXIAN /* 280 */:
                            this.bitField0_ |= 4096;
                            this.has3_ = kVar.p();
                            break;
                        case 322:
                            PbVec2.Builder newBuilder9 = PbVec2.newBuilder();
                            if (hasPrev()) {
                                newBuilder9.mergeFrom(getPrev());
                            }
                            kVar.A(newBuilder9, tVar);
                            setPrev(newBuilder9.buildPartial());
                            break;
                        case MapItemKt.ITEM_AVATAR_MIN_WIDTH /* 330 */:
                            PbVec2.Builder newBuilder10 = PbVec2.newBuilder();
                            if (hasNext()) {
                                newBuilder10.mergeFrom(getNext());
                            }
                            kVar.A(newBuilder10, tVar);
                            setNext(newBuilder10.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(kVar, h16, tVar, J)) {
                                setUnknownFields(h16.build());
                                onChanged();
                                return this;
                            }
                            break;
                    }
                }
            }
        }

        static {
            PbShape pbShape = new PbShape(true);
            defaultInstance = pbShape;
            pbShape.initFields();
        }

        public static PbShape getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.b getDescriptor() {
            return Box2D.internal_static_box2d_PbShape_descriptor;
        }

        private void initFields() {
            this.tag_ = 0L;
            this.type_ = PbShapeType.CIRCLE;
            this.center_ = PbVec2.getDefaultInstance();
            this.radius_ = 0.0f;
            this.points_ = Collections.emptyList();
            this.normals_ = Collections.emptyList();
            this.centroid_ = PbVec2.getDefaultInstance();
            this.v0_ = PbVec2.getDefaultInstance();
            this.v1_ = PbVec2.getDefaultInstance();
            this.v2_ = PbVec2.getDefaultInstance();
            this.v3_ = PbVec2.getDefaultInstance();
            this.has0_ = false;
            this.has3_ = false;
            this.prev_ = PbVec2.getDefaultInstance();
            this.next_ = PbVec2.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$2400();
        }

        public static PbShape parseDelimitedFrom(InputStream inputStream) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbShape parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString)).buildParsed();
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getCenter() {
            return this.center_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getCenterOrBuilder() {
            return this.center_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getCentroid() {
            return this.centroid_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getCentroidOrBuilder() {
            return this.centroid_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean getHas0() {
            return this.has0_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean getHas3() {
            return this.has3_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getNext() {
            return this.next_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getNextOrBuilder() {
            return this.next_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getNormals(int i3) {
            return this.normals_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public int getNormalsCount() {
            return this.normals_.size();
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public List<PbVec2> getNormalsList() {
            return this.normals_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getNormalsOrBuilder(int i3) {
            return this.normals_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public List<? extends PbVec2OrBuilder> getNormalsOrBuilderList() {
            return this.normals_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getPoints(int i3) {
            return this.points_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public int getPointsCount() {
            return this.points_.size();
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public List<PbVec2> getPointsList() {
            return this.points_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getPointsOrBuilder(int i3) {
            return this.points_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public List<? extends PbVec2OrBuilder> getPointsOrBuilderList() {
            return this.points_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getPrev() {
            return this.prev_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getPrevOrBuilder() {
            return this.prev_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public float getRadius() {
            return this.radius_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.z(1, this.tag_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.l(2, this.type_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.G(10, this.center_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.r(11, this.radius_);
            }
            for (int i17 = 0; i17 < this.points_.size(); i17++) {
                i3 += CodedOutputStream.G(20, this.points_.get(i17));
            }
            for (int i18 = 0; i18 < this.normals_.size(); i18++) {
                i3 += CodedOutputStream.G(21, this.normals_.get(i18));
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.G(22, this.centroid_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.G(30, this.v0_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.G(31, this.v1_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i3 += CodedOutputStream.G(32, this.v2_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i3 += CodedOutputStream.G(33, this.v3_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i3 += CodedOutputStream.e(34, this.has0_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                i3 += CodedOutputStream.e(35, this.has3_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                i3 += CodedOutputStream.G(40, this.prev_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                i3 += CodedOutputStream.G(41, this.next_);
            }
            int serializedSize = i3 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public long getTag() {
            return this.tag_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbShapeType getType() {
            return this.type_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getV0() {
            return this.v0_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getV0OrBuilder() {
            return this.v0_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getV1() {
            return this.v1_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getV1OrBuilder() {
            return this.v1_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getV2() {
            return this.v2_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getV2OrBuilder() {
            return this.v2_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2 getV3() {
            return this.v3_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public PbVec2OrBuilder getV3OrBuilder() {
            return this.v3_;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasCenter() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasCentroid() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasHas0() {
            if ((this.bitField0_ & 512) == 512) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasHas3() {
            if ((this.bitField0_ & 1024) == 1024) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasNext() {
            if ((this.bitField0_ & 4096) == 4096) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasPrev() {
            if ((this.bitField0_ & 2048) == 2048) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasRadius() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasTag() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasV0() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasV1() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasV2() {
            if ((this.bitField0_ & 128) == 128) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbShapeOrBuilder
        public boolean hasV3() {
            if ((this.bitField0_ & 256) == 256) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.j internalGetFieldAccessorTable() {
            return Box2D.internal_static_box2d_PbShape_fieldAccessorTable;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 != -1) {
                if (b16 == 1) {
                    return true;
                }
                return false;
            }
            if (!hasType()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasCenter() && !getCenter().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getPointsCount(); i3++) {
                if (!getPoints(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getNormalsCount(); i16++) {
                if (!getNormals(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasCentroid() && !getCentroid().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasV0() && !getV0().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasV1() && !getV1().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasV2() && !getV2().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasV3() && !getV3().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasPrev() && !getPrev().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasNext() && !getNext().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.I0(1, this.tag_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.u0(2, this.type_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.K0(10, this.center_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.A0(11, this.radius_);
            }
            for (int i3 = 0; i3 < this.points_.size(); i3++) {
                codedOutputStream.K0(20, this.points_.get(i3));
            }
            for (int i16 = 0; i16 < this.normals_.size(); i16++) {
                codedOutputStream.K0(21, this.normals_.get(i16));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.K0(22, this.centroid_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.K0(30, this.v0_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.K0(31, this.v1_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.K0(32, this.v2_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.K0(33, this.v3_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.m0(34, this.has0_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.m0(35, this.has3_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.K0(40, this.prev_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.K0(41, this.next_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        PbShape(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Builder newBuilder(PbShape pbShape) {
            return newBuilder().mergeFrom(pbShape);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbShape parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbShape parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.av, com.google.protobuf.ax
        public PbShape getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static PbShape parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream, tVar)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbShape parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr, tVar)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder newBuilderForType() {
            return newBuilder();
        }

        PbShape(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbShape parseFrom(InputStream inputStream) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.g gVar) {
            return new Builder(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbShape parseFrom(InputStream inputStream, t tVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbShape parseFrom(k kVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(kVar)).buildParsed();
        }

        public static PbShape parseFrom(k kVar, t tVar) throws IOException {
            return newBuilder().mergeFrom(kVar, tVar).buildParsed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface PbShapeOrBuilder extends ax {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.ax
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        PbVec2 getCenter();

        PbVec2OrBuilder getCenterOrBuilder();

        PbVec2 getCentroid();

        PbVec2OrBuilder getCentroidOrBuilder();

        @Override // com.google.protobuf.ax
        /* synthetic */ ar getDefaultInstanceForType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean getHas0();

        boolean getHas3();

        /* synthetic */ String getInitializationErrorString();

        PbVec2 getNext();

        PbVec2OrBuilder getNextOrBuilder();

        PbVec2 getNormals(int i3);

        int getNormalsCount();

        List<PbVec2> getNormalsList();

        PbVec2OrBuilder getNormalsOrBuilder(int i3);

        List<? extends PbVec2OrBuilder> getNormalsOrBuilderList();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar);

        PbVec2 getPoints(int i3);

        int getPointsCount();

        List<PbVec2> getPointsList();

        PbVec2OrBuilder getPointsOrBuilder(int i3);

        List<? extends PbVec2OrBuilder> getPointsOrBuilderList();

        PbVec2 getPrev();

        PbVec2OrBuilder getPrevOrBuilder();

        float getRadius();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        long getTag();

        PbShapeType getType();

        @Override // com.google.protobuf.ax
        /* synthetic */ cc getUnknownFields();

        PbVec2 getV0();

        PbVec2OrBuilder getV0OrBuilder();

        PbVec2 getV1();

        PbVec2OrBuilder getV1OrBuilder();

        PbVec2 getV2();

        PbVec2OrBuilder getV2OrBuilder();

        PbVec2 getV3();

        PbVec2OrBuilder getV3OrBuilder();

        boolean hasCenter();

        boolean hasCentroid();

        @Override // com.google.protobuf.ax
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasHas0();

        boolean hasHas3();

        boolean hasNext();

        /* synthetic */ boolean hasOneof(Descriptors.g gVar);

        boolean hasPrev();

        boolean hasRadius();

        boolean hasTag();

        boolean hasType();

        boolean hasV0();

        boolean hasV1();

        boolean hasV2();

        boolean hasV3();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum PbShapeType implements bk {
        CIRCLE(0, 1),
        POLYGON(1, 2),
        EDGE(2, 3),
        CHAIN(3, 4);

        public static final int CHAIN_VALUE = 4;
        public static final int CIRCLE_VALUE = 1;
        public static final int EDGE_VALUE = 3;
        public static final int POLYGON_VALUE = 2;
        private static final PbShapeType[] VALUES;
        private static ad.d<PbShapeType> internalValueMap;
        private final int index;
        private final int value;

        static {
            PbShapeType pbShapeType = CIRCLE;
            PbShapeType pbShapeType2 = POLYGON;
            PbShapeType pbShapeType3 = EDGE;
            PbShapeType pbShapeType4 = CHAIN;
            internalValueMap = new ad.d<PbShapeType>() { // from class: org.box2d.proto.Box2D.PbShapeType.1
                @Override // com.google.protobuf.ad.d
                public PbShapeType findValueByNumber(int i3) {
                    return PbShapeType.valueOf(i3);
                }
            };
            VALUES = new PbShapeType[]{pbShapeType, pbShapeType2, pbShapeType3, pbShapeType4};
        }

        PbShapeType(int i3, int i16) {
            this.index = i3;
            this.value = i16;
        }

        public static final Descriptors.c getDescriptor() {
            return Box2D.getDescriptor().o().get(1);
        }

        public static ad.d<PbShapeType> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.c getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        public final Descriptors.d getValueDescriptor() {
            return getDescriptor().o().get(this.index);
        }

        public static PbShapeType valueOf(int i3) {
            if (i3 == 1) {
                return CIRCLE;
            }
            if (i3 == 2) {
                return POLYGON;
            }
            if (i3 == 3) {
                return EDGE;
            }
            if (i3 != 4) {
                return null;
            }
            return CHAIN;
        }

        public static PbShapeType valueOf(Descriptors.d dVar) {
            if (dVar.m() == getDescriptor()) {
                return VALUES[dVar.l()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PbVec2 extends GeneratedMessage implements PbVec2OrBuilder {
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private static final PbVec2 defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private float x_;
        private float y_;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Builder extends GeneratedMessage.f<Builder> implements PbVec2OrBuilder {
            private int bitField0_;
            private float x_;
            private float y_;

            static /* synthetic */ Builder access$300() {
                return create();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PbVec2 buildParsed() throws InvalidProtocolBufferException {
                PbVec2 buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial).asInvalidProtocolBufferException();
            }

            private static Builder create() {
                return new Builder();
            }

            public static final Descriptors.b getDescriptor() {
                return Box2D.internal_static_box2d_PbVec2_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessage.alwaysUseFieldBuilders;
            }

            public Builder clearX() {
                this.bitField0_ &= -2;
                this.x_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.bitField0_ &= -3;
                this.y_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return PbVec2.getDescriptor();
            }

            @Override // org.box2d.proto.Box2D.PbVec2OrBuilder
            public float getX() {
                return this.x_;
            }

            @Override // org.box2d.proto.Box2D.PbVec2OrBuilder
            public float getY() {
                return this.y_;
            }

            @Override // org.box2d.proto.Box2D.PbVec2OrBuilder
            public boolean hasX() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbVec2OrBuilder
            public boolean hasY() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.f
            protected GeneratedMessage.j internalGetFieldAccessorTable() {
                return Box2D.internal_static_box2d_PbVec2_fieldAccessorTable;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.av
            public final boolean isInitialized() {
                if (!hasX() || !hasY()) {
                    return false;
                }
                return true;
            }

            public Builder setX(float f16) {
                this.bitField0_ |= 1;
                this.x_ = f16;
                onChanged();
                return this;
            }

            public Builder setY(float f16) {
                this.bitField0_ |= 2;
                this.y_ = f16;
                onChanged();
                return this;
            }

            Builder() {
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbVec2 build() {
                PbVec2 buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbVec2 buildPartial() {
                PbVec2 pbVec2 = new PbVec2(this);
                int i3 = this.bitField0_;
                int i16 = (i3 & 1) != 1 ? 0 : 1;
                pbVec2.x_ = this.x_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                pbVec2.y_ = this.y_;
                pbVec2.bitField0_ = i16;
                onBuilt();
                return pbVec2;
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            public PbVec2 getDefaultInstanceForType() {
                return PbVec2.getDefaultInstance();
            }

            Builder(GeneratedMessage.g gVar) {
                super(gVar);
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a
            public Builder clear() {
                super.clear();
                this.x_ = 0.0f;
                int i3 = this.bitField0_ & (-2);
                this.y_ = 0.0f;
                this.bitField0_ = i3 & (-3);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
            /* renamed from: clone */
            public Builder mo50clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            public Builder mergeFrom(ar arVar) {
                if (arVar instanceof PbVec2) {
                    return mergeFrom((PbVec2) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public Builder mergeFrom(PbVec2 pbVec2) {
                if (pbVec2 == PbVec2.getDefaultInstance()) {
                    return this;
                }
                if (pbVec2.hasX()) {
                    setX(pbVec2.getX());
                }
                if (pbVec2.hasY()) {
                    setY(pbVec2.getY());
                }
                mo52mergeUnknownFields(pbVec2.getUnknownFields());
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            public Builder mergeFrom(k kVar, t tVar) throws IOException {
                cc.b h16 = cc.h(getUnknownFields());
                while (true) {
                    int J = kVar.J();
                    if (J == 0) {
                        setUnknownFields(h16.build());
                        onChanged();
                        return this;
                    }
                    if (J == 13) {
                        this.bitField0_ |= 1;
                        this.x_ = kVar.v();
                    } else if (J != 21) {
                        if (!parseUnknownField(kVar, h16, tVar, J)) {
                            setUnknownFields(h16.build());
                            onChanged();
                            return this;
                        }
                    } else {
                        this.bitField0_ |= 2;
                        this.y_ = kVar.v();
                    }
                }
            }
        }

        static {
            PbVec2 pbVec2 = new PbVec2(true);
            defaultInstance = pbVec2;
            pbVec2.initFields();
        }

        public static PbVec2 getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.b getDescriptor() {
            return Box2D.internal_static_box2d_PbVec2_descriptor;
        }

        private void initFields() {
            this.x_ = 0.0f;
            this.y_ = 0.0f;
        }

        public static Builder newBuilder() {
            return Builder.access$300();
        }

        public static PbVec2 parseDelimitedFrom(InputStream inputStream) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbVec2 parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i16 = 0 + CodedOutputStream.r(1, this.x_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i16 += CodedOutputStream.r(2, this.y_);
            }
            int serializedSize = i16 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // org.box2d.proto.Box2D.PbVec2OrBuilder
        public float getX() {
            return this.x_;
        }

        @Override // org.box2d.proto.Box2D.PbVec2OrBuilder
        public float getY() {
            return this.y_;
        }

        @Override // org.box2d.proto.Box2D.PbVec2OrBuilder
        public boolean hasX() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbVec2OrBuilder
        public boolean hasY() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.j internalGetFieldAccessorTable() {
            return Box2D.internal_static_box2d_PbVec2_fieldAccessorTable;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 != -1) {
                if (b16 == 1) {
                    return true;
                }
                return false;
            }
            if (!hasX()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasY()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.A0(1, this.x_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.A0(2, this.y_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        PbVec2(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Builder newBuilder(PbVec2 pbVec2) {
            return newBuilder().mergeFrom(pbVec2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbVec2 parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbVec2 parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.av, com.google.protobuf.ax
        public PbVec2 getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static PbVec2 parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream, tVar)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbVec2 parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr, tVar)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder newBuilderForType() {
            return newBuilder();
        }

        PbVec2(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbVec2 parseFrom(InputStream inputStream) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.g gVar) {
            return new Builder(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbVec2 parseFrom(InputStream inputStream, t tVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbVec2 parseFrom(k kVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(kVar)).buildParsed();
        }

        public static PbVec2 parseFrom(k kVar, t tVar) throws IOException {
            return newBuilder().mergeFrom(kVar, tVar).buildParsed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface PbVec2OrBuilder extends ax {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.ax
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Override // com.google.protobuf.ax
        /* synthetic */ ar getDefaultInstanceForType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar);

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        @Override // com.google.protobuf.ax
        /* synthetic */ cc getUnknownFields();

        float getX();

        float getY();

        @Override // com.google.protobuf.ax
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.g gVar);

        boolean hasX();

        boolean hasY();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PbWorld extends GeneratedMessage implements PbWorldOrBuilder {
        public static final int ALLOW_SLEEP_FIELD_NUMBER = 3;
        public static final int AUTO_CLEAR_FORCES_FIELD_NUMBER = 4;
        public static final int BODIES_FIELD_NUMBER = 20;
        public static final int CONTINUOUS_PHYSICS_FIELD_NUMBER = 6;
        public static final int GRAVITY_FIELD_NUMBER = 2;
        public static final int JOINTS_FIELD_NUMBER = 21;
        public static final int SUB_STEPPING_FIELD_NUMBER = 7;
        public static final int TAG_FIELD_NUMBER = 1;
        public static final int WARM_STARTING_FIELD_NUMBER = 5;
        private static final PbWorld defaultInstance;
        private static final long serialVersionUID = 0;
        private boolean allowSleep_;
        private boolean autoClearForces_;
        private int bitField0_;
        private List<PbBody> bodies_;
        private boolean continuousPhysics_;
        private PbVec2 gravity_;
        private List<PbJoint> joints_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean subStepping_;
        private long tag_;
        private boolean warmStarting_;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Builder extends GeneratedMessage.f<Builder> implements PbWorldOrBuilder {
            private boolean allowSleep_;
            private boolean autoClearForces_;
            private int bitField0_;
            private bo<PbBody, PbBody.Builder, PbBodyOrBuilder> bodiesBuilder_;
            private List<PbBody> bodies_;
            private boolean continuousPhysics_;
            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> gravityBuilder_;
            private PbVec2 gravity_;
            private bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> jointsBuilder_;
            private List<PbJoint> joints_;
            private boolean subStepping_;
            private long tag_;
            private boolean warmStarting_;

            static /* synthetic */ Builder access$12800() {
                return create();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PbWorld buildParsed() throws InvalidProtocolBufferException {
                PbWorld buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial).asInvalidProtocolBufferException();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureBodiesIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.bodies_ = new ArrayList(this.bodies_);
                    this.bitField0_ |= 128;
                }
            }

            private void ensureJointsIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.joints_ = new ArrayList(this.joints_);
                    this.bitField0_ |= 256;
                }
            }

            private bo<PbBody, PbBody.Builder, PbBodyOrBuilder> getBodiesFieldBuilder() {
                boolean z16;
                if (this.bodiesBuilder_ == null) {
                    List<PbBody> list = this.bodies_;
                    if ((this.bitField0_ & 128) == 128) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.bodiesBuilder_ = new bo<>(list, z16, getParentForChildren(), isClean());
                    this.bodies_ = null;
                }
                return this.bodiesBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return Box2D.internal_static_box2d_PbWorld_descriptor;
            }

            private bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> getGravityFieldBuilder() {
                if (this.gravityBuilder_ == null) {
                    this.gravityBuilder_ = new bt<>(this.gravity_, getParentForChildren(), isClean());
                    this.gravity_ = null;
                }
                return this.gravityBuilder_;
            }

            private bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> getJointsFieldBuilder() {
                boolean z16;
                if (this.jointsBuilder_ == null) {
                    List<PbJoint> list = this.joints_;
                    if ((this.bitField0_ & 256) == 256) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.jointsBuilder_ = new bo<>(list, z16, getParentForChildren(), isClean());
                    this.joints_ = null;
                }
                return this.jointsBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getGravityFieldBuilder();
                    getBodiesFieldBuilder();
                    getJointsFieldBuilder();
                }
            }

            public Builder addAllBodies(Iterable<? extends PbBody> iterable) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    ensureBodiesIsMutable();
                    b.a.addAll((Iterable) iterable, (Collection) this.bodies_);
                    onChanged();
                } else {
                    boVar.b(iterable);
                }
                return this;
            }

            public Builder addAllJoints(Iterable<? extends PbJoint> iterable) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    ensureJointsIsMutable();
                    b.a.addAll((Iterable) iterable, (Collection) this.joints_);
                    onChanged();
                } else {
                    boVar.b(iterable);
                }
                return this;
            }

            public Builder addBodies(PbBody pbBody) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    pbBody.getClass();
                    ensureBodiesIsMutable();
                    this.bodies_.add(pbBody);
                    onChanged();
                } else {
                    boVar.f(pbBody);
                }
                return this;
            }

            public PbBody.Builder addBodiesBuilder() {
                return getBodiesFieldBuilder().d(PbBody.getDefaultInstance());
            }

            public Builder addJoints(PbJoint pbJoint) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    pbJoint.getClass();
                    ensureJointsIsMutable();
                    this.joints_.add(pbJoint);
                    onChanged();
                } else {
                    boVar.f(pbJoint);
                }
                return this;
            }

            public PbJoint.Builder addJointsBuilder() {
                return getJointsFieldBuilder().d(PbJoint.getDefaultInstance());
            }

            public Builder clearAllowSleep() {
                this.bitField0_ &= -5;
                this.allowSleep_ = false;
                onChanged();
                return this;
            }

            public Builder clearAutoClearForces() {
                this.bitField0_ &= -9;
                this.autoClearForces_ = false;
                onChanged();
                return this;
            }

            public Builder clearBodies() {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    this.bodies_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                    onChanged();
                } else {
                    boVar.h();
                }
                return this;
            }

            public Builder clearContinuousPhysics() {
                this.bitField0_ &= -33;
                this.continuousPhysics_ = false;
                onChanged();
                return this;
            }

            public Builder clearGravity() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.gravityBuilder_;
                if (btVar == null) {
                    this.gravity_ = PbVec2.getDefaultInstance();
                    onChanged();
                } else {
                    btVar.c();
                }
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearJoints() {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    this.joints_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                    onChanged();
                } else {
                    boVar.h();
                }
                return this;
            }

            public Builder clearSubStepping() {
                this.bitField0_ &= -65;
                this.subStepping_ = false;
                onChanged();
                return this;
            }

            public Builder clearTag() {
                this.bitField0_ &= -2;
                this.tag_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearWarmStarting() {
                this.bitField0_ &= -17;
                this.warmStarting_ = false;
                onChanged();
                return this;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean getAllowSleep() {
                return this.allowSleep_;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean getAutoClearForces() {
                return this.autoClearForces_;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public PbBody getBodies(int i3) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    return this.bodies_.get(i3);
                }
                return boVar.o(i3);
            }

            public PbBody.Builder getBodiesBuilder(int i3) {
                return getBodiesFieldBuilder().l(i3);
            }

            public List<PbBody.Builder> getBodiesBuilderList() {
                return getBodiesFieldBuilder().m();
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public int getBodiesCount() {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    return this.bodies_.size();
                }
                return boVar.n();
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public List<PbBody> getBodiesList() {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    return Collections.unmodifiableList(this.bodies_);
                }
                return boVar.q();
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public PbBodyOrBuilder getBodiesOrBuilder(int i3) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    return this.bodies_.get(i3);
                }
                return boVar.r(i3);
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public List<? extends PbBodyOrBuilder> getBodiesOrBuilderList() {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar != null) {
                    return boVar.s();
                }
                return Collections.unmodifiableList(this.bodies_);
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean getContinuousPhysics() {
                return this.continuousPhysics_;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return PbWorld.getDescriptor();
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public PbVec2 getGravity() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.gravityBuilder_;
                if (btVar == null) {
                    return this.gravity_;
                }
                return btVar.f();
            }

            public PbVec2.Builder getGravityBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return getGravityFieldBuilder().e();
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public PbVec2OrBuilder getGravityOrBuilder() {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.gravityBuilder_;
                if (btVar != null) {
                    return btVar.g();
                }
                return this.gravity_;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public PbJoint getJoints(int i3) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    return this.joints_.get(i3);
                }
                return boVar.o(i3);
            }

            public PbJoint.Builder getJointsBuilder(int i3) {
                return getJointsFieldBuilder().l(i3);
            }

            public List<PbJoint.Builder> getJointsBuilderList() {
                return getJointsFieldBuilder().m();
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public int getJointsCount() {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    return this.joints_.size();
                }
                return boVar.n();
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public List<PbJoint> getJointsList() {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    return Collections.unmodifiableList(this.joints_);
                }
                return boVar.q();
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public PbJointOrBuilder getJointsOrBuilder(int i3) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    return this.joints_.get(i3);
                }
                return boVar.r(i3);
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public List<? extends PbJointOrBuilder> getJointsOrBuilderList() {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar != null) {
                    return boVar.s();
                }
                return Collections.unmodifiableList(this.joints_);
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean getSubStepping() {
                return this.subStepping_;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public long getTag() {
                return this.tag_;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean getWarmStarting() {
                return this.warmStarting_;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean hasAllowSleep() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean hasAutoClearForces() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean hasContinuousPhysics() {
                if ((this.bitField0_ & 32) == 32) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean hasGravity() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean hasSubStepping() {
                if ((this.bitField0_ & 64) == 64) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean hasTag() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
            public boolean hasWarmStarting() {
                if ((this.bitField0_ & 16) == 16) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.f
            protected GeneratedMessage.j internalGetFieldAccessorTable() {
                return Box2D.internal_static_box2d_PbWorld_fieldAccessorTable;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.av
            public final boolean isInitialized() {
                if (hasGravity() && !getGravity().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getBodiesCount(); i3++) {
                    if (!getBodies(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i16 = 0; i16 < getJointsCount(); i16++) {
                    if (!getJoints(i16).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeGravity(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.gravityBuilder_;
                if (btVar == null) {
                    if ((this.bitField0_ & 2) == 2 && this.gravity_ != PbVec2.getDefaultInstance()) {
                        this.gravity_ = PbVec2.newBuilder(this.gravity_).mergeFrom(pbVec2).buildPartial();
                    } else {
                        this.gravity_ = pbVec2;
                    }
                    onChanged();
                } else {
                    btVar.h(pbVec2);
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder removeBodies(int i3) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    ensureBodiesIsMutable();
                    this.bodies_.remove(i3);
                    onChanged();
                } else {
                    boVar.w(i3);
                }
                return this;
            }

            public Builder removeJoints(int i3) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    ensureJointsIsMutable();
                    this.joints_.remove(i3);
                    onChanged();
                } else {
                    boVar.w(i3);
                }
                return this;
            }

            public Builder setAllowSleep(boolean z16) {
                this.bitField0_ |= 4;
                this.allowSleep_ = z16;
                onChanged();
                return this;
            }

            public Builder setAutoClearForces(boolean z16) {
                this.bitField0_ |= 8;
                this.autoClearForces_ = z16;
                onChanged();
                return this;
            }

            public Builder setBodies(int i3, PbBody pbBody) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    pbBody.getClass();
                    ensureBodiesIsMutable();
                    this.bodies_.set(i3, pbBody);
                    onChanged();
                } else {
                    boVar.x(i3, pbBody);
                }
                return this;
            }

            public Builder setContinuousPhysics(boolean z16) {
                this.bitField0_ |= 32;
                this.continuousPhysics_ = z16;
                onChanged();
                return this;
            }

            public Builder setGravity(PbVec2 pbVec2) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.gravityBuilder_;
                if (btVar == null) {
                    pbVec2.getClass();
                    this.gravity_ = pbVec2;
                    onChanged();
                } else {
                    btVar.j(pbVec2);
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setJoints(int i3, PbJoint pbJoint) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    pbJoint.getClass();
                    ensureJointsIsMutable();
                    this.joints_.set(i3, pbJoint);
                    onChanged();
                } else {
                    boVar.x(i3, pbJoint);
                }
                return this;
            }

            public Builder setSubStepping(boolean z16) {
                this.bitField0_ |= 64;
                this.subStepping_ = z16;
                onChanged();
                return this;
            }

            public Builder setTag(long j3) {
                this.bitField0_ |= 1;
                this.tag_ = j3;
                onChanged();
                return this;
            }

            public Builder setWarmStarting(boolean z16) {
                this.bitField0_ |= 16;
                this.warmStarting_ = z16;
                onChanged();
                return this;
            }

            Builder() {
                this.gravity_ = PbVec2.getDefaultInstance();
                this.bodies_ = Collections.emptyList();
                this.joints_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public PbBody.Builder addBodiesBuilder(int i3) {
                return getBodiesFieldBuilder().c(i3, PbBody.getDefaultInstance());
            }

            public PbJoint.Builder addJointsBuilder(int i3) {
                return getJointsFieldBuilder().c(i3, PbJoint.getDefaultInstance());
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbWorld build() {
                PbWorld buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            public PbWorld buildPartial() {
                PbWorld pbWorld = new PbWorld(this);
                int i3 = this.bitField0_;
                int i16 = (i3 & 1) != 1 ? 0 : 1;
                pbWorld.tag_ = this.tag_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.gravityBuilder_;
                if (btVar == null) {
                    pbWorld.gravity_ = this.gravity_;
                } else {
                    pbWorld.gravity_ = btVar.b();
                }
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                pbWorld.allowSleep_ = this.allowSleep_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                pbWorld.autoClearForces_ = this.autoClearForces_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                pbWorld.warmStarting_ = this.warmStarting_;
                if ((i3 & 32) == 32) {
                    i16 |= 32;
                }
                pbWorld.continuousPhysics_ = this.continuousPhysics_;
                if ((i3 & 64) == 64) {
                    i16 |= 64;
                }
                pbWorld.subStepping_ = this.subStepping_;
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar != null) {
                    pbWorld.bodies_ = boVar.g();
                } else {
                    if ((this.bitField0_ & 128) == 128) {
                        this.bodies_ = Collections.unmodifiableList(this.bodies_);
                        this.bitField0_ &= -129;
                    }
                    pbWorld.bodies_ = this.bodies_;
                }
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar2 = this.jointsBuilder_;
                if (boVar2 != null) {
                    pbWorld.joints_ = boVar2.g();
                } else {
                    if ((this.bitField0_ & 256) == 256) {
                        this.joints_ = Collections.unmodifiableList(this.joints_);
                        this.bitField0_ &= -257;
                    }
                    pbWorld.joints_ = this.joints_;
                }
                pbWorld.bitField0_ = i16;
                onBuilt();
                return pbWorld;
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            public PbWorld getDefaultInstanceForType() {
                return PbWorld.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a
            public Builder clear() {
                super.clear();
                this.tag_ = 0L;
                this.bitField0_ &= -2;
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.gravityBuilder_;
                if (btVar == null) {
                    this.gravity_ = PbVec2.getDefaultInstance();
                } else {
                    btVar.c();
                }
                int i3 = this.bitField0_ & (-3);
                this.allowSleep_ = false;
                this.autoClearForces_ = false;
                this.warmStarting_ = false;
                this.continuousPhysics_ = false;
                this.subStepping_ = false;
                this.bitField0_ = i3 & (-5) & (-9) & (-17) & (-33) & (-65);
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    this.bodies_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                } else {
                    boVar.h();
                }
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar2 = this.jointsBuilder_;
                if (boVar2 == null) {
                    this.joints_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                } else {
                    boVar2.h();
                }
                return this;
            }

            Builder(GeneratedMessage.g gVar) {
                super(gVar);
                this.gravity_ = PbVec2.getDefaultInstance();
                this.bodies_ = Collections.emptyList();
                this.joints_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addBodies(int i3, PbBody pbBody) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    pbBody.getClass();
                    ensureBodiesIsMutable();
                    this.bodies_.add(i3, pbBody);
                    onChanged();
                } else {
                    boVar.e(i3, pbBody);
                }
                return this;
            }

            public Builder addJoints(int i3, PbJoint pbJoint) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    pbJoint.getClass();
                    ensureJointsIsMutable();
                    this.joints_.add(i3, pbJoint);
                    onChanged();
                } else {
                    boVar.e(i3, pbJoint);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.f, com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
            /* renamed from: clone */
            public Builder mo50clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            public Builder mergeFrom(ar arVar) {
                if (arVar instanceof PbWorld) {
                    return mergeFrom((PbWorld) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public Builder setBodies(int i3, PbBody.Builder builder) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    ensureBodiesIsMutable();
                    this.bodies_.set(i3, builder.build());
                    onChanged();
                } else {
                    boVar.x(i3, builder.build());
                }
                return this;
            }

            public Builder setGravity(PbVec2.Builder builder) {
                bt<PbVec2, PbVec2.Builder, PbVec2OrBuilder> btVar = this.gravityBuilder_;
                if (btVar == null) {
                    this.gravity_ = builder.build();
                    onChanged();
                } else {
                    btVar.j(builder.build());
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setJoints(int i3, PbJoint.Builder builder) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    ensureJointsIsMutable();
                    this.joints_.set(i3, builder.build());
                    onChanged();
                } else {
                    boVar.x(i3, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(PbWorld pbWorld) {
                if (pbWorld == PbWorld.getDefaultInstance()) {
                    return this;
                }
                if (pbWorld.hasTag()) {
                    setTag(pbWorld.getTag());
                }
                if (pbWorld.hasGravity()) {
                    mergeGravity(pbWorld.getGravity());
                }
                if (pbWorld.hasAllowSleep()) {
                    setAllowSleep(pbWorld.getAllowSleep());
                }
                if (pbWorld.hasAutoClearForces()) {
                    setAutoClearForces(pbWorld.getAutoClearForces());
                }
                if (pbWorld.hasWarmStarting()) {
                    setWarmStarting(pbWorld.getWarmStarting());
                }
                if (pbWorld.hasContinuousPhysics()) {
                    setContinuousPhysics(pbWorld.getContinuousPhysics());
                }
                if (pbWorld.hasSubStepping()) {
                    setSubStepping(pbWorld.getSubStepping());
                }
                if (this.bodiesBuilder_ == null) {
                    if (!pbWorld.bodies_.isEmpty()) {
                        if (this.bodies_.isEmpty()) {
                            this.bodies_ = pbWorld.bodies_;
                            this.bitField0_ &= -129;
                        } else {
                            ensureBodiesIsMutable();
                            this.bodies_.addAll(pbWorld.bodies_);
                        }
                        onChanged();
                    }
                } else if (!pbWorld.bodies_.isEmpty()) {
                    if (!this.bodiesBuilder_.u()) {
                        this.bodiesBuilder_.b(pbWorld.bodies_);
                    } else {
                        this.bodiesBuilder_.i();
                        this.bodiesBuilder_ = null;
                        this.bodies_ = pbWorld.bodies_;
                        this.bitField0_ &= -129;
                        this.bodiesBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getBodiesFieldBuilder() : null;
                    }
                }
                if (this.jointsBuilder_ == null) {
                    if (!pbWorld.joints_.isEmpty()) {
                        if (this.joints_.isEmpty()) {
                            this.joints_ = pbWorld.joints_;
                            this.bitField0_ &= -257;
                        } else {
                            ensureJointsIsMutable();
                            this.joints_.addAll(pbWorld.joints_);
                        }
                        onChanged();
                    }
                } else if (!pbWorld.joints_.isEmpty()) {
                    if (!this.jointsBuilder_.u()) {
                        this.jointsBuilder_.b(pbWorld.joints_);
                    } else {
                        this.jointsBuilder_.i();
                        this.jointsBuilder_ = null;
                        this.joints_ = pbWorld.joints_;
                        this.bitField0_ &= -257;
                        this.jointsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getJointsFieldBuilder() : null;
                    }
                }
                mo52mergeUnknownFields(pbWorld.getUnknownFields());
                return this;
            }

            public Builder addBodies(PbBody.Builder builder) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    ensureBodiesIsMutable();
                    this.bodies_.add(builder.build());
                    onChanged();
                } else {
                    boVar.f(builder.build());
                }
                return this;
            }

            public Builder addJoints(PbJoint.Builder builder) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    ensureJointsIsMutable();
                    this.joints_.add(builder.build());
                    onChanged();
                } else {
                    boVar.f(builder.build());
                }
                return this;
            }

            public Builder addBodies(int i3, PbBody.Builder builder) {
                bo<PbBody, PbBody.Builder, PbBodyOrBuilder> boVar = this.bodiesBuilder_;
                if (boVar == null) {
                    ensureBodiesIsMutable();
                    this.bodies_.add(i3, builder.build());
                    onChanged();
                } else {
                    boVar.e(i3, builder.build());
                }
                return this;
            }

            public Builder addJoints(int i3, PbJoint.Builder builder) {
                bo<PbJoint, PbJoint.Builder, PbJointOrBuilder> boVar = this.jointsBuilder_;
                if (boVar == null) {
                    ensureJointsIsMutable();
                    this.joints_.add(i3, builder.build());
                    onChanged();
                } else {
                    boVar.e(i3, builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            public Builder mergeFrom(k kVar, t tVar) throws IOException {
                cc.b h16 = cc.h(getUnknownFields());
                while (true) {
                    int J = kVar.J();
                    if (J == 0) {
                        setUnknownFields(h16.build());
                        onChanged();
                        return this;
                    }
                    if (J == 8) {
                        this.bitField0_ |= 1;
                        this.tag_ = kVar.y();
                    } else if (J == 18) {
                        PbVec2.Builder newBuilder = PbVec2.newBuilder();
                        if (hasGravity()) {
                            newBuilder.mergeFrom(getGravity());
                        }
                        kVar.A(newBuilder, tVar);
                        setGravity(newBuilder.buildPartial());
                    } else if (J == 24) {
                        this.bitField0_ |= 4;
                        this.allowSleep_ = kVar.p();
                    } else if (J == 32) {
                        this.bitField0_ |= 8;
                        this.autoClearForces_ = kVar.p();
                    } else if (J == 40) {
                        this.bitField0_ |= 16;
                        this.warmStarting_ = kVar.p();
                    } else if (J == 48) {
                        this.bitField0_ |= 32;
                        this.continuousPhysics_ = kVar.p();
                    } else if (J == 56) {
                        this.bitField0_ |= 64;
                        this.subStepping_ = kVar.p();
                    } else if (J == 162) {
                        PbBody.Builder newBuilder2 = PbBody.newBuilder();
                        kVar.A(newBuilder2, tVar);
                        addBodies(newBuilder2.buildPartial());
                    } else if (J != 170) {
                        if (!parseUnknownField(kVar, h16, tVar, J)) {
                            setUnknownFields(h16.build());
                            onChanged();
                            return this;
                        }
                    } else {
                        PbJoint.Builder newBuilder3 = PbJoint.newBuilder();
                        kVar.A(newBuilder3, tVar);
                        addJoints(newBuilder3.buildPartial());
                    }
                }
            }
        }

        static {
            PbWorld pbWorld = new PbWorld(true);
            defaultInstance = pbWorld;
            pbWorld.initFields();
        }

        public static PbWorld getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.b getDescriptor() {
            return Box2D.internal_static_box2d_PbWorld_descriptor;
        }

        private void initFields() {
            this.tag_ = 0L;
            this.gravity_ = PbVec2.getDefaultInstance();
            this.allowSleep_ = false;
            this.autoClearForces_ = false;
            this.warmStarting_ = false;
            this.continuousPhysics_ = false;
            this.subStepping_ = false;
            this.bodies_ = Collections.emptyList();
            this.joints_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$12800();
        }

        public static PbWorld parseDelimitedFrom(InputStream inputStream) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbWorld parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString)).buildParsed();
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean getAllowSleep() {
            return this.allowSleep_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean getAutoClearForces() {
            return this.autoClearForces_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public PbBody getBodies(int i3) {
            return this.bodies_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public int getBodiesCount() {
            return this.bodies_.size();
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public List<PbBody> getBodiesList() {
            return this.bodies_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public PbBodyOrBuilder getBodiesOrBuilder(int i3) {
            return this.bodies_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public List<? extends PbBodyOrBuilder> getBodiesOrBuilderList() {
            return this.bodies_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean getContinuousPhysics() {
            return this.continuousPhysics_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public PbVec2 getGravity() {
            return this.gravity_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public PbVec2OrBuilder getGravityOrBuilder() {
            return this.gravity_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public PbJoint getJoints(int i3) {
            return this.joints_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public int getJointsCount() {
            return this.joints_.size();
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public List<PbJoint> getJointsList() {
            return this.joints_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public PbJointOrBuilder getJointsOrBuilder(int i3) {
            return this.joints_.get(i3);
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public List<? extends PbJointOrBuilder> getJointsOrBuilderList() {
            return this.joints_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.z(1, this.tag_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.G(2, this.gravity_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.e(3, this.allowSleep_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.e(4, this.autoClearForces_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.e(5, this.warmStarting_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.e(6, this.continuousPhysics_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.e(7, this.subStepping_);
            }
            for (int i17 = 0; i17 < this.bodies_.size(); i17++) {
                i3 += CodedOutputStream.G(20, this.bodies_.get(i17));
            }
            for (int i18 = 0; i18 < this.joints_.size(); i18++) {
                i3 += CodedOutputStream.G(21, this.joints_.get(i18));
            }
            int serializedSize = i3 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean getSubStepping() {
            return this.subStepping_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public long getTag() {
            return this.tag_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean getWarmStarting() {
            return this.warmStarting_;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean hasAllowSleep() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean hasAutoClearForces() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean hasContinuousPhysics() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean hasGravity() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean hasSubStepping() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean hasTag() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // org.box2d.proto.Box2D.PbWorldOrBuilder
        public boolean hasWarmStarting() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.j internalGetFieldAccessorTable() {
            return Box2D.internal_static_box2d_PbWorld_fieldAccessorTable;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 != -1) {
                if (b16 == 1) {
                    return true;
                }
                return false;
            }
            if (hasGravity() && !getGravity().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getBodiesCount(); i3++) {
                if (!getBodies(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getJointsCount(); i16++) {
                if (!getJoints(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.I0(1, this.tag_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.K0(2, this.gravity_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m0(3, this.allowSleep_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m0(4, this.autoClearForces_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m0(5, this.warmStarting_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.m0(6, this.continuousPhysics_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.m0(7, this.subStepping_);
            }
            for (int i3 = 0; i3 < this.bodies_.size(); i3++) {
                codedOutputStream.K0(20, this.bodies_.get(i3));
            }
            for (int i16 = 0; i16 < this.joints_.size(); i16++) {
                codedOutputStream.K0(21, this.joints_.get(i16));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        PbWorld(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Builder newBuilder(PbWorld pbWorld) {
            return newBuilder().mergeFrom(pbWorld);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbWorld parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(byteString, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbWorld parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.av, com.google.protobuf.ax
        public PbWorld getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static PbWorld parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            Builder newBuilder = newBuilder();
            if (newBuilder.mergeDelimitedFrom(inputStream, tVar)) {
                return newBuilder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbWorld parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(bArr, tVar)).buildParsed();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.au, com.google.protobuf.ar
        public Builder newBuilderForType() {
            return newBuilder();
        }

        PbWorld(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbWorld parseFrom(InputStream inputStream) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.g gVar) {
            return new Builder(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbWorld parseFrom(InputStream inputStream, t tVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(inputStream, tVar)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PbWorld parseFrom(k kVar) throws IOException {
            return ((Builder) newBuilder().mergeFrom(kVar)).buildParsed();
        }

        public static PbWorld parseFrom(k kVar, t tVar) throws IOException {
            return newBuilder().mergeFrom(kVar, tVar).buildParsed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface PbWorldOrBuilder extends ax {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.ax
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        boolean getAllowSleep();

        boolean getAutoClearForces();

        PbBody getBodies(int i3);

        int getBodiesCount();

        List<PbBody> getBodiesList();

        PbBodyOrBuilder getBodiesOrBuilder(int i3);

        List<? extends PbBodyOrBuilder> getBodiesOrBuilderList();

        boolean getContinuousPhysics();

        @Override // com.google.protobuf.ax
        /* synthetic */ ar getDefaultInstanceForType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.ax
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        PbVec2 getGravity();

        PbVec2OrBuilder getGravityOrBuilder();

        /* synthetic */ String getInitializationErrorString();

        PbJoint getJoints(int i3);

        int getJointsCount();

        List<PbJoint> getJointsList();

        PbJointOrBuilder getJointsOrBuilder(int i3);

        List<? extends PbJointOrBuilder> getJointsOrBuilderList();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar);

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        boolean getSubStepping();

        long getTag();

        @Override // com.google.protobuf.ax
        /* synthetic */ cc getUnknownFields();

        boolean getWarmStarting();

        boolean hasAllowSleep();

        boolean hasAutoClearForces();

        boolean hasContinuousPhysics();

        @Override // com.google.protobuf.ax
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasGravity();

        /* synthetic */ boolean hasOneof(Descriptors.g gVar);

        boolean hasSubStepping();

        boolean hasTag();

        boolean hasWarmStarting();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    static {
        Descriptors.FileDescriptor.v(new String[]{"\n$src/main/resources/proto/box2d.proto\u0012\u0005box2d\"\u001e\n\u0006PbVec2\u0012\t\n\u0001x\u0018\u0001 \u0002(\u0002\u0012\t\n\u0001y\u0018\u0002 \u0002(\u0002\"I\n\bPbFilter\u0012\u0015\n\rcategory_bits\u0018\u0001 \u0001(\u0005\u0012\u0011\n\tmask_bits\u0018\u0002 \u0001(\u0005\u0012\u0013\n\u000bgroup_index\u0018\u0003 \u0001(\u0005\"\u0089\u0003\n\u0007PbShape\u0012\u000b\n\u0003tag\u0018\u0001 \u0001(\u0003\u0012 \n\u0004type\u0018\u0002 \u0002(\u000e2\u0012.box2d.PbShapeType\u0012\u001d\n\u0006center\u0018\n \u0001(\u000b2\r.box2d.PbVec2\u0012\u000e\n\u0006radius\u0018\u000b \u0001(\u0002\u0012\u001d\n\u0006points\u0018\u0014 \u0003(\u000b2\r.box2d.PbVec2\u0012\u001e\n\u0007normals\u0018\u0015 \u0003(\u000b2\r.box2d.PbVec2\u0012\u001f\n\bcentroid\u0018\u0016 \u0001(\u000b2\r.box2d.PbVec2\u0012\u0019\n\u0002v0\u0018\u001e \u0001(\u000b2\r.box2d.PbVec2\u0012\u0019\n\u0002v1\u0018\u001f \u0001(\u000b2\r.box2", "d.PbVec2\u0012\u0019\n\u0002v2\u0018  \u0001(\u000b2\r.box2d.PbVec2\u0012\u0019\n\u0002v3\u0018! \u0001(\u000b2\r.box2d.PbVec2\u0012\f\n\u0004has0\u0018\" \u0001(\b\u0012\f\n\u0004has3\u0018# \u0001(\b\u0012\u001b\n\u0004prev\u0018( \u0001(\u000b2\r.box2d.PbVec2\u0012\u001b\n\u0004next\u0018) \u0001(\u000b2\r.box2d.PbVec2\"\u00a0\u0001\n\tPbFixture\u0012\u000b\n\u0003tag\u0018\u0001 \u0001(\u0003\u0012\u0013\n\u000brestitution\u0018\u0002 \u0001(\u0002\u0012\u0010\n\bfriction\u0018\u0003 \u0001(\u0002\u0012\u000f\n\u0007density\u0018\u0004 \u0001(\u0002\u0012\u000e\n\u0006sensor\u0018\u0005 \u0001(\b\u0012\u001f\n\u0006filter\u0018\n \u0001(\u000b2\u000f.box2d.PbFilter\u0012\u001d\n\u0005shape\u0018\u000b \u0001(\u000b2\u000e.box2d.PbShape\"\u00ed\u0005\n\u0007PbJoint\u0012\u000b\n\u0003tag\u0018\u0001 \u0001(\u0003\u0012 \n\u0004type\u0018\u0002 \u0002(\u000e2\u0012.box2d.PbJointType\u0012\u000e\n\u0006body_a\u0018\u0003 \u0001(\u0005\u0012\u000e\n\u0006body_b\u0018\u0004 \u0001", "(\u0005\u0012\u0018\n\u0010collideConnected\u0018\u0005 \u0001(\b\u0012%\n\u000elocal_anchor_a\u0018\u0006 \u0001(\u000b2\r.box2d.PbVec2\u0012%\n\u000elocal_anchor_b\u0018\u0007 \u0001(\u000b2\r.box2d.PbVec2\u0012\u0011\n\tref_angle\u0018\n \u0001(\u0002\u0012\u0014\n\fenable_limit\u0018\f \u0001(\b\u0012\u0013\n\u000blower_limit\u0018\r \u0001(\u0002\u0012\u0013\n\u000bupper_limit\u0018\u000e \u0001(\u0002\u0012\u0014\n\fenable_motor\u0018\u000f \u0001(\b\u0012\u0013\n\u000bmotor_speed\u0018\u0010 \u0001(\u0002\u0012\u0018\n\u0010max_motor_torque\u0018\u0011 \u0001(\u0002\u0012#\n\flocal_axis_a\u0018\u0014 \u0001(\u000b2\r.box2d.PbVec2\u0012\u0017\n\u000fmax_motor_force\u0018\u0015 \u0001(\u0002\u0012\u000e\n\u0006length\u0018\u001e \u0001(\u0002\u0012\u0011\n\tfrequency\u0018\u001f \u0001(\u0002\u0012\u0015\n\rdamping_ratio\u0018  \u0001(\u0002\u0012&\n\u000fground_anchor_a\u0018( ", "\u0001(\u000b2\r.box2d.PbVec2\u0012&\n\u000fground_anchor_b\u0018) \u0001(\u000b2\r.box2d.PbVec2\u0012\u0010\n\blength_a\u0018* \u0001(\u0002\u0012\u0010\n\blength_b\u0018+ \u0001(\u0002\u0012\r\n\u0005ratio\u0018, \u0001(\u0002\u0012\u001d\n\u0006target\u00182 \u0001(\u000b2\r.box2d.PbVec2\u0012\u0011\n\tmax_force\u00183 \u0001(\u0002\u0012\u000e\n\u0006joint1\u0018= \u0001(\u0005\u0012\u000e\n\u0006joint2\u0018> \u0001(\u0005\u0012\u0012\n\nmax_torque\u0018Z \u0001(\u0002\u0012\u0012\n\nmax_length\u0018d \u0001(\u0002\u0012\u000e\n\u0006bodies\u0018n \u0003(\u0005\u0012\u000e\n\u0006joints\u0018o \u0003(\u0005\"\u00f0\u0002\n\u0006PbBody\u0012\u000b\n\u0003tag\u0018\u0001 \u0001(\u0003\u0012\u001f\n\u0004type\u0018\u0002 \u0002(\u000e2\u0011.box2d.PbBodyType\u0012\u001f\n\bposition\u0018\n \u0001(\u000b2\r.box2d.PbVec2\u0012\r\n\u0005angle\u0018\u000b \u0001(\u0002\u0012&\n\u000flinear_velocity\u0018\f \u0001(\u000b2\r.box2", "d.PbVec2\u0012\u0018\n\u0010angular_velocity\u0018\r \u0001(\u0002\u0012\u0016\n\u000elinear_damping\u00182 \u0001(\u0002\u0012\u0017\n\u000fangular_damping\u00183 \u0001(\u0002\u0012\u0015\n\rgravity_scale\u00184 \u0001(\u0002\u0012\u000e\n\u0006bullet\u00185 \u0001(\b\u0012\u0013\n\u000ballow_sleep\u00186 \u0001(\b\u0012\r\n\u0005awake\u00187 \u0001(\b\u0012\u000e\n\u0006active\u00188 \u0001(\b\u0012\u0016\n\u000efixed_rotation\u00189 \u0001(\b\u0012\"\n\bfixtures\u0018d \u0003(\u000b2\u0010.box2d.PbFixture\"\u00ee\u0001\n\u0007PbWorld\u0012\u000b\n\u0003tag\u0018\u0001 \u0001(\u0003\u0012\u001e\n\u0007gravity\u0018\u0002 \u0001(\u000b2\r.box2d.PbVec2\u0012\u0013\n\u000ballow_sleep\u0018\u0003 \u0001(\b\u0012\u0019\n\u0011auto_clear_forces\u0018\u0004 \u0001(\b\u0012\u0015\n\rwarm_starting\u0018\u0005 \u0001(\b\u0012\u001a\n\u0012continuous_physics\u0018\u0006 \u0001(\b\u0012\u0014\n\fsub_st", "epping\u0018\u0007 \u0001(\b\u0012\u001d\n\u0006bodies\u0018\u0014 \u0003(\u000b2\r.box2d.PbBody\u0012\u001e\n\u0006joints\u0018\u0015 \u0003(\u000b2\u000e.box2d.PbJoint*4\n\nPbBodyType\u0012\n\n\u0006STATIC\u0010\u0000\u0012\u000b\n\u0007DYNAMIC\u0010\u0001\u0012\r\n\tKINEMATIC\u0010\u0002*;\n\u000bPbShapeType\u0012\n\n\u0006CIRCLE\u0010\u0001\u0012\u000b\n\u0007POLYGON\u0010\u0002\u0012\b\n\u0004EDGE\u0010\u0003\u0012\t\n\u0005CHAIN\u0010\u0004*\u00a5\u0001\n\u000bPbJointType\u0012\f\n\bDISTANCE\u0010\u0001\u0012\f\n\bREVOLUTE\u0010\u0002\u0012\r\n\tPRISMATIC\u0010\u0003\u0012\n\n\u0006PULLEY\u0010\u0004\u0012\t\n\u0005MOUSE\u0010\u0005\u0012\b\n\u0004GEAR\u0010\u0006\u0012\t\n\u0005WHEEL\u0010\u0007\u0012\b\n\u0004WELD\u0010\b\u0012\f\n\bFRICTION\u0010\t\u0012\b\n\u0004ROPE\u0010\n\u0012\u0013\n\u000fCONSTANT_VOLUME\u0010\u000b\u0012\b\n\u0004LINE\u0010\fB\u0018\n\u000forg.box2d.protoB\u0005Box2D"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: org.box2d.proto.Box2D.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public r assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Box2D.descriptor = fileDescriptor;
                Descriptors.b unused2 = Box2D.internal_static_box2d_PbVec2_descriptor = Box2D.getDescriptor().p().get(0);
                GeneratedMessage.j unused3 = Box2D.internal_static_box2d_PbVec2_fieldAccessorTable = new GeneratedMessage.j(Box2D.internal_static_box2d_PbVec2_descriptor, new String[]{"X", "Y"}, PbVec2.class, PbVec2.Builder.class);
                Descriptors.b unused4 = Box2D.internal_static_box2d_PbFilter_descriptor = Box2D.getDescriptor().p().get(1);
                GeneratedMessage.j unused5 = Box2D.internal_static_box2d_PbFilter_fieldAccessorTable = new GeneratedMessage.j(Box2D.internal_static_box2d_PbFilter_descriptor, new String[]{"CategoryBits", "MaskBits", "GroupIndex"}, PbFilter.class, PbFilter.Builder.class);
                Descriptors.b unused6 = Box2D.internal_static_box2d_PbShape_descriptor = Box2D.getDescriptor().p().get(2);
                GeneratedMessage.j unused7 = Box2D.internal_static_box2d_PbShape_fieldAccessorTable = new GeneratedMessage.j(Box2D.internal_static_box2d_PbShape_descriptor, new String[]{"Tag", "Type", "Center", "Radius", "Points", "Normals", "Centroid", "V0", "V1", "V2", "V3", "Has0", "Has3", "Prev", "Next"}, PbShape.class, PbShape.Builder.class);
                Descriptors.b unused8 = Box2D.internal_static_box2d_PbFixture_descriptor = Box2D.getDescriptor().p().get(3);
                GeneratedMessage.j unused9 = Box2D.internal_static_box2d_PbFixture_fieldAccessorTable = new GeneratedMessage.j(Box2D.internal_static_box2d_PbFixture_descriptor, new String[]{"Tag", "Restitution", "Friction", "Density", "Sensor", "Filter", ComponentFactory.ComponentType.SHAPE}, PbFixture.class, PbFixture.Builder.class);
                Descriptors.b unused10 = Box2D.internal_static_box2d_PbJoint_descriptor = Box2D.getDescriptor().p().get(4);
                GeneratedMessage.j unused11 = Box2D.internal_static_box2d_PbJoint_fieldAccessorTable = new GeneratedMessage.j(Box2D.internal_static_box2d_PbJoint_descriptor, new String[]{"Tag", "Type", "BodyA", "BodyB", "CollideConnected", "LocalAnchorA", "LocalAnchorB", "RefAngle", "EnableLimit", "LowerLimit", "UpperLimit", "EnableMotor", "MotorSpeed", "MaxMotorTorque", "LocalAxisA", "MaxMotorForce", "Length", "Frequency", "DampingRatio", "GroundAnchorA", "GroundAnchorB", "LengthA", "LengthB", "Ratio", "Target", "MaxForce", "Joint1", "Joint2", "MaxTorque", "MaxLength", "Bodies", "Joints"}, PbJoint.class, PbJoint.Builder.class);
                Descriptors.b unused12 = Box2D.internal_static_box2d_PbBody_descriptor = Box2D.getDescriptor().p().get(5);
                GeneratedMessage.j unused13 = Box2D.internal_static_box2d_PbBody_fieldAccessorTable = new GeneratedMessage.j(Box2D.internal_static_box2d_PbBody_descriptor, new String[]{"Tag", "Type", "Position", "Angle", "LinearVelocity", "AngularVelocity", "LinearDamping", "AngularDamping", "GravityScale", "Bullet", "AllowSleep", "Awake", "Active", "FixedRotation", "Fixtures"}, PbBody.class, PbBody.Builder.class);
                Descriptors.b unused14 = Box2D.internal_static_box2d_PbWorld_descriptor = Box2D.getDescriptor().p().get(6);
                GeneratedMessage.j unused15 = Box2D.internal_static_box2d_PbWorld_fieldAccessorTable = new GeneratedMessage.j(Box2D.internal_static_box2d_PbWorld_descriptor, new String[]{"Tag", "Gravity", "AllowSleep", "AutoClearForces", "WarmStarting", "ContinuousPhysics", "SubStepping", "Bodies", "Joints"}, PbWorld.class, PbWorld.Builder.class);
                return null;
            }
        });
    }

    Box2D() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(r rVar) {
    }
}
