package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.AIDataOutputMode;
import org.light.lightAssetKit.enums.AnimationMode;
import org.light.lightAssetKit.enums.AvatarAnimojiMode;
import org.light.lightAssetKit.enums.AvatarBodyMode;
import org.light.lightAssetKit.enums.AvatarHandMode;
import org.light.lightAssetKit.enums.AvatarHeadRotationMode;
import org.light.lightAssetKit.enums.AvatarResourceLoadState;
import org.light.lightAssetKit.enums.ZPaiMode;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ZplanFilamentComponent extends Component {
    private AvatarResourceLoadState loadState = AvatarResourceLoadState.Undefined;
    private ArrayList<ExtraActor> extraActors = new ArrayList<>();
    private ArrayList<AvatarCharacter> characters = new ArrayList<>();
    private AvatarAnimojiMode animojiDriveMode = AvatarAnimojiMode.kDisable;
    private AvatarBodyMode bodyDriveMode = AvatarBodyMode.kDisable;
    private AvatarHeadRotationMode headRotationMode = AvatarHeadRotationMode.kFace2D;
    private AvatarHandMode handDriveMode = AvatarHandMode.kDisable;
    private String configJson = "";
    private String avatarInfoJson = "";
    private AnimationMode animationMode = AnimationMode.kDisable;
    private ZPaiMode zpaiMode = ZPaiMode.kDisable;
    private AIDataOutputMode aiDataOutputMode = AIDataOutputMode.kDisable;
    private ArrayList<Integer> charactersStateGenderJSInfo = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof ZplanFilamentComponent) {
            ZplanFilamentComponent zplanFilamentComponent = (ZplanFilamentComponent) componentBase;
            this.loadState = zplanFilamentComponent.loadState;
            this.extraActors = zplanFilamentComponent.extraActors;
            this.characters = zplanFilamentComponent.characters;
            this.animojiDriveMode = zplanFilamentComponent.animojiDriveMode;
            this.bodyDriveMode = zplanFilamentComponent.bodyDriveMode;
            this.headRotationMode = zplanFilamentComponent.headRotationMode;
            this.handDriveMode = zplanFilamentComponent.handDriveMode;
            this.configJson = zplanFilamentComponent.configJson;
            this.avatarInfoJson = zplanFilamentComponent.avatarInfoJson;
            this.animationMode = zplanFilamentComponent.animationMode;
            this.zpaiMode = zplanFilamentComponent.zpaiMode;
            this.aiDataOutputMode = zplanFilamentComponent.aiDataOutputMode;
            this.charactersStateGenderJSInfo = zplanFilamentComponent.charactersStateGenderJSInfo;
        }
        super.doUpdate(componentBase);
    }

    public AIDataOutputMode getAiDataOutputMode() {
        return this.aiDataOutputMode;
    }

    public AnimationMode getAnimationMode() {
        return this.animationMode;
    }

    public AvatarAnimojiMode getAnimojiDriveMode() {
        return this.animojiDriveMode;
    }

    public String getAvatarInfoJson() {
        return this.avatarInfoJson;
    }

    public AvatarBodyMode getBodyDriveMode() {
        return this.bodyDriveMode;
    }

    public ArrayList<AvatarCharacter> getCharacters() {
        return this.characters;
    }

    public ArrayList<Integer> getCharactersStateGenderJSInfo() {
        return this.charactersStateGenderJSInfo;
    }

    public String getConfigJson() {
        return this.configJson;
    }

    public ArrayList<ExtraActor> getExtraActors() {
        return this.extraActors;
    }

    public AvatarHandMode getHandDriveMode() {
        return this.handDriveMode;
    }

    public AvatarHeadRotationMode getHeadRotationMode() {
        return this.headRotationMode;
    }

    public AvatarResourceLoadState getLoadState() {
        return this.loadState;
    }

    public ZPaiMode getZpaiMode() {
        return this.zpaiMode;
    }

    public void setAiDataOutputMode(AIDataOutputMode aIDataOutputMode) {
        this.aiDataOutputMode = aIDataOutputMode;
        reportPropertyChange("aiDataOutputMode", aIDataOutputMode);
    }

    public void setAnimationMode(AnimationMode animationMode) {
        this.animationMode = animationMode;
        reportPropertyChange("animationMode", animationMode);
    }

    public void setAnimojiDriveMode(AvatarAnimojiMode avatarAnimojiMode) {
        this.animojiDriveMode = avatarAnimojiMode;
        reportPropertyChange("animojiDriveMode", avatarAnimojiMode);
    }

    public void setAvatarInfoJson(String str) {
        this.avatarInfoJson = str;
        reportPropertyChange("avatarInfoJson", str);
    }

    public void setBodyDriveMode(AvatarBodyMode avatarBodyMode) {
        this.bodyDriveMode = avatarBodyMode;
        reportPropertyChange("bodyDriveMode", avatarBodyMode);
    }

    public void setCharacters(ArrayList<AvatarCharacter> arrayList) {
        this.characters = arrayList;
        reportPropertyChange("characters", arrayList);
    }

    public void setCharactersStateGenderJSInfo(ArrayList<Integer> arrayList) {
        this.charactersStateGenderJSInfo = arrayList;
        reportPropertyChange("charactersStateGenderJSInfo", arrayList);
    }

    public void setConfigJson(String str) {
        this.configJson = str;
        reportPropertyChange("configJson", str);
    }

    public void setExtraActors(ArrayList<ExtraActor> arrayList) {
        this.extraActors = arrayList;
        reportPropertyChange("extraActors", arrayList);
    }

    public void setHandDriveMode(AvatarHandMode avatarHandMode) {
        this.handDriveMode = avatarHandMode;
        reportPropertyChange("handDriveMode", avatarHandMode);
    }

    public void setHeadRotationMode(AvatarHeadRotationMode avatarHeadRotationMode) {
        this.headRotationMode = avatarHeadRotationMode;
        reportPropertyChange("headRotationMode", avatarHeadRotationMode);
    }

    public void setLoadState(AvatarResourceLoadState avatarResourceLoadState) {
        this.loadState = avatarResourceLoadState;
        reportPropertyChange("loadState", avatarResourceLoadState);
    }

    public void setZpaiMode(ZPaiMode zPaiMode) {
        this.zpaiMode = zPaiMode;
        reportPropertyChange("zpaiMode", zPaiMode);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "ZplanFilamentComponent";
    }
}
